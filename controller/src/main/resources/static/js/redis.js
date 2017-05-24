function bindsubmitClick() {
    <!--绑定提交查询的事件-->
    $("#form-actions-submit").unbind("click");
    $("#form-actions-submit").bind("click",function () {
        ip=$("#form-field-ip").val();
        port=$("#form-field-port").val();
        db=$("#form-field-db").val();
        key=$("#form-field-key").val();
        cmd=$("#form-field-select-cmd").val();
        var data={ip:ip,port:port,db:db,cmd:cmd,key:key};

        data=appendData(data);

        $.ajax({
            url:'/manager/redis/do',
            type:'post',
            dataType:'json',
            data:data,
            success:function(result){
                $("#selectResultBox").show();
                var content='';
                for(var key in result.map){
                    content+=key+"<br/>";
                    content+=result.map[key]+"<div class='space-6'></div>"
                }

                $("#selectResultDiv").html(content);
                $("#wasteTime").html(result.wasteTime+"ms");



            }});
    });
}

function selectCmdChange() {
    var cmd = $(this).children('option:selected').val();

    $.each( $("div[id^='other-div']"), function(i, n){
        $(n).hide();
        $(n).val('');
    });

    switch(cmd) {
        case 'set':{
            $("#other-div-value").show();
            break;
        }
        case 'hget':{
            $("#other-div-field").show();
            $("#form-field-field").val('支持批量获取,以","进行分割');
            break;
        }
        case 'hset':{
            $("#other-div-field").show();
            $("#other-div-value").show();
            break;
        }
        case 'zrange':{
            $("#other-div-zrange").show();
            break;
        }
    }
}

function appendData(data) {

    var cmd = $("#form-field-select-cmd").children('option:selected').val();


    switch(cmd) {
        case 'set':{

            data['valueStr']=$("#form-field-value").val();

            break;
        }
        case 'hget':{

            data['field']=$("#form-field-field").val();

            break;
        }
        case 'hset':{

            data['field']=$("#form-field-field").val();

            data['valueStr']=$("#form-field-value").val();

            break;
        }
        case 'zrange':{

            data['field']=$("#form-field-field").val();

            data['start']=$("#form-field-star").val();

            data['end']=$("#form-field-end").val();

            break;
        }
    }

    return data;

}
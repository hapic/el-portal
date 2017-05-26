var cmd;
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

        //清空之前的结果
        $("#selectResultDiv").html('');
        $("#selectResultSpan").hide();
        $("#selectResultSpan").html('');

        $.ajax({
            url:'/manager/redis/do',
            type:'post',
            dataType:'json',
            data:data,
            success:function(result){
                $("#selectResultBox").show();

                var content='';
                for(var key in result.map){
                    if(cmd=='scan' && key=='nextCursor'){
                        $("#selectResultSpan").html("下个游标为:"+result.map[key]);
                        $("#selectResultSpan").show();
                        continue;
                    }
                    if(key!='-'){
                        content+=key+"<br/>";
                    }
                    if(cmd=='scan'){
                        content+="<div class='space-6'></div>"
                    }else{
                        content+=result.map[key]+"<div class='space-6'></div>"
                    }

                }

                $("#selectResultDiv").html(content);
                $("#wasteTime").html(result.wasteTime+"ms");



            }});
    });
}


function bindtextClick() {
    <!--绑定提交查询的事件-->
    $("#form-actions-text").unbind("click");
    $("#form-actions-text").bind("click",function () {
        ip=$("#form-field-ip").val();
        port=$("#form-field-port").val();
        var data={ip:ip,port:port,cmd:'ping',db:0};


        $.ajax({
            url:'/manager/redis/do',
            type:'post',
            dataType:'json',
            data:data,
            success:function(result){
                $("#selectResultBox").show();
                var content="test fail !";
                if("pong"==result.map['-'] || "PONG"==result.map['-']){
                    $("#form-actions-submit").removeAttr('disabled');
                    $("#form-actions-submit").addClass('btn-success');
                    content="test success!";
                    bindsubmitClick();
                }else{
                    $("#form-actions-submit").unbind("click");
                    $("#form-actions-submit").attr('disabled',"disabled");
                    $("#form-actions-submit").removeClass('btn-success');
                }

                $("#selectResultDiv").html(content);
                $("#wasteTime").html(result.wasteTime+"ms");
            }});
    });
}



function selectCmdChange() {
    cmd = $(this).children('option:selected').val();

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
        case 'sismember':{
            $("#other-div-field").show();
            break;
        }
        case 'scan':{
            $("#other-div-scan").show();
            $("#other-div-scan-2").show();
            break;
        }
    }
}
var numReg = new RegExp("^[0-9]+$");
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

            data['start']=$("#form-field-start").val();
            if(!data['start']){
                data['start']=0;
            }

            data['end']=$("#form-field-end").val();
            if(!data['end']){
                data['end']=1;
            }


            break;
        }
        case 'sismember':{

            data['field']=$("#form-field-field").val();

            break;
        }
        case 'scan':{

            data['key']=$("#form-field-key").val();
            data['cursor']=cursor=$("#form-field-cursor").val();
            data['count']=count=$("#form-field-count").val();
            if(!numReg.test(cursor)){
                $("#form-field-cursor").val(0);
                data['cursor']=0;
            }
            if(!numReg.test(count)){
                $("#form-field-count").val(20);
                data['count']=100;
            }

            break;
        }
    }

    return data;

}
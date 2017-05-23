<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>redis</title>
    <meta name="keywords" content="EL-portal" />
    <meta name="description" content="EL-portal" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>
<div class="page-content" id="page-content">

    <div class="row">
        <div class="col-sm-5">
            <div class="widget-box">
                <div class="widget-header">
                    <h4>Redis服务</h4>
                </div>

                <div class="widget-body">
                    <div class="widget-main no-padding">
                        <form class="form-horizontal">

                            <fieldset>
                                <!--ip地址-->
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-ip"> IP </label>

                                    <div class="col-sm-9">
                                        <input type="text" value="192.168.2.16" id="form-field-ip" placeholder="ip" class="col-xs-10 col-sm-7" />
                                    </div>

                                </div>
                                <!--端口地址-->
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-port"> Port </label>

                                    <div class="col-sm-9">
                                        <input type="text" value="6379" id="form-field-port" placeholder="port" class="col-xs-10 col-sm-7" />
                                    </div>
                                </div>
                                <!--DB索引库-->
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-db"> DB </label>

                                    <div class="col-sm-9">
                                        <input type="text" value="0" id="form-field-db" placeholder="DB" class="col-xs-10 col-sm-7" />
                                    </div>
                                </div>

                                <!--命令-->
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-select-cmd"> cmd </label>

                                    <div class="col-sm-9">
                                        <select class="width-60 chosen-select" id="form-field-select-cmd" data-placeholder="输入查询的命令">
                                            <option value="get">get</option>
                                            <option value="ttl">ttl</option>
                                            <option value="hget">hget</option>
                                            <option value="exists">exists</option>
                                        </select>
                                    </div>
                                </div>

                                <!--key-->
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-key"> Key </label>

                                    <div class="col-sm-9">
                                        <input type="text" value="aa" id="form-field-key" placeholder="Key" class="col-xs-10 col-sm-7" />
                                    </div>
                                </div>

                            </fieldset>

                            <div class="form-actions center">
                                <button id="form-actions-submit" type="button" class="btn btn-sm btn-success">
                                    提交
                                    <i class="icon-arrow-right icon-on-right bigger-110"></i>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-6 hidden">
            <div class="well">
                <h4 class="green smaller lighter">查询结果:</h4>
            </div>
        </div>

    </div>
</div>
</body>
<script type="application/javascript">
    jQuery(function($) {
        $(".chosen-select").chosen();

        <!--绑定提交查询的事件-->
        $("#form-actions-submit").unbind("click");
        $("#form-actions-submit").bind("click",function () {
            ip=$("#form-field-ip").val();
            port=$("#form-field-port").val();
            db=$("#form-field-db").val();
            key=$("#form-field-key").val();
            cmd=$("#form-field-select-cmd").val();

            $.ajax({
                url:'/manager/redis/do',
                type:'post',
                data:{ip:ip,port:port,db:db,key:key,cmd:cmd},
                success:function(result){
                    $("#page-content").html(result);
                }});


        });
    });
</script>
</html>

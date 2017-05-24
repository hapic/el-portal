<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>redis</title>
    <meta name="keywords" content="EL-portal" />
    <meta name="description" content="EL-portal" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<link rel="stylesheet" href="assets/css/chosen.css" />

<script src="assets/js/chosen.jquery.min.js"></script>
<script src="assets/js/fuelux/fuelux.spinner.min.js"></script>
<script  src="/js/redis.js"/>
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
                                        <input type="text" value="6380" id="form-field-port" placeholder="port" class="col-xs-10 col-sm-7" />
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
                                        <select class="width-55 chosen-select" id="form-field-select-cmd" data-placeholder="输入查询的命令">


                                            <option value="ttl">ttl</option>

                                            <option value="exists">exists</option>
                                            <option value="type">type</option>

                                            <option value="get">get</option>
                                            <option value="set">set</option>

                                            <option value="llen">llen</option>

                                            <option value="hget">hget</option>
                                            <option value="hset">hset</option>
                                            <option value="hlen">hlen</option>


                                            <option value="zrange">zrange</option>

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
                                <div class="form-group" id="other-div-field" style="display:none;">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-field"> field </label>

                                    <div class="col-sm-9">
                                        <input type="text" value="field" id="form-field-field" placeholder="field" class="col-xs-10 col-sm-7" />

                                    </div>
                                </div>

                                <div class="form-group" id="other-div-value" style="display:none;">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-value"> value </label>

                                    <div class="col-sm-6">
                                        <textarea class="form-control" id="form-field-value" placeholder="value" value="value"></textarea>
                                    </div>
                                </div>

                                <div class="form-group" id="other-div-range" style="display:none;">
                                    <label class="col-sm-3 control-label no-padding-right"> 区间 </label>
                                    <div class="col-sm-5">
                                        <input type="text" class="input-small" placeholder="start" id="form-field-start" />-
                                        <input type="text" class="input-small" placeholder="end" id="form-field-end"/>

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

        <div id="selectResultBox" class="col-sm-6" style="display: none">
            <div class="well">
                <h4 class="green smaller lighter">查询结果: </h4>
                <div id="selectResultDiv">

                </div>
            </div>
            <div class="well well-sm"> 耗时:<span id="wasteTime"></span> </div>
        </div>

    </div>
</div>
</body>

<script type="text/javascript">
    jQuery(function($) {
        $(".chosen-select").chosen();
        $('#form-field-select-cmd').change(selectCmdChange);
    });
    bindsubmitClick();
</script>
</html>

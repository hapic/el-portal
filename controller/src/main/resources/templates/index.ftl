<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <#include "inc/ico.ftl"/>

    <title>翼龙网址导航</title>
    <link href="/cssn/sub_v3202.css?V=20120227165354_5" rel="stylesheet" type="text/css" />
    <style type="text/css">
        body{line-height:normal;}#wrapper{width:960px;}.s_main{width:958px;border:1px solid #9ED4FF;background:#D8E8F7;}.s_main h1{background:#DBEEFD;color:#333333;font-size:14px;line-height:24px;padding:0 10px;}.cbox{border-bottom:1px solid #FFFFFF;border-collapse:collapse;border-top:1px solid #FFFFFF;margin-bottom:6px;width:100%;background:#fff;}.cbox th{background:#E9F2FB;border-right:1px solid #D8E8F7;text-align:center;width:100px;font-size:14px;}.ccont{font-size:14px;line-height:40px;}.ccont li{width:130px;height:40px;border-top:1px solid #eee;padding:0 9px 0 30px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;display:block;float:left;}.ccont li.top{border:0px none;}.clearfix{clear:both;height:10px;}.title1 strong{padding:0 25px;}.s_maind{width:950px;}.cboxd{background:#fff;clear:both;border:1px solid #BCD2E6;margin-bottom:9px;}.ccontd{padding:18px 0 0 25px;font-size:14px;line-height:20px;}.ccontd li{width:178px;height:20px;margin:0 6px 12px 0;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;display:block;float:left;}
        .news {width:600px;position:relative;top:0;left:50%;margin-left:-300px;}
        .news .news-title {overflow:hidden;position:relative;}
        .news #showOrHide {position:absolute; top:50%; right:10px;}
        #center_9 {
            background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
            border: medium none;
            height: 46px;
            text-align: center;
            width: 960px;
        }
    </style>

</head>
<body>
<div id="header">
    <div id="logo" pbflag="logo">
        <a href="http://www.eloancn.com" class="logo" id="logo_123"></a>
    </div>
    <div style="margin-top: 10px; float: left;">
        <a href="test.html">
            <span style="  font-size: 30px;">测试环境</span>
        </a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="index.ftl">
            <span style="color: red;  font-size: 30px;">生产环境</span>
        </a>

    </div>


</div>

<div id="subm">
    <div class="subc">
        <div class="subbox subb0 subbfr">
            <h2 class="subtt">平台分享组</h2>
            <ul pbflag="" class="subct" style="height:120px">
                <li><a target="_blank" title="cat监控" href="http://cat.internal.eloancn.com/cat">CAT监控</a></li>
                <li><a target="_blank" title="Codis控制平台" href="#">Codis DashBoard</a></li>
                <li><a target="_blank" title="dubbo管理控制台" href="http://dubbo.internal.eloancn.com">dubbo管理控制台</a></li>
                <li><a target="_blank" title="定时任务控制面板" href="http://esjob.internal.eloancn.com">esjob Console</a></li>
                <li><a target="_blank" title="统一配置中心" href="http://disconf.eloancn.com">配置中心</a></li>
                <li><a target="_blank" title="RabbitMQ控制台" href="http://mq.internal.eloancn.com">RabbitMQ控制台</a></li>
                <li><a target="_blank" title="中间件监控平台" href="http://falcon.internal.eloancn.com/">Falcon DashBoard</a></li>
                <li><a target="_blank" title="中间件报警配置平台" href="http://ops.internal.eloancn.com/">OpsPlatform</a></li>
                <li><a target="_blank" title="统一日志查询" href="http://ulog.eloancn.com">统一日志查询<span class="">*</span></a></li>
                <li><a target="_blank" title="rabbitmq报警系统" href="http://rabbitmq.supervise.el.com/login.action">rabbitmq报警系统<span class="">*</span></a></li>
                <li><a target="_blank" title="流水号校验系统" href="serial.html">流水号校验系统<span class="">*</span></a></li>

                <li><a target="_blank" title="资金中台" href="https://manager.eloancn.com/modules/home.html">资金中台<span class="">*</span></a></li>
                <li><a target="_blank" title="CRM" href="http://kf.eloancn.com/sys/auth/queryAllMenu.html">CRM<span class="">*</span></a></li>
                <li><a target="_blank" title="Manager修复中心" href="http://transmanager.internal.eloancn.com/login_toLogin.do">Manager修复中心<span class="">*</span></a></li>


            </ul>
        </div>
        <div class="subbox subb1 ">
            <h2 class="subtt">Solr平台</h2>
            <ul pbflag="" class="subct" style="height:80px">
                <li><a target="_blank" title="交易流水" href="http://wstfund.internal.eloancn.com">交易流水</a></li>
                <li><a target="_blank" title="发息" href="http://wstday.internal.eloancn.com">发息</a></li>
                <li><a target="_blank" title="购买记录" href="http://wstbuy.internal.eloancn.com">购买记录</a></li>
                <li><a target="_blank" title="债权记录" href="http://wsttender.internal.eloancn.com">债权记录</a></li>
                <li><a target="_blank" title="私人订制" href="http://debtbuy.internal.eloancn.com">私人订制</a></li>
                <li><a target="_blank" title="银行支行信息查询" href="http://10.1.114.62:8880/solr">银行支行信息查询</a></li>

            </ul>
        </div>
        <div class="subbox subb0 ">
            <h2 class="subtt">运维监控</h2>
            <ul pbflag="wc_489_武器装备" class="subct" style="height:40px">
                <li><a target="_blank" title="" href="#">zabbix</a></li>
                <li><a target="_blank" title="" href="#">Haproxy Console</a></li>
            </ul>
        </div>

    </div>

    <div id="center_8" class="center" style="">
        <div style="">
            <a href="javascript:;" id="showOrHide">↓查看Host配置</a>
        </div>
        <div id="content" style="display: none;margin-top: 5px;">
            <ul pbflag="wc_489" class="" style="height:40px;">
                <li>192.168.10.73 disconf.eloancn.com</li>
                <li>10.1.112.176 newdisconf.eloancn.com</li>
                <li>10.1.112.82 ulog.el.com</li>
                <li>10.1.112.82 rabbitmq.supervise.el.com</li>
            </ul>
        </div>

        <br/>


    </div>




    <div id="center_9" class="center" pbflag="footer">
        <div id="footer">
            <a href="http://www.eloancn.com" id="ft_about" target="_blank">关于我们</a>&nbsp;&nbsp;|&nbsp;&nbsp;
            <a href="http://www.eloancn.com">返回首页</a>&nbsp;&nbsp;Welcome! &nbsp; 网址导航&nbsp;
            <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010802020825" target="_blank" id="ft_icp">京公网安备11010802020825号</a>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.onload =function(){
        document.getElementById("showOrHide").onclick = function(){
            var news = document.getElementById("content");
            if(typeof(news) != "undefined" ){
                news.style.display = (news.style.display.toLowerCase()=="none") ? "":"none";
                this.innerHTML = (news.style.display.toLowerCase()=="none") ? "↓查看Host配置" : "↑收齐Host配置";
            }
        };
    }
</script>
</body>
</html>
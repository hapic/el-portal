<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>EL Portal</title>
<meta name="keywords" content="EL-portal" />
<meta name="description" content="EL-portal" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- basic styles -->
<link href="/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="/assets/css/font-awesome.min.css" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->



<link rel="stylesheet" href="/assets/css/ace.min.css" />
<link rel="stylesheet" href="/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="/assets/css/ace-skins.min.css" />

    <link rel="stylesheet" href="assets/css/chosen.css" />


<!--[if lte IE 8]>
		  <link rel="stylesheet" href="/assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->

<script src="/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		<script src="/assets/js/html5shiv.js"></script>
		<script src="/assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body>
<div class="navbar navbar-default" id="navbar"> 
  <script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>
  <div class="navbar-container" id="navbar-container">
    <div class="navbar-header pull-left"> <a href="#" class="navbar-brand"> <small> <i class="icon-leaf"></i> EL PORTAL 管理系统 </small> </a><!-- /.brand --> 
    </div>
    <!-- /.navbar-header -->
    
    
    <!-- /.navbar-header --> 
  </div>
  <!-- /.container --> 
</div>
<div class="main-container" id="main-container"> 
<script type="text/javascript">
try{ace.settings.check('main-container' , 'fixed')}catch(e){}
</script>
  <div class="main-container-inner"> <a class="menu-toggler" id="menu-toggler" href="#"> <span class="menu-text"></span> </a>
    <div class="sidebar" id="sidebar"> 
      
      
      <ul class="nav nav-list">
        <li class="active"> <a href="/manager"> <i class="icon-dashboard"></i> <span class="menu-text"> 控制台 </span> </a> </li>

        <li> <a href="#" class="dropdown-toggle"> <i class="icon-desktop"></i> <span class="menu-text"> 中间件 </span> <b class="arrow icon-angle-down"></b> </a>
          <ul class="submenu">
            <li> <a href="javascript:loadPage('/manager/redis/page')"> <i class="icon-double-angle-right"></i> Redis查询 </a> </li>
          </ul>
        </li>
      </ul>
      <!-- /.nav-list -->
      
      <div class="sidebar-collapse" id="sidebar-collapse"> <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i> </div>
      
    </div>
    <div class="main-content">
      <div class="breadcrumbs" id="breadcrumbs"> 
        <script type="text/javascript">try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}</script>
        <ul class="breadcrumb">
          <li> <i class="icon-home home-icon"></i> <a href="#">首页</a> </li>
          <li class="active">控制台</li>
        </ul>
      </div>
      <div class="page-content" id="page-content">

      </div>

    </div>
  </div>
 </div>
<!-- basic scripts -->

<!--[if !IE]> -->
<script src="/assets/js/jquery-2.0.3.min.js"></script>
<!-- <![endif]-->
<!--[if IE]>
<script src="/assets/js/jquery-1.10.2.min.js"></script>
<![endif]-->
<!--[if !IE]> -->
<script type="text/javascript">
window.jQuery || document.write("<script src='/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
</script>
<!-- <![endif]-->
<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='/assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->
<script type="text/javascript">
if("ontouchend" in document) document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
</script> 
<script src="/assets/js/bootstrap.min.js"></script> 
<script src="/assets/js/typeahead-bs2.min.js"></script> 
<!-- page specific plugin scripts -->
<!--[if lte IE 8]>
<script src="/assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="/assets/js/jquery-ui-1.10.3.custom.min.js"></script> 
<script src="/assets/js/jquery.ui.touch-punch.min.js"></script> 
<script src="/assets/js/jquery.slimscroll.min.js"></script> 
<script src="/assets/js/jquery.easy-pie-chart.min.js"></script> 
<script src="/assets/js/jquery.sparkline.min.js"></script> 
<script src="/assets/js/flot/jquery.flot.min.js"></script> 
<script src="/assets/js/flot/jquery.flot.pie.min.js"></script> 
<script src="/assets/js/flot/jquery.flot.resize.min.js"></script>


<!-- ace scripts --> 

<script src="/assets/js/ace-elements.min.js"></script> 
<script src="/assets/js/ace.min.js"></script>


<!-- inline scripts related to this page -->

</body>


<script type="application/javascript">

    $.each( $("div[id^='other-div']"), function(i, n){
        $(n).hide();
        $(n).val('');
    });

    function loadPage(pageUrl) {

        $.ajax({
            url:pageUrl,
            dataType:'html',
            success:function(result){
            $("#page-content").html(result);
        }});
    }





</script>
</html>

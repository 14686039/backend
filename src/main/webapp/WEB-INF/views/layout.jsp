<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0">
  <meta charset="utf-8">
  <!-- Always force latest IE rendering engine or request Chrome Frame -->
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
  <!-- Use title if it's in the page YAML frontmatter -->
  <title>家校通管理系统</title>
  <link href="${base}/assets/css/bootstrap.css" rel="stylesheet">
  <link href="${base}/assets/css/bootstrap-responsive.css" rel="stylesheet">
  <link href="${base}/css/jxt.css" rel="stylesheet">
</head>
<body>
	<!-- 初始化掩藏域 -->
	<input type="hidden" id="current-header-tab" value="base-info"/>
	<input type="hidden" id="current-slide-menu" value="silde-nav-menu-base-info"/>
	<input type="hidden" id="current-content" value="base-info"/>
	<!-- S 顶部导航 -->
	<div class="navbar navbar-top navbar-inverse">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="brand" href="#">LOOOOGOOOO</a>
			    <ul class="nav">
			        <li class="head-link active" ><a href="#base-info"><i class=" icon-th-large"></i>基础信息</a></li>
			        <li class="head-link"><a href="#notify-mgr"><i class="icon-bell"></i>通知管理</a></li>
			        <li class="head-link"><a href="#edu-info"><i class="icon-rss"></i>教育资讯</a></li>
			    	<li class="head-link"><a href="#stu-job"><i class="icon-tasks"></i>学生作业</a></li>
			    	<li class="head-link"><a href="#weixin-mgr"><i class="icon-comments"></i>微信管理</a></li>
					
			    </ul>
      			<!-- the new toggle buttons -->
		        <ul class="nav pull-right">
		            <li class="toggle-sidebar hidden-desktop"><a><i class="icon-list-alt"></i></a></li>
		            <li class="toggle-primary-sidebar hidden-desktop hidden-tablet"><a><i class="icon-th-list"></i></a></li>
		            <li class="collapsed hidden-desktop" data-toggle="collapse" data-target=".nav-collapse"><a><i class="icon-align-justify"></i></a></li>
		        </ul>
				<div class="nav-collapse">
			    	<ul class="nav full pull-right">
			        	<li class="dropdown user-avatar">
				            <!-- the dropdown has a custom user-avatar class, this is the small avatar with the badge -->
				            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				              <span>
				                <img class="menu-avatar" src="${base }/img/1.jpg" /> <span>唐顺 <i class="icon-caret-down"></i></span>
				                <span class="badge badge-dark-red">5</span>
				              </span>
				            </a>
				            <ul class="dropdown-menu">
				            	<!-- the first element is the one with the big avatar, add a with-image class to it -->
				            	<li class="with-image">
				            		<div class="avatar">
				            			<img src="${base }/img/1.jpg" />
				            		</div>
				          			<span>老唐</span>
				           		</li>
				            	<li class="divider"></li>
				            	<li   id="per-info"><a href="#"><i class="icon-user"></i> <span>个人资料</span></a></li>
				            	<li ><a href="#"><i class="icon-cog"></i> <span>账户设置</span></a></li>
				            	<li ><a href="#"><i class="icon-envelope"></i> <span>消息</span> <span class="label label-dark-red pull-right">5</span></a></li>
				            	<li ><a href="#"><i class="icon-off"></i> <span>退出</span></a></li>
				            </ul>
			       		</li>
			        </ul>
			      </div>
			</div>
		</div>
	</div>
	<!-- E 顶部导航 -->

	<!-- S 侧边栏背景 -->
	<div class="sidebar-background"></div>
	<!-- E 侧边栏背景 -->

	<!-- S 侧边栏导航 -->
	<div class="sidebar">
		<div class="area-top">
	        <ul class="inline">
	        	<li>
		            <div class="avatar">
		              <img src="${base }/img/1.jpg">
		            </div>
	        	</li>
	       		<li>
		            欢迎您
		            <div class="title">唐校长</div>
	       		</li>
	        </ul>
	    </div>
	    <div class="divider"><span></span></div>
	    <!-- silde-show-or-hide来控制显示还是掩藏 -->
		<ul id="silde-nav-menu-base-info" class="nav nav-list bs-docs-sidenav silde-show-or-hide">
       		<li class="slide-nav-menu active" id="welcome"><a href="#"><i class="icon-home"></i><i class="icon-chevron-right"></i>欢迎页</a></li>
      		<li class="slide-nav-menu" id="area"><a href="#"><i class="icon-reorder"></i><i class="icon-chevron-right"></i>区域 </a></li>
       		<li class="slide-nav-menu" id="school"><a href="#"><i class="icon-sitemap"></i><i class="icon-chevron-right"></i>学校</a></li>
       		<li class="slide-nav-menu" id="alliance"><a href="#"><i class="icon-sitemap"></i><i class="icon-chevron-right"></i>加盟商</a></li>
      		<li class="slide-nav-menu"><a href="#"><i class="icon-th-large"></i><i class="icon-chevron-right"></i>年级</a></li>
     		<li class="slide-nav-menu"><a href="#"><i class="icon-th"></i><i class="icon-chevron-right"></i>班级</a></li>
     		<li class="slide-nav-menu"><a href="#"><i class="icon-th-list"></i><i class="icon-chevron-right"></i>学段</a></li>
     		<li class="slide-nav-menu"><a href="#"><i class="icon-th-large"></i><i class="icon-chevron-right"></i>组织</a></li>
     		<li class="slide-nav-menu"><a href="#"><i class="icon-user-md"></i><i class="icon-chevron-right"></i>学生</a></li>
     		<li class="slide-nav-menu"><a href="#"><i class="icon-user"></i><i class="icon-chevron-right"></i>老师</a></li>
     		<li class="slide-nav-menu"><a href="#"><i class="icon-star-empty"></i><i class="icon-chevron-right"></i>角色</a></li>
     		<li class="slide-nav-menu"><a href="#"><i class="icon-group"></i><i class="icon-chevron-right"></i>群组</a></li>
        </ul>
        <ul id="silde-nav-menu-notify-mgr" class="nav nav-list bs-docs-sidenav silde-show-or-hide">
       		<li class="slide-nav-menu active"><a href="#"><i class="icon-home"></i><i class="icon-chevron-right"></i>新增通知</a></li>
      		<li class="slide-nav-menu"><a href="#"><i class="icon-reorder"></i><i class="icon-chevron-right"></i>通知追踪 </a></li>
        </ul>
        <ul id="silde-nav-menu-edu-info" class="nav nav-list bs-docs-sidenav silde-show-or-hide">
       		<li class="slide-nav-menu active"><a href="#"><i class="icon-home"></i><i class="icon-chevron-right"></i>新增资讯</a></li>
      		<li class="slide-nav-menu"><a href="#"><i class="icon-reorder"></i><i class="icon-chevron-right"></i>资讯追踪 </a></li>
        </ul>
        <ul id="silde-nav-menu-stu-job" class="nav nav-list bs-docs-sidenav silde-show-or-hide">
       		<li class="slide-nav-menu active"><a href="#"><i class="icon-home"></i><i class="icon-chevron-right"></i>新增学生作业</a></li>
      		<li class="slide-nav-menu"><a href="#"><i class="icon-reorder"></i><i class="icon-chevron-right"></i>作业追踪</a></li>
        </ul>
        <ul id="silde-nav-menu-weixin-mgr" class="nav nav-list bs-docs-sidenav silde-show-or-hide">
       		<li class="slide-nav-menu active"><a href="#"><i class="icon-home"></i><i class="icon-chevron-right"></i>微信管理</a></li>
      		<li class="slide-nav-menu"><a href="#"><i class="icon-reorder"></i><i class="icon-chevron-right"></i>发送消息</a></li>
        </ul>
        
	</div>
	<!-- E 侧边栏导航 -->

	<!-- S 主要内容区域 -->
	<div class="main-content">
		<div class="container-fluid">
		    <div class="row-fluid">
				<div class="area-top">
			        <div class="pull-left header">
			        	<i class="icon-edit icon-2x"></i>
			       		<span id="content-title" class="title">主要内容区域</span>
			        </div>
			        <ul id="content-stat" class="num-stats pull-right">
			        	<li class="stat-red">
			        		<ul class="inline">
			         			<li class="hidden-phone glyph">
			           				<i class="icon-money"></i>
			          			</li>
			           			<li>
			                		<span class="number">533</span> 教师人数
			              		</li>
			            	</ul>
			      		</li>
					   	<li class="stat-green">
					        <ul class="inline">
					       		<li class="hidden-phone glyph">
					        		<i class="icon-ok-circle"></i>
					      		</li>
					   			<li>
					       			<span class="number">1513</span> 学生人数
					       		</li>
					        </ul>
						</li>
						
			        	
			        </ul>
				</div>
		    </div>
		    <div class="row-fluid">
		  		<div class="breadcrumb-line navbar">
			        <ul id="content-breadcrumbs" class="breadcrumbs pull-left">
			      		<li><i class="icon-home"></i>基础信息</li>
			    		<li class="current"><i class="icon-edit"></i> 欢迎页</li>
			        </ul>
				</div>
		    </div>
  		</div>
  		<div class="container-fluid hpadded">
			<div class="row-fluid">
				<div class="span12"  id="content-right">
					
					
					<!-- S 表格内容 -->
					<!-- 这里数据采用模版填充 -->
					<!-- E 表格内容 -->
						
						
					</div>
				</div>
			</div>
		</div>
	<!-- E 主要内容区域 -->

	<!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <!-- 通过CAT合并 UGLIFY 压缩BOOTSTRAP内置JS插件 包含以下文件 
    jquery.js bootstrap-transition.js bootstrap-alert.js bootstrap-modal.js bootstrap-dropdown.js bootstrap-scrollspy.js bootstrap-tab.js bootstrap-tooltip.js bootstrap-popover.js bootstrap-button.js bootstrap-collapse.js bootstrap-carousel.js bootstrap-typeahead.js bootstrap-datepicker.js bootstrap-datepicker.zh-CN.js-->
    <script src="${base}/assets/js/bootstrap.min.js"></script>



    <!-- 表单美化插件 -->
    <script src="${base}/assets/js/jquery.uniform.js"></script>
    <!-- 非常强大的SELECT插件 http://ivaynberg.github.io/select2/ -->
    <script src="${base}/assets/js/select2.js"></script>
    <!-- jquery 日历插件 -->
    <script src="${base}/assets/js/jquery.validationEngine.js"></script>
    <script src="${base}/assets/js/jquery.validationEngine-zh_CN.js"></script>
    <!-- 用来生成静态或动态波谱图表效果 -->
    <script src="${base}/assets/js/jquery.sparkline.js"></script>
    <!-- 多功能表格插件 -->
    <script src="${base}/assets/js/jquery.dataTables.js"></script>
    <!-- 相册 支持TOUCH -->
    <script src="${base}/assets/js/touchTouch.jquery.js"></script>
    <!-- 泡泡消息 -->
    <script src="${base}/assets/js/jquery.gritter.js"></script>
    <!-- highcharts绘图 包含highcharts.js exporting.js -->
    <script src="${base}/assets/js/highcharts.js"></script>
    <script src="${base}/assets/js/exporting.js"></script>
    <!-- 加载模版 -->
     <script src="${base}/assets/js/jquery.loadTemplate-1.4.5.js"></script>
     <script src="${base}/assets/js/jquery.tabledit.js"></script>
    <script src="${base}/js/index.js"></script>
</body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/jsp/taglibs.jsp"%>
<!doctype html>
<html>
<head>
  <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0">
  <meta charset="utf-8">
  <!-- Always force latest IE rendering engine or request Chrome Frame -->
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
  <!-- Use title if it's in the page YAML frontmatter -->
  <title>BackendUI login page</title>
  <link href="${base}/assets/css/bootstrap.css" rel="stylesheet">
  <link href="${base}/assets/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
    <div class="navbar navbar-top navbar-inverse">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="brand" href="#">家校通后台系统登录</a>
          <!-- the new toggle buttons -->
          <!-- <ul class="nav pull-right">
            <li class="toggle-sidebar hidden-desktop"><a><i class="icon-list-alt"></i></a></li>
            <li class="toggle-primary-sidebar hidden-desktop hidden-tablet"><a><i class="icon-th-list"></i></a></li>
            <li class="collapsed hidden-desktop" data-toggle="collapse" data-target=".nav-collapse"><a><i class="icon-align-justify"></i></a></li>
          </ul> -->
        </div>
      </div>
    </div>
    <div class="container">
        <div class="span4 offset4">
            <div class="padded">
                <div class="login box" style="margin-top: 80px;">
                    <div class="box-header">
                        <span class="title">登录</span>
                    </div>
                    <div class="box-content padded">
                        <form class="separate-sections" action="/">
                            <div class="input-prepend">
                                <span class="add-on" href="#">
                                    <i class="icon-user"></i>
                                </span>
                                <input type="text" placeholder="工号">
                            </div>
                            <div class="input-prepend">
                                <span class="add-on" href="#">
                                    <i class="icon-key"></i>
                                </span>
                                <input type="password" placeholder="密码">
                            </div>
                            
                            <div>
                                <button type="submit" class="btn btn-blue btn-block">登录 <i class="icon-signin"></i></button>
                            </div>
                        </form>
                        <div>
                            <a href="#">还没有帐号？<strong>立即注册</strong></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="foot">版权所有@2015</div>
    
</body>
</html>

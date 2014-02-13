<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8" />
    <base href=<%=basePath%>> 
    <title>帝国业务管理系统</title>
    <link rel="stylesheet" type="text/css" href="resources/plugin/index/css/main.css" />
</head>
<body>
<div class="login">
	<div class="menus">
    	<div class="public"><a href="http://www.0dunet.com" target="_blank">使用帮助</a><a href="http://www.0dunet.com" target="_blank">联系我们</a></div>
    </div>
    <div class="box png">
        <form action="common/login.action" method="post">
        <div class="header">
            <h2 class="logo png"><a href="http://www.0dunet.com" target="_blank"></a></h2>
            <span class="alt">管理员登录</span>
        </div>
        <ul>
            <li><label>用户名</label><input name="userReq.username" type="text" class="text" value="" /></li>
            <li><label>密　码</label><input name="userReq.password" type="password" class="text" value="" /></li> <label style="color: F00; float: right; font-size: 10px; float: right;"><s:property value="#session.login_please"/></label>
            <li class="submits"><input class="submit" type="submit" value="登录" /></li>
        </ul>
        <div class="copyright">&copy; 2012 - 2013 | <a href="http://www.0dunet.com" target="_blank" title="帝国业务管理系统">0dunet.com</a><!--  |
            <a title="零度网络的腾讯微博" href="http://t.qq.com/0dunet" target="_blank" class="weibo tencent">零度网络的腾讯微博</a> -->
        </div>
        </form>
    </div>
    <div class="air-balloon ab-1 png"></div><div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>
<script type="text/javascript" src="js/index/jQuery.js"></script>
<script type="text/javascript" src="js/index/fun.base.js"></script>
<script type="text/javascript" src="js/index/login.js"></script>

<!--[if lt IE 8]>
<script src="jslib/PIE.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
    if (window.PIE && ( $.browser.version >= 6 && $.browser.version < 10 )){
        $('input.text,input.submit').each(function(){
            PIE.attach(this);
        });
    }
});
</script>
<![endif]-->

<!--[if IE 6]>
<script src="jslib/DD_belatedPNG.js" type="text/javascript"></script>
<script>DD_belatedPNG.fix('.png')</script>
<![endif]-->

</body>
</html>
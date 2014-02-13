<%@ page language="java" import="java.util.*" pageEncoding="utf-8"  contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/base/jquery-ui-1.9.0.custom.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/base/jquery-ui-1.9.0.custom.min.css"/>

<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/common/frame/frame.css" />
	
<script src="<%=basePath%>resources/js/jquery-1.8.2.js"></script>
<script src="<%=basePath%>resources/js/jquery.form.js"></script>
<script src="<%=basePath%>resources/js/jquery-ui-1.9.0.custom.js"></script>
<script src="<%=basePath%>resources/js/jquery-ui-1.9.0.custom.min.js"></script>
<script src="<%=basePath%>resources/js/jquery-ui-i18n.js"></script>

<script src="<%=basePath%>js/common/form/tgks_table.js"></script>


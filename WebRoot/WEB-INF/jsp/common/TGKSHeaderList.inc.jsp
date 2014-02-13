<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="i18n" uri="http://jakarta.apache.org/taglibs/i18n-1.0" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/common/form/tgks_list.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/common/form/tgks_pagination.css" />

<script src="<%=basePath%>js/common/form/tgks_button.js"></script>



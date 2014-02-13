<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/TGKSHeader.inc.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	
	<title>帝国业务管理系统</title>
	
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">	
	<meta http-equiv="keywords" content="幻影帝国,猫盟公社,帝国业务管理系统">
	<meta http-equiv="description" content="帝国业务管理系统">
</head>
<body>
	<div class="ui-layout-center">
		<!-- centers start -->
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">首页</a></li>
			</ul>
			<div id="tabs-1" style="height:85%">
				<!-- header start -->
			 	<%@ include file="/WEB-INF/jsp/common/frame/frameMiddle.jsp" %>
			 	<!-- header end -->
			</div>
		</div>
		<!-- center end -->
	</div>
	 
	<div class="ui-layout-west">
		<!-- menu start -->
		<div id="accordion">
			<h3>常用菜单</h3>
			<ul name="menuOne">
			<!-- 这里可以加一个默认的系统菜单 -->
				<!-- <li name="menuTwo" ><a href="#" click="Runtime.getRuntime().exec('cmd /k start calc');" >计算器</a></li> -->
			<!-- iterator标签这里value属性写绑定的数据对象名称,仅属性名即可;var属性随意起一个别名,下面用property标签获得对应属性的值,别名前面要加# -->
			<s:iterator  value="menuList" var="evt">
				<s:if test="#evt.level == 1">
					</ul>
					<h3><s:property value="#evt.name"/></h3>
					<ul id="menu<s:property value="#evt.id"/>" name="menuOne">
				</s:if>
				<s:else>
					<li name="menuTwo" id="<s:property value="#evt.id"/>" title="<s:property value="#evt.name"/>" type="<s:property value="#evt.url"/>"><a href="#"><s:property value="#evt.name"/></a></li>
				</s:else>
			</s:iterator>
			</ul>
		</div>
		<!-- menu end -->
	</div>
	
	<div class="ui-layout-north" >
	 	<!-- header start -->
	 	<%@ include file="/WEB-INF/jsp/common/frame/frameHeader.jsp" %>
	 	<!-- header end -->
	 </div>
	
	<div class="ui-layout-south" align="center">
		<!-- footer start -->
	 	<%@ include file="/WEB-INF/jsp/common/frame/frameFooter.jsp" %>
	 	<!-- footer end -->
	</div>
	
	<!-- JS脚本开始 -->
	<script src="<%=basePath%>js/common/frame/tgks_menu.js"></script>
	<script src="<%=basePath%>js/common/frame/tgks_tabs.js"></script>
	<script src="<%=basePath%>js/common/frame/layout.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<input type="hidden" name="userEvt.id" id="userId" value="${userEvt.id }" />
<input type="hidden" name="userEvt.status" id="userStatus" value="${userEvt.status }" />
<table>
	<tr>
		<td><label for="name">账户ID</label></td>
		<td><input type="text" name="userEvt.username" id="userUsername" class="text ui-widget-content ui-corner-all" value="${userEvt.username }" /></td>
	</tr>
	<tr>
		<td><label for="name">密码</label></td>
		<td><input type="text" name="userEvt.password" id="userPassword" class="text ui-widget-content ui-corner-all" value="${userEvt.password }" /></td>
	</tr>
	<tr>
		<td><label for="name">类型</label></td>
		<td><input type="text" name="userEvt.type" id="userType" class="text ui-widget-content ui-corner-all" value="${userEvt.type }" /></td>
	</tr>
	<tr>
		<td><label for="name">邮箱</label></td>
		<td><input type="text" name="userEvt.email" id="userEmail" class="text ui-widget-content ui-corner-all" value="${userEvt.email }" /></td>
	</tr>
	<tr>
		<td><label for="name">姓名</label></td>
		<td><input type="text" name="userEvt.name" id="userName" class="text ui-widget-content ui-corner-all" value="${userEvt.name }" /></td>
	</tr>
	<tr>
		<td><label for="name">性别</label></td>
		<td><input type="text" name="userEvt.sex" id="userSex" class="text ui-widget-content ui-corner-all" value="${userEvt.sex }" /></td>
	</tr>
</table>
<script type="text/javascript">
</script>
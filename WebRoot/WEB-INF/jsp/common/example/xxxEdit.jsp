<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<!-- 替换xxx为新增的类名，首字母小写，替换完成后删除注释 -->
<input type="hidden" name="xxxEvt.id" id="xxxId" value="${xxxEvt.id }" />
<table>
	<tr>
		<td><label for="name">xxx</label></td>
		<td><input type="text" name="xxxEvt.name" id="xxxName" class="text ui-widget-content ui-corner-all" value="${xxxEvt.name }" /></td>
	</tr>
</table>
<script type="text/javascript">
</script>
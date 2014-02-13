<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<input type="hidden" name="systemLogEvt.id" id="systemLogId" value="${systemLogEvt.id }" />
<table>
	<tr>
		<td><label for="name">systemLog</label></td>
		<td><input type="text" name="systemLogEvt.name" id="systemLogName" class="text ui-widget-content ui-corner-all" value="${systemLogEvt.name }" /></td>
	</tr>
</table>
<script type="text/javascript">
</script>
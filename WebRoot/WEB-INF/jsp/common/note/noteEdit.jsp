<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<input type="hidden" name="noteEvt.id" id="noteId" value="${noteEvt.id }" />
<table>
	<tr>
		<td><textarea name="noteEvt.content" id="noteContent" class="text ui-widget-content ui-corner-all" cols="56" rows="10">${noteEvt.content }</textarea></td>
	</tr>
</table>
<script type="text/javascript">
</script>
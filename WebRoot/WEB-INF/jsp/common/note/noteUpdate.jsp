<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<form id="lastNoteForm" method="post">
	<table>
		<tr>
			<td><textarea name="noteEvt.content" id="noteContent" class="text ui-widget-content ui-corner-all" >${noteEvt.content }</textarea></td>
		</tr>
		<tr>
			<td><button id="updateNote">保存记录</button></td>
		</tr>
	</table>
</form>
<script type="text/javascript">
$(document).ready(function(){
	// 新增按钮
	$( "#updateNote" ).button({
		icons: {
			primary: "ui-icon-plus"
			}
		}).click(function() {
		var edit=$.ajax({url:"../common/saveLatestNote.action",async:false});
		$("#lastNoteForm").html(edit.responseText);
		return false;
	});
});
</script>
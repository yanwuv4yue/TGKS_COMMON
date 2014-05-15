<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<input type="hidden" id="noteListSubmit" name="noteListSubmit" value="0" />
<div id="noteTableDiv" class="ui-widget">
    <table id="noteTable" class="ui-widget ui-widget-content">
        <thead>
            <tr class="ui-widget-header ">
                <th width="20"><input type="checkbox" id="allNoteId" name="allNoteId"  /></th>
				<th>ID</th>
				<th>内容</th>
				<th>创建时间</th>
            </tr>
        </thead>
        <tbody>
			<s:iterator  value="list" var="evt">
				<tr>
					<td width="20"><input type="checkbox" name="noteId" value="<s:property value='#evt.id'/>" /></td>
					<td><b id="<s:property value='#evt.id'/>" class="noteUpdate"><s:property value="#evt.id"/></b></td>
					<td><s:property value="#evt.content"/></td>
					<td><s:date name="#evt.createTime" format="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</s:iterator>
		</tbody>
    </table>
</div>
<script type="text/javascript">
	$(function() {
		$('#noteTable').longtable({
			'perPage' : 10
		});

		// 点击记录首栏进入更新操作
		$(".noteUpdate").click(function() {
			$("#noteManagerSubmit").val("1");
			$("#noteEdit").dialog("open");
			var edit = $.ajax({
				url : "../common/editNotePage.action?id=" + this.id,
				async : false
			});
			$("#noteForm").html(edit.responseText);
		});

		// 全选
		$("#allNoteId").click(function() {
			var checkbox = $("#noteTable :checkbox");
			for ( var i = 1; i < checkbox.length; i++) {
				if (checkbox[i].hidden == "") {
					checkbox[i].checked = checkbox[0].checked;
				}
			}
		});
	});
</script>

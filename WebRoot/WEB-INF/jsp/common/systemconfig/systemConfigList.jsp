<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<table id="systemConfigTable" class="ui-widget ui-widget-content">
	<thead>
		<tr class="ui-widget-header ">
			<th width="20"><input type="checkbox" name="allSystemConfigId"/></th>
			<th>参数标签</th>
			<th>参数名</th>
			<th>参数值</th>
			<th>类型</th>
			<th>模块</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator  value="list" var="evt">
			<tr>
				<td width="20"><input type="checkbox" name="systemConfigId" value="<s:property value='#evt.id'/>"/></td>
				<td><b id="<s:property value='#evt.id'/>" class="systemConfigUpdate"><s:property value="#evt.tag"/></b></td>
				<td><s:property value="#evt.name"/></td>
				<td><s:property value="#evt.value"/></td>
				<td><s:property value="#evt.type"/></td>
				<td><s:property value="#evt.module"/></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
<script type="text/javascript">
	$(function() {
		$('#systemConfigTable').longtable({
			'perPage' : 10
		});

		// 点击记录首栏进入更新操作
		$(".systemConfigUpdate").click(function() {
			$("#systemConfigManagerSubmit").val("1");
			$("#systemConfigEdit").dialog("open");
			var edit = $.ajax({
				url : "../common/editSystemConfigPage.action?id=" + this.id,
				async : false
			});
			$("#systemConfigForm").html(edit.responseText);
		});

		// 全选
		$("#allSystemConfigId").click(function() {
			var checkbox = $("#systemConfigTable :checkbox");
			for ( var i = 1; i < checkbox.length; i++) {
				if (checkbox[i].hidden == "") {
					checkbox[i].checked = checkbox[0].checked;
				}
			}
		});
	});
</script>
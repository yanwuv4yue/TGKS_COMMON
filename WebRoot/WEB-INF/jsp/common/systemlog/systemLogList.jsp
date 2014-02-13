<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<input type="hidden" id="systemLogListSubmit" name="systemLogListSubmit" value="0" />
<div id="systemLogTableDiv" class="ui-widget">
    <table id="systemLogTable" class="ui-widget ui-widget-content">
        <thead>
            <tr class="ui-widget-header ">
                <!-- <th width="20"><input type="checkbox" id="allSystemLogId" name="allSystemLogId"  /></th> -->
				<th>序号</th>
				<th>账号</th>
				<th>类型</th>
				<th>动作</th>
				<th>结果</th>
				<th>详细信息</th>
				<th>操作时间</th>
            </tr>
        </thead>
        <tbody>
			<s:iterator  value="list" var="evt">
				<tr>
					<!-- <td width="20"><input type="checkbox" name="systemLogId" value="<s:property value='#evt.id'/>" /></td> -->
					<td><s:property value='#evt.id'/></b></td>
					<td><s:property value="#evt.username"/></td>
					<td><s:if test="#evt.type == 0">查询</s:if><s:elseif test="#evt.type == 1">新增</s:elseif><s:elseif test="#evt.type == 2">更新</s:elseif><s:elseif test="#evt.type == 3">删除</s:elseif></td>
					<td><s:property value="#evt.action"/></td>
					<td><s:if test="#evt.result == 0">成功</s:if><s:else>失败</s:else></td>
					<td><s:property value="#evt.info"/></td>
					<td><s:date name="#evt.createTime" format="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</s:iterator>
		</tbody>
    </table>
</div>
<script type="text/javascript">
	$(function() {
		$('#systemLogTable').longtable({
			'perPage' : 10
		});

		// 点击记录首栏进入更新操作
		$(".systemLogUpdate").click(function() {
			$("#systemLogManagerSubmit").val("1");
			$("#systemLogEdit").dialog("open");
			var edit = $.ajax({
				url : "../common/editSystemLogPage.action?id=" + this.id,
				async : false
			});
			$("#systemLogForm").html(edit.responseText);
		});

		// 全选
		$("#allSystemLogId").click(function() {
			var checkbox = $("#systemLogTable :checkbox");
			for ( var i = 1; i < checkbox.length; i++) {
				if (checkbox[i].hidden == "") {
					checkbox[i].checked = checkbox[0].checked;
				}
			}
		});
	});
</script>

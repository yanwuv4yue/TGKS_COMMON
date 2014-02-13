<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<div id="userMenuTableDiv" class="ui-widget">
    <table id="userMenuTable" class="ui-widget ui-widget-content">
    <input type="hidden" name="userMenuEvt.userId" id="userMenuId" value="${userMenuEvt.userId }" />
        <thead>
            <tr class="ui-widget-header ">
                <th width="20"><input type="checkbox" id="allUserMenuId" name="allUserMenuId"  /></th>
				<th>菜单名称</th>
            </tr>
        </thead>
        <tbody>
			<s:iterator  value="menuList" var="evt">
				<tr <s:if test="#evt.level == 1">style="background-color:#dddddd"</s:if>>
					<td width="20"><input type="checkbox" name="userMenuId" value="<s:property value='#evt.id'/>" <s:if test="#evt.status == 2">checked="checked"</s:if> /></td>
					<td><s:property value="#evt.name"/></td>
				</tr>
			</s:iterator>
		</tbody>
    </table>
</div>
<script type="text/javascript">
	$(function() {
		$('#userMenuTable').longtable({
			'perPage' : 8
		});

		// 点击记录首栏进入更新操作
		$(".userMenuUpdate").click(function() {
			$("#userMenuEdit").dialog("open");
			var edit = $.ajax({
				url : "../ums/editUserMenuPage.action?id=" + this.id,
				async : false
			});
			$("#userMenuForm").html(edit.responseText);
		});

		// 全选
		$("#allUserMenuId").click(function() {
			var checkbox = $("#userMenuTable :checkbox");
			for ( var i = 1; i < checkbox.length; i++) {
				if (checkbox[i].hidden == "") {
					checkbox[i].checked = checkbox[0].checked;
				}
			}
		});
	});
</script>

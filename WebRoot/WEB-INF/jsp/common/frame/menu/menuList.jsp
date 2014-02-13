<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<div id="menuTableDiv" class="ui-widget">
    <table id="menuTable" class="ui-widget ui-widget-content">
        <thead>
            <tr class="ui-widget-header ">
                <th width="20"><input type="checkbox" id="allMenuId" name="allMenuId"/></th>
				<th>菜单名</th>
				<th>所属模块</th>
				<th>状态</th>
				<th>URL地址</th>
				<th>菜单级别</th>
				<th>展示顺序</th>
            </tr>
        </thead>
        <tbody>
			<s:iterator  value="list" var="evt">
				<tr <s:if test="#evt.level == 1">style="background-color:#dddddd"</s:if>>
					<td width="20"><input type="checkbox" name="menuId" value="<s:property value='#evt.id'/>"/></td>
					<td><b id="<s:property value='#evt.id'/>" class="menuUpdate"><s:property value="#evt.name"/></b></td>
					<td><s:property value="#evt.preIdName"/></td>
					<td>
						<s:if test="#evt.status == 1">
							启用
						</s:if>
						<s:else>
							禁用
						</s:else>
					<td><s:property value="#evt.url"/></td>
					<td>
						<s:if test="#evt.level == 1">
							一级菜单
						</s:if>
						<s:elseif test="#evt.level == 2">
							二级菜单
						</s:elseif>
					</td>
					<td><s:property value="#evt.sort"/></td>
				</tr>
			</s:iterator>
		</tbody>
    </table>
</div>
<script type="text/javascript">
	$(function () {
		$('#menuTable').longtable({'perPage': 8});
		
		// 点击记录首栏进入更新操作
		$(".menuUpdate").click(function() {
			$("#menuEdit").dialog("open");
			var edit = $.ajax({
				url : "../common/editMenuPage.action?id=" + this.id,
				async : false
			});
			$("#menuForm").html(edit.responseText);
		});

		// 全选
		$("#allMenuId").click(function(){
			var checkbox = $("#menuTable :checkbox");
			for (var i = 1; i < checkbox.length; i++)
			{
				if (checkbox[i].hidden == "")
				{
					checkbox[i].checked = checkbox[0].checked;
				}
			}
		});
	});
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<input type="hidden" id="userListSubmit" name="userListSubmit" value="0" />
<div id="userTableDiv" class="ui-widget">
    <table id="userTable" class="ui-widget ui-widget-content">
        <thead>
            <tr class="ui-widget-header ">
                <th width="20"><input type="checkbox" id="allUserId" name="allUserId"  /></th>
				<th>账户ID</th>
				<!-- <th>账户密码</th> -->
				<th>状态</th>
				<th>类型</th>
				<th>邮箱</th>
				<th>姓名</th>
				<th>性别</th>
				<th>创建时间</th>
				<th>操作</th>
            </tr>
        </thead>
        <tbody>
			<s:iterator  value="list" var="evt">
				<tr>
					<td width="20"><input type="checkbox" name="userId" value="<s:property value='#evt.id'/>" /></td>
					<td><b id="<s:property value='#evt.id'/>" class="userUpdate"><s:property value="#evt.username"/></b></td>
					<!-- <td><s:property value="#evt.password"/></td> -->
					<td><s:if test="#evt.status == 0">停止</s:if><s:elseif test="#evt.status == 1">启用</s:elseif></td>
					<td><s:if test="#evt.type == 0">普通</s:if></td>
					<td><s:property value="#evt.email"/></td>
					<td><s:property value="#evt.name"/></td>
					<td><s:if test="#evt.sex == 0">男</s:if><s:elseif test="#evt.sex == 1">女</s:elseif></td>
					<td><s:date name="#evt.createTime" format="yyyy-MM-dd HH:mm:ss"/></td>
					<td><button id="<s:property value='#evt.id'/>M" class="userMenu">菜单权限</button></td>
				</tr>
			</s:iterator>
		</tbody>
    </table>
</div>

<div id="userMenuEdit" title="菜单权限" hidden="hidden">
	<form id="userMenuForm" action="../ums/editUserMenu.action" method="post"></form>
</div>

<script type="text/javascript">
$(function() {
	$('#userTable').longtable({
		'perPage' : 8
	});

	// 点击记录首栏进入更新操作
	$(".userUpdate").click(function() {
		$("#userEdit").dialog("open");
		$("#userManagerSubmit").val("1");
		var edit = $.ajax({
			url : "../ums/editUserPage.action?id=" + this.id,
			async : false
		});
		$("#userForm").html(edit.responseText);
	});

	// 全选
	$("#allUserId").click(function() {
		var checkbox = $("#userTable :checkbox");
		for ( var i = 1; i < checkbox.length; i++) {
			if (checkbox[i].hidden == "") {
				checkbox[i].checked = checkbox[0].checked;
			}
		}
	});
	
	
	// 管理菜单权限
	$(".userMenu").click(function(){
		$("#userMenuEdit").dialog("open");
		var edit = $.ajax({
			url : "../ums/editUserMenuPage.action?userId=" + this.id,
			async : false
		});
		$("#userMenuForm").html(edit.responseText);
	});
	
	// 菜单权限窗口
	$( "#userMenuEdit" ).dialog({
		modal: true,
		height:450,
		width:400,
		autoOpen: false,
		show: "fold",
		hide: "fold",
		buttons:
		{ 
			"确定":function()
			{
				var form = $("#userMenuForm");
				form.submit();
			}, 
			"关闭": function()
			{
				$("#userMenuEdit").dialog("close"); 
			} 
		}
	});
	
	// 菜单权限更新
	$("#userMenuForm").submit(function()
	{
		var ids = "";
		var array = document.getElementsByName("userMenuId");
		for (var i=0; i<array.length; i++)
	   	{
	   		if (array[i].checked)
  			{
	   			if (ids == "")
   				{
	   				ids += array[i].value;
   				}
	   			else
	   			{
	   				ids += "," + array[i].value;
	   			}
  			}
	   	}
	   	
		var options = { 
			url:"../ums/editUserMenu.action?menuId=" + ids, // 提交给哪个执行
			type:'POST', 
			success: function(){
				alert("操作成功");
				$("#userMenuEdit").dialog("close");
				// 新增完毕刷新form
				query();
			},
			error:function(){ 
				$("#userMenuEdit").dialog("close"); 
				alert("操作失败"); 
			}
		};
		
		$("#userMenuForm").ajaxSubmit(options);
		return false; // 为了不刷新页面,返回false，反正都已经在后台执行完了，没事！
	});
});
</script>

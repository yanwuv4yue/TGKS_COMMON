<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style type="text/css">
#userReq{border:0px solid;}
#userReq td{border:0px solid;}
#userReq input{width:120px;}
#userReq select{width:120px;}
</style>
<input type="hidden" id="userManagerSubmit" name="userManagerSubmit" value="0" />
<div class="ui-widget">
	<form id="userReq" action="../ums/queryUser.action" method="post">
		<table>
			<tr>
				<td><label>ID: </label></td><td><input type="text" name="userReq.username" /></td>
				<td><label>姓名: </label></td><td><input type="text" name="userReq.name" /></td>
				<td><label>状态: </label></td>
				<td>
					<select name="userReq.status">
						<option value="">全部</option>
						<option value="1">启用</option>
						<option value="0">停止</option>
					</select>
				</td>
				<td>
				<button id="clearUser">重置</button>
				<button id="queryUser">查询</button>
				</td>
			</tr>
		</table>
		
	</form>
</div>

<button id="addUser">新增</button>
<button id="deleteUser">删除</button>
<button id="onUser">启用</button>
<button id="offUser">禁用</button>

<div id="userDiv"></div>

<div id="userEdit" title="User Edit">
	<form id="userForm" action="../ums/editUser.action" method="post"></form>
</div>

<div id="userConfirm" title="操作确认" hidden="hidden">
	<p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>记录将被删除且不可恢复，是否确认？</p>
</div>
<script type="text/javascript">
$(document).ready(function(){
	var table=$.ajax({url:"../ums/queryUser.action",async:false});
	$("#userDiv").html(table.responseText);
	
	function query()
	{
		var table=$.ajax({url:"../ums/queryUser.action", data:$("#userReq").formSerialize(), async:false});
		$("#userDiv").html(table.responseText);
	}
	
	// 新增/更新窗口
	$( "#userEdit" ).dialog({
		modal: true,
		height:500,
		width:750,
		autoOpen: false,
		show: "fold",
		hide: "fold",
		buttons:
		{ 
			"确定":function()
			{
				var form = $("#userForm");
				form.submit();
			}, 
			"关闭": function()
			{
				$("#userManagerSubmit").val("0");
				$("#userEdit").dialog("close"); 
			} 
		}
	});
	
	// 提交表单
	$("#userForm").submit(function()
	{
		if ($("#userManagerSubmit").val() == "0")
		{
			return false;
		}
		
		$("#userManagerSubmit").val("0");
		
		var options = { 
			url:"../ums/editUser.action", // 提交给哪个执行
			type:'POST', 
			success: function(){
				$("#userEdit").dialog("close");
				// 新增完毕刷新form
				query();
				alert("操作成功");
			},
			error:function(){ 
				$("#userEdit").dialog("close"); 
				alert("操作失败"); 
			}
		};
		
		$("#userForm").ajaxSubmit(options);
		return false; // 为了不刷新页面,返回false，反正都已经在后台执行完了，没事！
	});  
	
	// 新增按钮
	$( "#addUser" ).button({
		icons: {
			primary: "ui-icon-plus"
			}
		}).click(function() {
		$("#userManagerSubmit").val("1");
		$( "#userEdit" ).dialog( "open" );
		var edit=$.ajax({url:"../ums/editUserPage.action",async:false});
		$("#userForm").html(edit.responseText);
		return false;
	});
	
	 // 删除按钮
	$( "#deleteUser" ).button({
		icons: {
			primary: "ui-icon-minus"
			}
		}).click(function() {
		$("#userManagerSubmit").val("1");
		// 获取选中的记录ids
		var ids = "";
		var array = document.getElementsByName("userId");
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
		
		// 操作验证
		if (ids == "")
		{
			alert("请选择至少一条记录");
			$("#userManagerSubmit").val("0");
			return false;
		}
		
		// ajax调用删除action
		var options = { 
			url:"../ums/deleteUser.action?ids=" + ids , // 提交给哪个执行
			type:'POST', 
			success: function(){
				alert("删除成功");
				// 执行成功刷新form
				query();
			},
			error:function(){ 
				alert("删除失败"); 
			}
		};
		
		// 确认操作
		$("#userConfirm").dialog({
			resizable: false,
            height:160,
            modal: true,
            buttons: {
                "确认": function() {
                	$( this ).dialog( "close" );
                	// 异步请求删除操作
                	$("#userConfirm").ajaxSubmit(options);
                },
                "取消": function() {
                    $( this ).dialog( "close" );
                }
            }
		});
				
		return false;
	});
	 
	 // 启用按钮
	$( "#onUser" ).button({
		icons: {
			primary: "ui-icon-check"
			}
		}).click(function() {
			$("#userManagerSubmit").val("1");
			// 获取选中的记录ids
			var ids = "";
			var array = document.getElementsByName("userId");
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
			
			// 操作验证
			if (ids == "")
			{
				alert("请选择至少一条记录");
				$("#userManagerSubmit").val("0");
				return false;
			}
			
			// ajax调用删除action
			var options = { 
				url:"../ums/changeStatusUser.action?status=1&ids=" + ids , // 提交给哪个执行
				type:'POST', 
				success: function(){
					// 执行成功刷新form
					query();
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#userConfirm").ajaxSubmit(options);
			$("#userManagerSubmit").val("0");
			return false;
	});
	 
	 // 停用按钮
	$( "#offUser" ).button({
		icons: {
			primary: "ui-icon-close"
			}
		}).click(function() {
			$("#userManagerSubmit").val("1");
			// 获取选中的记录ids
			var ids = "";
			var array = document.getElementsByName("userId");
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
			
			// 操作验证
			if (ids == "")
			{
				alert("请选择至少一条记录");
				$("#userManagerSubmit").val("0");
				return false;
			}
			
			// ajax调用删除action
			var options = { 
				url:"../ums/changeStatusUser.action?status=0&ids=" + ids , // 提交给哪个执行
				type:'POST', 
				success: function(){
					// 执行成功刷新form
					query();
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#userConfirm").ajaxSubmit(options);
			$("#userManagerSubmit").val("0");
			return false;
	});
	
	 // 刷新按钮
	$( "#queryUser" ).button().click(function() {
			query();
		return false;
	});
	 
	// 重置按钮
	$( "#clearUser" ).button().click(function() {
			$("#userReq").clearForm();
		return false;
	});
});
</script>

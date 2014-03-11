<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderManager.inc.jsp" %>
<style type="text/css">
#systemLogReq{border:0px solid;}
#systemLogReq td{border:0px solid;}
#systemLogReq input{width:120px;}
#systemLogReq select{width:120px;}
</style>
<input type="hidden" id="systemLogManagerSubmit" name="systemLogManagerSubmit" value="0" />
<div class="ui-widget">
	<form id="systemLogReq" action="../common/querySystemLog.action" method="post">
		<table>
			<tr>
				<td><label>账号: </label></td><td><input type="text" name="systemLogReq.username" /></td>
				<td>类型：</td>
				<td>
					<select name="systemLogReq.type" style="width: 60px">
						<option value="" >全部</option>
						<option value="0" >查询</option>
						<option value="1" >新增</option>
						<option value="2" >修改</option>
						<option value="3" >删除</option>
					</select>
				</td>
				<td>结果：</td>
				<td>
					<select name="systemLogReq.result" style="width: 60px">
						<option value="" >全部</option>
						<option value="0" >成功</option>
						<option value="1" >失败</option>
					</select>
				</td>
				<td>操作时间：</td>
				<td><input type="text" class="datepicker" name="systemLogReq.createTimeStart" /></td>
				<td>~</td>
				<td><input type="text" class="datepicker" name="systemLogReq.createTimeEnd" /></td>
				<td>
				<button id="clearSystemLog">重置</button>
				<button id="querySystemLog">查询</button>
				</td>
			</tr>
		</table>
	</form>
</div>
<!-- 
<button id="addSystemLog">新增</button>
<button id="deleteSystemLog">删除</button>
<button id="onSystemLog">启用</button>
<button id="offSystemLog">禁用</button>
 -->
<div id="systemLogDiv"></div>

<div id="systemLogEdit" title="SystemLog Edit">
	<form id="systemLogForm" action="../common/editSystemLog.action" method="post"></form>
</div>

<div id="systemLogConfirm" title="操作确认" hidden="hidden">
	<p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>记录将被删除且不可恢复，是否确认？</p>
</div>
<script type="text/javascript">
$(document).ready(function(){
	var table=$.ajax({url:"../common/querySystemLog.action",async:false});
	$("#systemLogDiv").html(table.responseText);
	
	function query()
	{
		var table=$.ajax({url:"../common/querySystemLog.action", data:$("#systemLogReq").formSerialize(), async:false});
		$("#systemLogDiv").html(table.responseText);
	}
	
	// 新增/更新窗口
	$( "#systemLogEdit" ).dialog({
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
				// 页面校验
				if (!systemLogFormCheck())
				{
					return false;
				}
				var form = $("#systemLogForm");
				form.submit();
			}, 
			"关闭": function()
			{
				$("#systemLogManagerSubmit").val("0");
				$("#systemLogEdit").dialog("close"); 
			} 
		}
	});
	
	// 提交表单
	$("#systemLogForm").submit(function()
	{
		if ($("#systemLogManagerSubmit").val() == "0")
		{
			return false;
		}
		
		$("#systemLogManagerSubmit").val("0");
		
		var options = { 
			url:"../common/editSystemLog.action", // 提交给哪个执行
			type:'POST', 
			success: function(){
				$("#systemLogEdit").dialog("close");
				// 新增完毕刷新form
				query();
				alert("操作成功");
			},
			error:function(){ 
				$("#systemLogEdit").dialog("close"); 
				alert("操作失败"); 
			}
		};
		
		$("#systemLogForm").ajaxSubmit(options);
		
		return false; // 为了不刷新页面,返回false，反正都已经在后台执行完了，没事！
	});  
	
	// 新增按钮
	$( "#addSystemLog" ).button({
		icons: {
			primary: "ui-icon-plus"
			}
		}).click(function() {
		// 请求提交标志
		$("#systemLogManagerSubmit").val("1");
		$( "#systemLogEdit" ).dialog( "open" );
		//var edit=$.ajax({url:"../common/editSystemLogPage.action",async:false});
		var edit=$.ajax({url:"../common/uploadSinglePage.action",async:false});
		$("#systemLogForm").html(edit.responseText);
		return false;
	});
	
	 // 删除按钮
	$( "#deleteSystemLog" ).button({
		icons: {
			primary: "ui-icon-minus"
			}
		}).click(function() {
		$("#systemLogManagerSubmit").val("1");
		// 获取选中的记录ids
		var ids = "";
		var array = document.getElementsByName("systemLogId");
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
			$("#systemLogManagerSubmit").val("0");
			return false;
		}
		
		// ajax调用删除action
		var options = { 
			url:"../common/deleteSystemLog.action?ids=" + ids , // 提交给哪个执行
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
		$("#systemLogConfirm").dialog({
			resizable: false,
            height:160,
            modal: true,
            buttons: {
                "确认": function() {
                	$( this ).dialog( "close" );
                	// 异步请求删除操作
                	$("#systemLogConfirm").ajaxSubmit(options);
                },
                "取消": function() {
                    $( this ).dialog( "close" );
                }
            }
		});
		return false;
	});
	 
	 // 启用按钮
	$( "#onSystemLog" ).button({
		icons: {
			primary: "ui-icon-check"
			}
		}).click(function() {
			$("#systemLogManagerSubmit").val("1");
			// 获取选中的记录ids
			var ids = "";
			var array = document.getElementsByName("systemLogId");
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
				$("#systemLogManagerSubmit").val("0");
				return false;
			}
			
			// ajax调用删除action
			var options = { 
				url:"../common/changeStatusSystemLog.action?status=1&ids=" + ids , // 提交给哪个执行
				type:'POST', 
				success: function(){
					// 执行成功刷新form
					query();
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#systemLogConfirm").ajaxSubmit(options);
			$("#systemLogManagerSubmit").val("0");
			return false;
	});
	 
	 // 停用按钮
	$( "#offSystemLog" ).button({
		icons: {
			primary: "ui-icon-close"
			}
		}).click(function() {
			$("#systemLogManagerSubmit").val("1");
			// 获取选中的记录ids
			var ids = "";
			var array = document.getElementsByName("systemLogId");
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
				$("#systemLogManagerSubmit").val("0");
				return false;
			}
			
			// ajax调用删除action
			var options = { 
				url:"../common/changeStatusSystemLog.action?status=0&ids=" + ids , // 提交给哪个执行
				type:'POST', 
				success: function(){
					// 执行成功刷新form
					query();
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#systemLogConfirm").ajaxSubmit(options);
			$("#systemLogManagerSubmit").val("0");
			return false;
	});
	
	 // 刷新按钮
	$( "#querySystemLog" ).button().click(function() {
			query();
		return false;
	});
	 
	// 重置按钮
	$( "#clearSystemLog" ).button().click(function() {
			$("#systemLogReq").clearForm();
		return false;
	});
	
	// 页面校验
	function systemLogFormCheck()
	{
		return true;
	}
});
</script>

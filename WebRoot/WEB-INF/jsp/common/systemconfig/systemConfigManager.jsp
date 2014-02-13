<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderManager.inc.jsp" %>
<style type="text/css">
#systemConfigReq{border:0px solid;}
#systemConfigReq td{border:0px solid;}
#systemConfigReq input{width:120px;}
#systemConfigReq select{width:120px;}
</style>
<input type="hidden" id="systemConfigManagerSubmit" name="systemConfigManagerSubmit" value="0" />
<div class="ui-widget">
	<form id="systemConfigReq" action="../common/querySystemConfig.action" method="post">
		<table>
			<tr>
				<td><label>参数标签: </label></td><td><input type="text" name="systemConfigReq.tag" /></td>
				<td><label>参数名: </label></td><td><input type="text" name="systemConfigReq.name" /></td>
				<td><label>所属模块: </label></td><td><input type="text" name="systemConfigReq.module" /></td>
				<td>
				
				</td>
				<td>
				<button id="clearSystemConfig">重置</button>
				<button id="querySystemConfig">查询</button>
				</td>
			</tr>
		</table>
	</form>
</div>

<button id="addSystemConfig">新增</button>
<button id="deleteSystemConfig">删除</button>
<!-- 
<button id="onSystemConfig">启用</button>
<button id="offSystemConfig">禁用</button>
 -->
<span style="color:red;">系统参数标签命名规范：使用小写英文命名，单词之前使用下划线连接。例：system_time_format</span>
<div id="systemConfigDiv"></div>

<div id="systemConfigEdit" title="SystemConfig Edit">
	<form id="systemConfigForm" action="../common/editSystemConfig.action" method="post"></form>
</div>

<div id="systemConfigConfirm" title="操作确认" hidden="hidden">
	<p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>记录将被删除且不可恢复，是否确认？</p>
</div>
<script type="text/javascript">
$(document).ready(function(){
	var table=$.ajax({url:"../common/querySystemConfig.action",async:false});
	$("#systemConfigDiv").html(table.responseText);
	
	function query()
	{
		var table=$.ajax({url:"../common/querySystemConfig.action", data:$("#systemConfigReq").formSerialize(), async:false});
		$("#systemConfigDiv").html(table.responseText);
	}
	
	// 新增/更新窗口
	$( "#systemConfigEdit" ).dialog({
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
				if (!systemConfigFormCheck())
				{
					return false;
				}
				var form = $("#systemConfigForm");
				form.submit();
			}, 
			"关闭": function()
			{
				$("#systemConfigManagerSubmit").val("0");
				$("#systemConfigEdit").dialog("close"); 
			} 
		}
	});
	
	// 提交表单
	$("#systemConfigForm").submit(function()
	{
		if ($("#systemConfigManagerSubmit").val() == "0")
		{
			return false;
		}
		
		$("#systemConfigManagerSubmit").val("0");
		
		var options = { 
			url:"../common/editSystemConfig.action", // 提交给哪个执行
			type:'POST', 
			success: function(){
				$("#systemConfigEdit").dialog("close");
				// 新增完毕刷新form
				query();
				alert("操作成功");
			},
			error:function(){ 
				$("#systemConfigEdit").dialog("close"); 
				alert("操作失败"); 
			}
		};
		
		$("#systemConfigForm").ajaxSubmit(options);
		
		return false; // 为了不刷新页面,返回false，反正都已经在后台执行完了，没事！
	});  
	
	// 新增按钮
	$( "#addSystemConfig" ).button({
		icons: {
			primary: "ui-icon-plus"
			}
		}).click(function() {
		// 请求提交标志
		$("#systemConfigManagerSubmit").val("1");
		$( "#systemConfigEdit" ).dialog( "open" );
		var edit=$.ajax({url:"../common/editSystemConfigPage.action",async:false});
		$("#systemConfigForm").html(edit.responseText);
		return false;
	});
	
	 // 删除按钮
	$( "#deleteSystemConfig" ).button({
		icons: {
			primary: "ui-icon-minus"
			}
		}).click(function() {
		$("#systemConfigManagerSubmit").val("1");
		// 获取选中的记录ids
		var ids = "";
		var array = document.getElementsByName("systemConfigId");
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
			$("#systemConfigManagerSubmit").val("0");
			return false;
		}
		
		// ajax调用删除action
		var options = { 
			url:"../common/deleteSystemConfig.action?ids=" + ids , // 提交给哪个执行
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
		$("#systemConfigConfirm").dialog({
			resizable: false,
            height:160,
            modal: true,
            buttons: {
                "确认": function() {
                	$( this ).dialog( "close" );
                	// 异步请求删除操作
                	$("#systemConfigConfirm").ajaxSubmit(options);
                },
                "取消": function() {
                    $( this ).dialog( "close" );
                }
            }
		});
		return false;
	});
	 
	 // 启用按钮
	$( "#onSystemConfig" ).button({
		icons: {
			primary: "ui-icon-check"
			}
		}).click(function() {
			$("#systemConfigManagerSubmit").val("1");
			// 获取选中的记录ids
			var ids = "";
			var array = document.getElementsByName("systemConfigId");
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
				$("#systemConfigManagerSubmit").val("0");
				return false;
			}
			
			// ajax调用删除action
			var options = { 
				url:"../common/changeStatusSystemConfig.action?status=1&ids=" + ids , // 提交给哪个执行
				type:'POST', 
				success: function(){
					// 执行成功刷新form
					query();
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#systemConfigConfirm").ajaxSubmit(options);
			$("#systemConfigManagerSubmit").val("0");
			return false;
	});
	 
	 // 停用按钮
	$( "#offSystemConfig" ).button({
		icons: {
			primary: "ui-icon-close"
			}
		}).click(function() {
			$("#systemConfigManagerSubmit").val("1");
			// 获取选中的记录ids
			var ids = "";
			var array = document.getElementsByName("systemConfigId");
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
				$("#systemConfigManagerSubmit").val("0");
				return false;
			}
			
			// ajax调用删除action
			var options = { 
				url:"../common/changeStatusSystemConfig.action?status=0&ids=" + ids , // 提交给哪个执行
				type:'POST', 
				success: function(){
					// 执行成功刷新form
					query();
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#systemConfigConfirm").ajaxSubmit(options);
			$("#systemConfigManagerSubmit").val("0");
			return false;
	});
	
	 // 刷新按钮
	$( "#querySystemConfig" ).button().click(function() {
			query();
		return false;
	});
	 
	// 重置按钮
	$( "#clearSystemConfig" ).button().click(function() {
			$("#systemConfigReq").clearForm();
		return false;
	});
	
	// 页面校验
	function systemConfigFormCheck()
	{
		return true;
	}
});
</script>
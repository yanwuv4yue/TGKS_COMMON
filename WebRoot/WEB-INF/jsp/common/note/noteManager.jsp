<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderManager.inc.jsp" %>
<style type="text/css">
#noteReq{border:0px solid;}
#noteReq td{border:0px solid;}
#noteReq input{width:120px;}
#noteReq select{width:120px;}
</style>
<input type="hidden" id="noteManagerSubmit" name="noteManagerSubmit" value="0" />
<div class="ui-widget">
	<form id="noteReq" action="../common/queryNote.action" method="post">
		<table>
			<tr>
				<td><label>名称: </label></td><td><input type="text" name="noteReq.id" /></td>
				<td>
				
				</td>
				<td>
				<button id="clearNote">重置</button>
				<button id="queryNote">查询</button>
				</td>
			</tr>
		</table>
	</form>
</div>

<button id="addNote">新增</button>
<button id="deleteNote">删除</button>

<div id="noteDiv"></div>

<div id="noteEdit" title="Note Edit">
	<form id="noteForm" action="../common/editNote.action" method="post"></form>
</div>

<div id="noteConfirm" title="操作确认" hidden="hidden">
	<p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>记录将被删除且不可恢复，是否确认？</p>
</div>
<script type="text/javascript">
$(document).ready(function(){
	var table=$.ajax({url:"../common/queryNote.action",async:false});
	$("#noteDiv").html(table.responseText);
	
	function query()
	{
		var table=$.ajax({url:"../common/queryNote.action", data:$("#noteReq").formSerialize(), async:false});
		$("#noteDiv").html(table.responseText);
	}
	
	// 新增/更新窗口
	$( "#noteEdit" ).dialog({
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
				if (!noteFormCheck())
				{
					return false;
				}
				var form = $("#noteForm");
				form.submit();
			}, 
			"关闭": function()
			{
				$("#noteManagerSubmit").val("0");
				$("#noteEdit").dialog("close"); 
			} 
		}
	});
	
	// 提交表单
	$("#noteForm").submit(function()
	{
		if ($("#noteManagerSubmit").val() == "0")
		{
			return false;
		}
		
		$("#noteManagerSubmit").val("0");
		
		var options = { 
			url:"../common/editNote.action", // 提交给哪个执行
			type:'POST', 
			success: function(){
				$("#noteEdit").dialog("close");
				// 新增完毕刷新form
				query();
				alert("操作成功");
			},
			error:function(){ 
				$("#noteEdit").dialog("close"); 
				alert("操作失败"); 
			}
		};
		
		$("#noteForm").ajaxSubmit(options);
		
		return false; // 为了不刷新页面,返回false，反正都已经在后台执行完了，没事！
	});  
	
	// 新增按钮
	$( "#addNote" ).button({
		icons: {
			primary: "ui-icon-plus"
			}
		}).click(function() {
		// 请求提交标志
		$("#noteManagerSubmit").val("1");
		$( "#noteEdit" ).dialog( "open" );
		var edit=$.ajax({url:"../common/editNotePage.action",async:false});
		$("#noteForm").html(edit.responseText);
		return false;
	});
	
	 // 删除按钮
	$( "#deleteNote" ).button({
		icons: {
			primary: "ui-icon-minus"
			}
		}).click(function() {
		$("#noteManagerSubmit").val("1");
		// 获取选中的记录ids
		var ids = "";
		var array = document.getElementsByName("noteId");
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
			$("#noteManagerSubmit").val("0");
			return false;
		}
		
		// ajax调用删除action
		var options = { 
			url:"../common/deleteNote.action?ids=" + ids , // 提交给哪个执行
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
		$("#noteConfirm").dialog({
			resizable: false,
            height:160,
            modal: true,
            buttons: {
                "确认": function() {
                	$( this ).dialog( "close" );
                	// 异步请求删除操作
                	$("#noteConfirm").ajaxSubmit(options);
                },
                "取消": function() {
                    $( this ).dialog( "close" );
                }
            }
		});
		return false;
	});
	 
	 // 启用按钮
	$( "#onNote" ).button({
		icons: {
			primary: "ui-icon-check"
			}
		}).click(function() {
			$("#noteManagerSubmit").val("1");
			// 获取选中的记录ids
			var ids = "";
			var array = document.getElementsByName("noteId");
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
				$("#noteManagerSubmit").val("0");
				return false;
			}
			
			// ajax调用删除action
			var options = { 
				url:"../common/changeStatusNote.action?status=1&ids=" + ids , // 提交给哪个执行
				type:'POST', 
				success: function(){
					// 执行成功刷新form
					query();
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#noteConfirm").ajaxSubmit(options);
			$("#noteManagerSubmit").val("0");
			return false;
	});
	 
	 // 停用按钮
	$( "#offNote" ).button({
		icons: {
			primary: "ui-icon-close"
			}
		}).click(function() {
			$("#noteManagerSubmit").val("1");
			// 获取选中的记录ids
			var ids = "";
			var array = document.getElementsByName("noteId");
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
				$("#noteManagerSubmit").val("0");
				return false;
			}
			
			// ajax调用删除action
			var options = { 
				url:"../common/changeStatusNote.action?status=0&ids=" + ids , // 提交给哪个执行
				type:'POST', 
				success: function(){
					// 执行成功刷新form
					query();
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#noteConfirm").ajaxSubmit(options);
			$("#noteManagerSubmit").val("0");
			return false;
	});
	
	 // 刷新按钮
	$( "#queryNote" ).button().click(function() {
			query();
		return false;
	});
	 
	// 重置按钮
	$( "#clearNote" ).button().click(function() {
			$("#noteReq").clearForm();
		return false;
	});
	
	// 页面校验
	function noteFormCheck()
	{
		return true;
	}
});
</script>

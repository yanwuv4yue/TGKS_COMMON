<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderManager.inc.jsp" %>
<!-- 替换xox为命名空间，首字母小写，替换完成后删除注释 -->
<!-- 替换xxx为新增的类名，首字母小写，替换完成后删除注释 -->
<!-- 替换Xxx为新增的类名，首字母大写，替换完成后删除注释 -->
<style type="text/css">
#xxxReq{border:0px solid;}
#xxxReq td{border:0px solid;}
#xxxReq input{width:120px;}
#xxxReq select{width:120px;}
</style>
<input type="hidden" id="xxxManagerSubmit" name="xxxManagerSubmit" value="0" />
<div class="ui-widget">
	<form id="xxxReq" action="../xox/queryXxx.action" method="post">
		<table>
			<tr>
				<td><label>名称: </label></td><td><input type="text" name="xxxReq.name" /></td>
				<td>
				
				</td>
				<td>
				<button id="clearXxx">重置</button>
				<button id="queryXxx">查询</button>
				</td>
			</tr>
		</table>
	</form>
</div>

<button id="addXxx">新增</button>
<button id="deleteXxx">删除</button>
<button id="onXxx">启用</button>
<button id="offXxx">禁用</button>

<div id="xxxDiv"></div>

<div id="xxxEdit" title="Xxx Edit">
	<form id="xxxForm" action="../xox/editXxx.action" method="post"></form>
</div>

<div id="xxxConfirm" title="操作确认" hidden="hidden">
	<p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>记录将被删除且不可恢复，是否确认？</p>
</div>
<script type="text/javascript">
$(document).ready(function(){
	var table=$.ajax({url:"../xox/queryXxx.action",async:false});
	$("#xxxDiv").html(table.responseText);
	
	function query()
	{
		var table=$.ajax({url:"../xox/queryXxx.action", data:$("#xxxReq").formSerialize(), async:false});
		$("#xxxDiv").html(table.responseText);
	}
	
	// 新增/更新窗口
	$( "#xxxEdit" ).dialog({
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
				if (!xxxFormCheck())
				{
					return false;
				}
				var form = $("#xxxForm");
				form.submit();
			}, 
			"关闭": function()
			{
				$("#xxxManagerSubmit").val("0");
				$("#xxxEdit").dialog("close"); 
			} 
		}
	});
	
	// 提交表单
	$("#xxxForm").submit(function()
	{
		if ($("#xxxManagerSubmit").val() == "0")
		{
			return false;
		}
		
		$("#xxxManagerSubmit").val("0");
		
		var options = { 
			url:"../xox/editXxx.action", // 提交给哪个执行
			type:'POST', 
			success: function(){
				$("#xxxEdit").dialog("close");
				// 新增完毕刷新form
				query();
				alert("操作成功");
			},
			error:function(){ 
				$("#xxxEdit").dialog("close"); 
				alert("操作失败"); 
			}
		};
		
		$("#xxxForm").ajaxSubmit(options);
		
		return false; // 为了不刷新页面,返回false，反正都已经在后台执行完了，没事！
	});  
	
	// 新增按钮
	$( "#addXxx" ).button({
		icons: {
			primary: "ui-icon-plus"
			}
		}).click(function() {
		// 请求提交标志
		$("#xxxManagerSubmit").val("1");
		$( "#xxxEdit" ).dialog( "open" );
		var edit=$.ajax({url:"../xox/editXxxPage.action",async:false});
		$("#xxxForm").html(edit.responseText);
		return false;
	});
	
	 // 删除按钮
	$( "#deleteXxx" ).button({
		icons: {
			primary: "ui-icon-minus"
			}
		}).click(function() {
		$("#xxxManagerSubmit").val("1");
		// 获取选中的记录ids
		var ids = "";
		var array = document.getElementsByName("xxxId");
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
			$("#xxxManagerSubmit").val("0");
			return false;
		}
		
		// ajax调用删除action
		var options = { 
			url:"../xox/deleteXxx.action?ids=" + ids , // 提交给哪个执行
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
		$("#xxxConfirm").dialog({
			resizable: false,
            height:160,
            modal: true,
            buttons: {
                "确认": function() {
                	$( this ).dialog( "close" );
                	// 异步请求删除操作
                	$("#xxxConfirm").ajaxSubmit(options);
                },
                "取消": function() {
                    $( this ).dialog( "close" );
                }
            }
		});
		return false;
	});
	 
	 // 启用按钮
	$( "#onXxx" ).button({
		icons: {
			primary: "ui-icon-check"
			}
		}).click(function() {
			$("#xxxManagerSubmit").val("1");
			// 获取选中的记录ids
			var ids = "";
			var array = document.getElementsByName("xxxId");
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
				$("#xxxManagerSubmit").val("0");
				return false;
			}
			
			// ajax调用删除action
			var options = { 
				url:"../xox/changeStatusXxx.action?status=1&ids=" + ids , // 提交给哪个执行
				type:'POST', 
				success: function(){
					// 执行成功刷新form
					query();
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#xxxConfirm").ajaxSubmit(options);
			$("#xxxManagerSubmit").val("0");
			return false;
	});
	 
	 // 停用按钮
	$( "#offXxx" ).button({
		icons: {
			primary: "ui-icon-close"
			}
		}).click(function() {
			$("#xxxManagerSubmit").val("1");
			// 获取选中的记录ids
			var ids = "";
			var array = document.getElementsByName("xxxId");
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
				$("#xxxManagerSubmit").val("0");
				return false;
			}
			
			// ajax调用删除action
			var options = { 
				url:"../xox/changeStatusXxx.action?status=0&ids=" + ids , // 提交给哪个执行
				type:'POST', 
				success: function(){
					// 执行成功刷新form
					query();
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#xxxConfirm").ajaxSubmit(options);
			$("#xxxManagerSubmit").val("0");
			return false;
	});
	
	 // 刷新按钮
	$( "#queryXxx" ).button().click(function() {
			query();
		return false;
	});
	 
	// 重置按钮
	$( "#clearXxx" ).button().click(function() {
			$("#xxxReq").clearForm();
		return false;
	});
	
	// 页面校验
	function xxxFormCheck()
	{
		return true;
	}
});
</script>

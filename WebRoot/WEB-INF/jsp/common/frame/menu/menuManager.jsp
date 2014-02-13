<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style type="text/css">
#menuReq{border:0px solid;}
#menuReq td{border:0px solid;width:12%;}
</style>

<div class="ui-widget">
	<form id="menuReq" action="../common/queryMenu.action" method="post">
		<table>
			<tr>
				<td><label>菜单名称: </label></td><td><input type="text" name="menuReq.name" /></td>
				<td><label>所属模块: </label></td>
				<td>
					<select id="menuPreId" name="menuReq.preId">
						<option value="" ></option>
						<option value="0" >顶级模块</option>
						<s:iterator value="moduleList" var="evt">
							<option value="<s:property value='#evt.id'/>">
								<s:property value="#evt.name" />
							</option>
						</s:iterator>
					</select>
				</td>
				<td><label>状态: </label></td>
				<td>
					<select id="menuStatus" name="menuReq.status">
						<option value="" >全部</option>
						<option value="0" >禁用</option>
						<option value="1" >启用</option>
					</select>
				<td>
				<button id="clearMenu">重置</button>
				<button id="queryMenu">查询</button>
				</td>
			</tr>
		</table>
	</form>
</div>

<button id="addMenu">新增</button>
<button id="deleteMenu">删除</button>
<button id="onMenu">启用</button>
<button id="offMenu">禁用</button>

<div id="menuDiv"></div>

<div id="menuEdit" title="Menu Edit">
	<form id="menuForm" action="../common/editMenu.action" method="post"></form>
</div>

<div id="menuConfirm" title="操作确认" hidden="hidden">
	<p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>记录将被删除且不可恢复，是否确认？</p>
</div>
<script type="text/javascript">
$(document).ready(function(){
	function query()
	{
		var table=$.ajax({url:"../common/queryMenu.action", data:$("#menuReq").formSerialize(), async:false});
		$("#menuDiv").html(table.responseText);
	}
	
	query();
	
	// 新增/更新窗口
	$( "#menuEdit" ).dialog({
		height:500,
		width:750,
		autoOpen: false,
		show: "fold",
		hide: "fold",
		buttons:
		{ 
			"确定":function()
			{
				var form = $("#menuForm");
				form.submit();
			}, 
			"关闭": function()
			{
				$("#menuEdit").dialog("close"); 
			} 
		}
	});
	
	// 提交表单
	$("#menuForm").submit(function()
	{
		var options = { 
			url:"../common/editMenu.action", // 提交给哪个执行
			type:'POST', 
			success: function(){
				$("#menuEdit").dialog("close");
				// 新增完毕刷新form
				query();
				alert("操作成功");
			},
			error:function(){ 
				$("#menuEdit").dialog("close"); 
				alert("操作失败"); 
			}
		};
		
		$("#menuForm").ajaxSubmit(options);
		return false; // 为了不刷新页面,返回false，反正都已经在后台执行完了，没事！
	});  
	
	// 新增按钮
	$( "#addMenu" ).button({
		icons: {
			primary: "ui-icon-plus"
			}
		}).click(function() {
		$( "#menuEdit" ).dialog( "open" );
		var edit=$.ajax({url:"../common/editMenuPage.action",async:false});
		$("#menuForm").html(edit.responseText);
		return false;
	});
	
	 // 删除按钮
	$( "#deleteMenu" ).button({
		icons: {
			primary: "ui-icon-minus"
			}
		}).click(function() {
		// 获取选中的记录ids
		var ids = "";
		var array = document.getElementsByName("menuId");
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
			return false;
		}
		
		// ajax调用删除action
		var options = { 
			url:"../common/deleteMenu.action?ids=" + ids , // 提交给哪个执行
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
		$("#menuConfirm").dialog({
			resizable: false,
            height:160,
            modal: true,
            buttons: {
                "确认": function() {
                	$( this ).dialog( "close" );
                	// 异步请求删除操作
                	$("#menuConfirm").ajaxSubmit(options);
                },
                "取消": function() {
                    $( this ).dialog( "close" );
                }
            }
		});
				
		return false;
	});
	 
	 // 启用按钮
	$( "#onMenu" ).button({
		icons: {
			primary: "ui-icon-check"
			}
		}).click(function() {
			// 获取选中的记录ids
			var ids = "";
			var array = document.getElementsByName("menuId");
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
				return false;
			}
			
			// ajax调用删除action
			var options = { 
				url:"../common/changeStatusMenu.action?status=1&ids=" + ids , // 提交给哪个执行
				type:'POST', 
				success: function(){
					// 执行成功刷新form
					query();
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#menuConfirm").ajaxSubmit(options);
			return false;
	});
	 
	 // 停用按钮
	$( "#offMenu" ).button({
		icons: {
			primary: "ui-icon-close"
			}
		}).click(function() {
			// 获取选中的记录ids
			var ids = "";
			var array = document.getElementsByName("menuId");
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
				return false;
			}
			
			// ajax调用删除action
			var options = { 
				url:"../common/changeStatusMenu.action?status=0&ids=" + ids , // 提交给哪个执行
				type:'POST', 
				success: function(){
					// 执行成功刷新form
					query();
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#menuConfirm").ajaxSubmit(options);
			return false;
	});
	
	 // 刷新按钮
	$( "#queryMenu" ).button().click(function() {
			query();
		return false;
	});
	 
	// 重置按钮
	$( "#clearMenu" ).button().click(function() {
			$("#menuReq").clearForm();;
		return false;
	});
});
</script>

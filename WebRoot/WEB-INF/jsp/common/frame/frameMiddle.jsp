<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
  body { }
  .column { width: 320px; float: left; padding-bottom: 100px; }
  .column1 { width: 320px; float: left; padding-bottom: 100px; }
  .portlet { margin: 0 1em 1em 0; }
  .portlet-header { margin: 0.3em; padding-bottom: 4px; padding-left: 0.2em; }
  .portlet-header .ui-icon { float: right; }
  .portlet-content { padding: 0.4em; }
  .ui-sortable-placeholder { border: 1px dotted black; visibility: visible !important; height: 50px !important; }
  .ui-sortable-placeholder * { visibility: hidden; }
</style>
<script>
  
</script>
 
<div class="column">
	<div class="portlet">
		<div class="portlet-header">快捷按钮</div>
		<div class="portlet-content">
			<button id="writeNoteButton">写记事本</button>
		</div>
	</div>
	
	<div id="writeNote" title="写记事本">
		<form id="writeNoteForm" action="../common/editNote.action" method="post"></form>
	</div>
	
	<s:iterator  value="noteList" var="evt">
		<div class="portlet">
			<div class="portlet-header"><s:date name="#evt.createTime" format="yyyy-MM-dd HH:mm:ss"/></div>
			<div class="portlet-content">
				<textarea cols="45" rows="6"><s:property value="#evt.content"/></textarea>
			</div>
		</div>
	</s:iterator>
</div>

<div class="column">
 
  <div class="portlet">
    <div class="portlet-header">今日天气：</div>
    <div class="portlet-content">
		<iframe name="sinaWeatherTool" src="http://weather.news.sina.com.cn/chajian/iframe/weatherStyle31.html?city=%E8%8B%8F%E5%B7%9E" width="166" height="152" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
    </div>
  </div>
 
</div>
 
<div class="column">
 
</div>

<script src="<%=basePath%>js/common/frame/tgks_main.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	function query()
	{
		var table=$.ajax({url:"../common/login.action", data:$("#noteReq").formSerialize(), async:false});
		$("#noteDiv").html(table.responseText);
	}

	// 新增按钮
	$( "#writeNoteButton" ).button({
		icons: {
			primary: "ui-icon-plus"
			}
		}).click(function() {
		
		$( "#writeNote" ).dialog( "open" );
		var edit=$.ajax({url:"../common/editNotePage.action",async:false});
		$("#writeNoteForm").html(edit.responseText);
		return false;
	});
	
	// 新增/更新窗口
	$( "#writeNote" ).dialog({
		modal: true,
		height:300,
		width:400,
		autoOpen: false,
		show: "fold",
		hide: "fold",
		buttons:
		{ 
			"确定":function()
			{
				var form = $("#writeNoteForm");
				form.submit();
			}, 
			"关闭": function()
			{
				$("#writeNote").dialog("close"); 
			} 
		}
	});
	
	// 提交表单
	$("#writeNoteForm").submit(function()
	{
		var options = { 
			url:"../common/editNote.action", // 提交给哪个执行
			type:'POST', 
			success: function(){
				$("#writeNote").dialog("close");
				// 新增完毕刷新form
				query();
				alert("操作成功");
			},
			error:function(){ 
				$("#writeNote").dialog("close"); 
				alert("操作失败"); 
			}
		};
		
		$("#writeNoteForm").ajaxSubmit(options);
		
		return false; // 为了不刷新页面,返回false，反正都已经在后台执行完了，没事！
	});
});
</script>
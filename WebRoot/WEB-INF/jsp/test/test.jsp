<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<script src="<%=basePath%>resources/js/jquery.form.js"></script>
<form id="picForm" name="picForm" action="../common/uploadSingle.action" method="post"  enctype="multipart/form-data">
	<table>
		<tr>
			<td><label for="images">图片地址</label></td>
			<td>
				<input type="text" name="commodityEvt.images" id="commodityImages" class="text ui-widget-content ui-corner-all" value="${commodityEvt.images }" />
				<input type="file" name="single"  size="30"/><button id="uploadImage">上传</button>
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript">

$(document).ready(function(){
	// 上传按钮
	$( "#uploadImage" ).button().click(function() {
			
			// ajax调用删除action
			var options = { 
				url:"${pageContext.request.contextPath}/common/uploadSingle.action", // 提交给哪个执行
				type:'POST', 
				success: function(singleUrl){
					// 执行成功刷新form
					//alert(singleUrl);
					$("#commodityImages").val(singleUrl);
				},
				error:function(){ 
					alert("操作失败"); 
				}
			};
			
			$("#picForm").ajaxSubmit(options);
			return false;
	});
});
</script>
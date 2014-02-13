<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<!-- 替换xox为命名空间，首字母小写，替换完成后删除注释 -->
<!-- 替换xxx为新增的类名，首字母小写，替换完成后删除注释 -->
<!-- 替换Xxx为新增的类名，首字母大写，替换完成后删除注释 -->
<input type="hidden" id="xxxListSubmit" name="xxxListSubmit" value="0" />
<div id="xxxTableDiv" class="ui-widget">
    <table id="xxxTable" class="ui-widget ui-widget-content">
        <thead>
            <tr class="ui-widget-header ">
                <th width="20"><input type="checkbox" id="allXxxId" name="allXxxId"  /></th>
				<th>xxx</th>
            </tr>
        </thead>
        <tbody>
			<s:iterator  value="list" var="evt">
				<tr>
					<td width="20"><input type="checkbox" name="xxxId" value="<s:property value='#evt.id'/>" /></td>
					<td><b id="<s:property value='#evt.id'/>" class="xxxUpdate"><s:property value="#evt.name"/></b></td>
				</tr>
			</s:iterator>
		</tbody>
    </table>
</div>
<script type="text/javascript">
	$(function() {
		$('#xxxTable').longtable({
			'perPage' : 10
		});

		// 点击记录首栏进入更新操作
		$(".xxxUpdate").click(function() {
			$("#xxxManagerSubmit").val("1");
			$("#xxxEdit").dialog("open");
			var edit = $.ajax({
				url : "../xox/editXxxPage.action?id=" + this.id,
				async : false
			});
			$("#xxxForm").html(edit.responseText);
		});

		// 全选
		$("#allXxxId").click(function() {
			var checkbox = $("#xxxTable :checkbox");
			for ( var i = 1; i < checkbox.length; i++) {
				if (checkbox[i].hidden == "") {
					checkbox[i].checked = checkbox[0].checked;
				}
			}
		});
	});
</script>

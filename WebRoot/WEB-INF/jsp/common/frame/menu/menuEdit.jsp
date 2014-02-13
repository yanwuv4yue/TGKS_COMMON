<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp"%>
<table>
	<input type="hidden" name="menuEvt.id" id="menuId" value="${menuEvt.id }" />
	<input type="hidden" name="menuEvt.status" id="menuStatus" value="${menuEvt.status }" />
	<input type="hidden" name="menuEvt.level" id="menuLevel" value="${menuEvt.level }" />
	<tr>
		<td><label for="name">菜单名</label></td>
		<td><input type="text" name="menuEvt.name" id="menuName" class="text ui-widget-content ui-corner-all" value="${menuEvt.name }"/></td>
	</tr>
	<tr>
		<td><label for="url">URL地址</label></td>
		<td><input type="text" name="menuEvt.url" id="menuUrl" class="text ui-widget-content ui-corner-all" value="${menuEvt.url }" /></td>
	</tr>
	<tr>
		<td><label for="preId">所属模块</label></td>
		<td>
			<select id="menuPreId" name="menuEvt.preId" onchange="preIdChange(this);">
				<option value="0">新模块</option>
				<s:iterator value="moduleList" var="evt">
					<s:if test="#evt.id == menuEvt.preId">
						<option value="<s:property value='#evt.id'/>" selected="selected">
					</s:if>
					<s:else>
						<option value="<s:property value='#evt.id'/>">
					</s:else>
						<s:property value="#evt.name" />
					</option>
				</s:iterator>
			</select>
		</td>
	</tr>
	<tr>
		<td><label for="sort">展示顺序</label></td>
		<td><input type="text" name="menuEvt.sort" id="menuSort" class="text ui-widget-content ui-corner-all" value="${menuEvt.sort }" /></td>
	</tr>
</table>
<script type="text/javascript">
function preIdChange(option)
{
	var url = document.getElementById("menuUrl");
	var sort = document.getElementById("menuSort");
	if (option.value == 0)
	{
		url.value = "一级菜单不使用URL参数";
		url.disabled = "disabled";
		
		sort.value = "";
		sort.disabled = "";
	}
	else
	{
		url.value = "";
		url.disabled= "";
		
		sort.value = "继承上级菜单展示顺序";
		sort.disabled = "disabled";
	}
}
</script>
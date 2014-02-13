<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp"%>
<table>
	<input type="hidden" name="systemConfigEvt.id" id="menuId" value="${systemConfigEvt.id }" />
	<tr>
		<td><label for="name">标签</label></td>
		<td><input type="text" name="systemConfigEvt.tag" id="systemConfigTag" class="text ui-widget-content ui-corner-all" value="${systemConfigEvt.tag }"/></td>
	</tr>
	<tr>
		<td><label for="name">参数名</label></td>
		<td><input type="text" name="systemConfigEvt.name" id="systemConfigName" class="text ui-widget-content ui-corner-all" value="${systemConfigEvt.name }"/></td>
	</tr>
	<tr>
		<td><label for="name">参数值</label></td>
		<td><input type="text" name="systemConfigEvt.value" id="systemConfigValue" class="text ui-widget-content ui-corner-all" value="${systemConfigEvt.value }"/></td>
	</tr>
	<tr>
		<td><label for="name">类型</label></td>
		<td><input type="text" name="systemConfigEvt.type" id="systemConfigType" class="text ui-widget-content ui-corner-all" value="${systemConfigEvt.type }"/></td>
	</tr>
	<tr>
		<td><label for="name">所属模块</label></td>
		<td><input type="text" name="systemConfigEvt.module" id="systemConfigModule" class="text ui-widget-content ui-corner-all" value="${systemConfigEvt.module }"/></td>
	</tr>
	<tr>
		<td><label for="name">展示顺序</label></td>
		<td><input type="text" name="systemConfigEvt.sort" id="systemConfigSort" class="text ui-widget-content ui-corner-all" value="${systemConfigEvt.sort }"/></td>
	</tr>
</table>
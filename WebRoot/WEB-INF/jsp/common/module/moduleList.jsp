<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<table>
		<tr>
			<td></td>
			<td>模块名</td>
		</tr>
		<s:iterator  value="list" var="evt">
			<tr>
				<td><input type="radio" name="moduleId" value="<s:property value='#evt.id'/>"/></td>
				<td><s:property value="#evt.name"/></td>
			</tr>
		</s:iterator>
</table>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/common/TGKSHeaderList.inc.jsp" %>
<table>
	<tr>
		<td><label for="id">序号</label></td>
		<td>${systemLogEvt.id }</td>
		<td><label for="username">账号</label></td>
		<td>${systemLogEvt.username }</td>
	</tr>
	<tr>
		<td><label for="name">类型</label></td>
		<td>
			<s:if test="systemLogEvt.type == 0">查询</s:if><s:elseif test="systemLogEvt.type == 1">新增</s:elseif><s:elseif test="systemLogEvt.type == 2">修改</s:elseif><s:elseif test="systemLogEvt.type == 3">删除</s:elseif>
		</td>
		<td><label for="action">动作</label></td>
		<td>${systemLogEvt.action }</td>
	</tr>
	<tr>
		<td><label for="result">结果</label></td>
		<td>
			<s:if test="systemLogEvt.result == 0">成功</s:if><s:else>失败</s:else>
		</td>
		<td><label for="createTime">操作时间</label></td>
		<td><s:date name="systemLogEvt.createTime" format="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	<tr>
		<td><label for="remark">详细信息</label></td>
		<td colspan="3"><textarea name="systemLogEvt.info" id="systemLogEvtInfo" class="text ui-widget-content ui-corner-all" cols="95" rows="10">${systemLogEvt.info }</textarea></td>
	</tr>
</table>
<script type="text/javascript">
</script>
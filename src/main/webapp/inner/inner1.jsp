<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
	<jsp:include page="/header.jsp" />
	<title>Inner 1</title>
</head>
<body>
	<div class="title">子文件夹页面</div>
	<table class="info">
		<caption>当前环境变量</caption>
		<tr>
			<td>context path</td>
			<td>${contextpath}</td>
		</tr>
		<tr>
			<td>path info</td>
			<td>${pathinfo}</td>
		</tr>
		<tr>
			<td>servlet path</td>
			<td>${servletpath}</td>
		</tr>
		<tr>
			<td>uri</td>
			<td>${uri}</td>
		</tr>
		<tr>
			<td>url</td>
			<td>${url}</td>
		</tr>
		<tr>
			<td>query string</td>
			<td>${qs}</td>
		</tr>
	</table>

	<c:if test="${!empty managerstatus}">
	<fieldset style="margin-top:40px; display:inline-block;">
		<legend>DB Manager Status</legend>
		${managerstatus}
	</fieldset>
	</c:if>

	<jsp:include page="/footer.jsp" />
</body>
</html>

<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="zh-CN">
<head>
	<jsp:include page="/header.jsp" />
	<title>Page 1</title>
</head>
<body>
	<div class="title">搜索结果</div>
	<ul>
	<c:forEach var="m" items="${list}">
		<li><a href="2?id=${m.id}">${m.name}</a></li>
	</c:forEach>
	</ul>
	<jsp:include page="/footer.jsp" />
</body>
</html>

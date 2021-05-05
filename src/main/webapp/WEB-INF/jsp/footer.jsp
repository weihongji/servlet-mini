<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="footer">
	<c:if test="${empty param.home}">
	<a href="${requestScope.relative}">首页</a>
	</c:if>
</div>

<script src="${requestScope.relative}js/my.js"></script>

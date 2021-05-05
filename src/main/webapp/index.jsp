<%@ page contentType="text/html; charset=utf-8"%>
<!doctype html>
<html lang="zh-CN">
<head>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<title>Home</title>
	<style>
		#name {
			height: 2rem;
			border-radius: 0.25rem;
			border: 1px solid #ced4da;
			padding: 0.375rem 0.5rem;
		}

		#search {
			height:2rem;
			padding: 0 20px;
		}
	</style>
</head>
<body>
	<div class="title">Hello World</div>
	<form action="1" method="get">
		<input type="search" id="name" name="name" placeholder="name..." value="张">
		<input type="submit" id="search" value="搜索">
	</form>
	<a style="display:inline-block; margin-top:40px;" href="inner/1?p=abc">子文件夹页面</a>
	<jsp:include page="/WEB-INF/jsp/footer.jsp">
		<jsp:param name="home" value="false" />
	</jsp:include>
</body>
</html>

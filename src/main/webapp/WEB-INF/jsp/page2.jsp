<%@ page contentType="text/html; charset=utf-8"%>
<!doctype html>
<html lang="zh-CN">
<head>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<style>
		label {
			display: inline-block;
			width: 50px;
			text-align: right;
		}
		input {
			padding: 3px;
		}
		form>div {
			padding: 3px;
		}
	</style>
	<title>Page 2</title>
</head>
<body>
	<div class="title">编辑资料</div>
	<form method="post">
		<div>
			<label for="itemId">Id:</label>
			<input type="text" id="itemId" name="id" value="${item.id}">
		</div>
		<div>
			<label for="itemName">Name:</label>
			<input type="text" id="itemName" name="name" value="${item.name}">
		</div>
		<div>
			<input type="submit" style="margin: 10px 60px;">
		</div>
	</form>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>

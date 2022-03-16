<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CodeP | Landing</title>
		<link rel="stylesheet" href="/css/style.css">
	</head>
	<body>
		<main>
			<h2>Code Portal</h2>
			<hr style="margin-bottom: 40px" />
			<br>

			<h3>Welcome to the Portal!</h3>
			<p>
				Click the links below for direct access:
				<br>
				<a href="${pageContext.request.contextPath}/home">Homepage</a>
				<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
				<a href="${pageContext.request.contextPath}/systems">Access the systems</a>
			</p>
		</main>
	</body>
</html>

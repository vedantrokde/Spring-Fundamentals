<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CodeP | Error</title>
		<link
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
			crossorigin="anonymous"
		/>
		<link
			href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css"
			rel="stylesheet"
			crossorigin="anonymous"
		/>
		<link rel="stylesheet" href="/css/style.css" />
	</head>
	<body>
		<main>
			<h2>Code Portal</h2>
			<hr style="margin-bottom: 40px" />

			<div class="alert alert-danger" style="text-align: center; margin: auto; width: 80%;">
				Access Forbidden! <a href="${pageContext.request.contextPath}/home">Click here</a>  to go back to homepage.
			</div>
		</main>
	</body>
</html>

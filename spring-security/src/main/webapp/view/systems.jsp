<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CodeP | Systems Setting</title>
		<link rel="stylesheet" href="/css/style.css">
	</head>
	<body>
		<main>
			<h2>Systems Setting</h2>
			<hr style="margin-bottom: 40px" />

			<div style="float: right;">
				<form:form action="${pageContext.request.contextPath}/logout" method="POST">
					<input type="submit" value="Logout">
				</form:form>
			</div>

			<br>

			<h3>Hello <security:authentication property="principal.username" />!</h3>
			<p>
				Here you can organise your system for some task, could be new or old.
				Lorem ipsum dolor sit amet consectetur adipisicing elit. Cupiditate, officiis illum! Odit nulla earum cumque soluta, cum quidem voluptate ad voluptatem id aliquid hic unde expedita totam possimus doloribus saepe?
				<security:authentication property="principal.authorities" />
			</p>

			<div>
				<a href="${pageContext.request.contextPath}/home">Homepage</a>
			</div>
		</main>
	</body>
</html>

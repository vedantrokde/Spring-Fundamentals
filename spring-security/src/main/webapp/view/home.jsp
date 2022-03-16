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
		<title>CodeP | Homepage</title>
		<link rel="stylesheet" href="/css/style.css">
	</head>
	<body>
		<main>
			<h2>Code Portal</h2>
			<hr style="margin-bottom: 40px" />

			<div style="float: right;">
				<form:form action="${pageContext.request.contextPath}/logout" method="POST">
					<input type="submit" value="Logout">
				</form:form>
			</div>

			<br>

			<h3>Hello <security:authentication property="principal.username" />!</h3>
			<p>
				<security:authentication property="principal.authorities" />
			</p>

			<div>
				<security:authorize access="hasRole('MANAGER')">
					<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
				</security:authorize>
				
				<security:authorize access="hasRole('ADMIN')">
					<a href="${pageContext.request.contextPath}/systems">Access the systems</a>
				</security:authorize>
			</div>
		</main>
	</body>
</html>

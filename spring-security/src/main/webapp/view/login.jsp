<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CodeP | Login</title>
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

			<div style="width: 450; margin: auto">
				<h3>Login</h3>
				
				<br>
				<c:if test="${param.error!=null}">
					<div class="alert alert-danger" role="alert" style="width:fit-content; margin:auto; text-align: center;">
						Bad credentials. Try again!
					</div>
					<br>
				</c:if>

				<c:if test="${param.logout!=null}">
					<div class="alert alert-success" role="alert" style="width:fit-content; margin:auto; text-align: center;">
						You have logged out successfully!
					</div>
					<br>
				</c:if>
			
				<form:form
					action="${pageContext.request.contextPath}/authenticate"
					method="POST"
				>
					<table>
						<tbody>
							<tr>
								<td class="first">
									<label>User Name:</label>
								</td>
								<td>
									<input
										type="text"
										name="username"
										required
										autofocus
									/>
								</td>
							</tr>
							<tr>
								<td class="first"><label>Password:</label></td>
								<td>
									<input
										type="password"
										name="password"
										required
									/>
								</td>
							</tr>
							<tr>
								<td class="first">
									<a style="font-size: smaller" href="#"
										>Not a user? Signup
									</a>
								</td>
								<td>
									<input type="submit" value="Login" />
								</td>
							</tr>
						</tbody>
					</table>
				</form:form>
			</div>
		</main>
	</body>
</html>

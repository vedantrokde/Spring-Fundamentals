<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
</head>
<body>
    <h1>Welcome ${param.name}!</h1>
    <br>
    <h1> ${message} </h1>
    <br>
    <h1> ${student.firstName} ${student.lastName} from ${student.country} ${student.favoriteLanguage}</h1>
    <h1> ${customer.firstName} ${customer.lastName} ${customer.freePasses} ${customer.postalCode} ${customer.courseCode} </h1>
    <ul>
        <c:forEach var="temp" items="${student.operatingSystems}">
            <li>${temp}</li>
        </c:forEach>
    </ul>
</body>
</html>
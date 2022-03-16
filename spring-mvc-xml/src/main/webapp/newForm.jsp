<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration Form</title>
</head>
<body>
    <h1>Alien Welcome!</h1>

    <form:form action="processForm4" modelAttribute="student">
        First Name: <form:input path="firstName"/> <br><br>
        Last Name: <form:input path="lastName"/> <br><br>
        Country: 
        <form:select path="country">
            <!-- <form:option value="India" label="India"/>
            <form:option value="Brazil" label="Brazil"/>
            <form:option value="Canada" label="Canada"/>
            <form:option value="England" label="England"/> -->
            <form:options items="${student.countryOptions}"/>
        </form:select>
        <br><br>
        Favorite Language:

        <!-- Java <form:radiobutton path="favoriteLanguage" value="Java"/>
        C# <form:radiobutton path="favoriteLanguage" value="C"/>
        PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
        Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/> -->

        <form:radiobuttons path="favoriteLanguage" items="${student.languageOptions}"/>
        <br><br>

        Operating Systems: 
        Linux <form:checkbox path="operatingSystems" value="Linux" />
        Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
        MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
        <br><br>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
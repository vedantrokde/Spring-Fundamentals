<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
</head>
<body>
    <h1>Alien Welcome!</h1>
    <hr/>
    <h2>Add Alien to $DB</h2>
    <form action="addAlien">
        <label for="id">ID:</label><br>
        <input id="id" type="text" name="id"><br>
        <label for="name">Name:</label><br>
        <input id="name" type="text" name="name"><br><br>
        <label for="tech">tech:</label><br>
        <input id="tech" type="text" name="tech"><br><br>
        <input type="submit"><br>
    </form>
    <hr/>
    <h2>Get Alien from $DB</h2>
    <form action="getAlien">
        <label for="id">ID:</label><br>
        <input id="id" type="text" name="id"><br><br>
        <input type="submit"><br>
    </form>
    <hr/>
    <h2>Get Aliens from $DB</h2>
    <form action="getAlienByTech">
        <label for="tech">Tech:</label><br>
        <input id="tech" type="text" name="tech"><br><br>
        <input type="submit"><br>
    </form>
</body>
</html>
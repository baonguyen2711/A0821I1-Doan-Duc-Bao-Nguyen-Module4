<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/3/2022
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
    <input type="checkbox" name="condiment" id="checkLettuce" value="Lettuce">
    <label for="checkLettuce">Lettuce</label>
    <input type="checkbox" name="condiment" id="checkTomato" value="Tomato">
    <label for="checkTomato">Tomato</label>
    <input type="checkbox" name="condiment" id="checkMustard" value="Mustard">
    <label for="checkMustard">Mustard</label>
    <input type="checkbox" name="condiment" id="checkSprouts" value="Sprouts">
    <label for="checkSprouts">Sprouts</label>
    <br>
    <button type="submit">SAVE</button>
</form>
<h1>${condiment}</h1>
<h1 style="color: red;">${message}</h1>
</body>
</html>

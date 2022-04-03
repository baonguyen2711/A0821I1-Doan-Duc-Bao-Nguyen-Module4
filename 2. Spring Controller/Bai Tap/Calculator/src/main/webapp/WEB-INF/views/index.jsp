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
<h1>Calculator</h1>
<form action="calculator" method="post">
    <label>
        <input type="text" name="number1" placeholder="Enter Number 1">
    </label>
    <label>
        <input type="text" name="number2" placeholder="Enter Number 2">
    </label>
    <p>
    <input type="submit" name="calculator" value="Addition(+)">
    <input type="submit" name="calculator" value="Subtraction(-)">
    <input type="submit" name="calculator" value="Multiplication(X)">
        <input type="submit" name="calculator" value="Division(/)"></p>
</form>
<h1>Result ${calculator} : ${result}</h1>
</body>
</html>

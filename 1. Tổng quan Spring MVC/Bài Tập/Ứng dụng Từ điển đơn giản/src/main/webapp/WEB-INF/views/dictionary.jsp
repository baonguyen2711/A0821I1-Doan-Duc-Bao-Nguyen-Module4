<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/3/2022
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Converter</title>

</head>
<body>
<a href="/dictionary">BACK</a>
<form action="/dictionary" method="get">
    <label>Nhập từ</label>
    <input type="text" name="key">
    <button>Submit</button>
</form>
Result: ${dictionary}
<h1>${message}</h1>
</body>
</html>

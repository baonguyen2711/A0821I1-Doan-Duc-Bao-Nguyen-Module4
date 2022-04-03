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
<a href="/convert">BACK</a>
<h2>Currency Converter</h2>
<form action="/usd" method="get">
    <%--    <label>Rate: </label>--%>
    <%--    <input type="text" name="rate" placeholder="Rate" value="23400"><br>--%>
        <label>USD: </label>
        <input type="text" name="usd" placeholder="USD" value="0"><br><br>
        <label>VND: </label>
        <input type="text" name="vnd" placeholder="VND" value="0"><br><br>

    <%--</form>--%>
<%--    <h2>From Currency</h2>--%>
<%--    <input type="text" placeholder="Nhập số tiền" id="amount"><br>--%>
<%--&lt;%&ndash;    <select>&ndash;%&gt;--%>
<%--        <option typeof="text" name="vnd" value="0">VietNam</option>--%>
<%--&lt;%&ndash;        <option name="usd" value="0">USD</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </select><br>&ndash;%&gt;--%>

    <label>Rate: </label>
    <input type="text" name="rate" placeholder="Rate" value="23400"><br>
    <button type="submit">Convert</button>
</form>
<h3>RESULT: </h3>
<h3>VND : ${result1} VND</h3>
<h3>USD : ${result2} USD</h3>
</body>
</html>

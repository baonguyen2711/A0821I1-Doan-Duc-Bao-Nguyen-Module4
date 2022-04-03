
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #left {
            width: 50%;
            float: left;
        }
        #right{
            width: 50%;
            float: right;
        }
    </style>
</head>
<body>
<div id="left">
<h1>Update Email Configuration</h1>
<form:form modelAttribute="email" action="update" method="post">
    <table>
        <tr>
            <td style="font-weight: bold;font-size: 20px;padding-top:20px">Languages</td>
            <td style="padding:20px 0 0 80px"><form:select cssStyle="padding-right: 120px" path="language"
                                                           items="${language}"></form:select></td>
        </tr>
        <tr>
            <td style="font-weight: bold;font-size: 20px;padding-top:20px">Page Size</td>
            <td style="padding:20px 0 0 80px">Show <form:select path="pageSize" cssStyle="margin: 0 10px 0 10px"
                                                                items="${pageSize}"></form:select> emails per page
            </td>
        </tr>
        <tr>
            <td style="font-weight: bold;font-size: 20px;padding-top:20px">Spams Filter</td>
            <td style="padding:20px 0 0 80px"><form:checkbox path="spamsFilter" cssStyle="margin-right: 10px"
            ></form:checkbox> Enable spams filter
            </td>
        </tr>
        <tr>
            <td style="font-weight: bold;font-size: 20px;padding-bottom: 50px">Signature</td>
            <td style="padding:20px 0 0 80px"><form:textarea  path="signature" rows="6" cols="27"
            ></form:textarea></td>
        </tr>
        <tr>
            <td></td>
            <td style="padding:20px 0 0 80px">
                <button style="width: 40%;background-color: dodgerblue" type="submit">Update</button>
                <button style="width: 40%;margin-left: 20px" type="reset">Cancel</button>

            </td>
        </tr>

    </table>
</form:form>
</div>
<div id="right">
    <h1>Email Configuration</h1>
    <h3>Languages : ${email.language}</h3>
    <h3>Page Size : ${email.pageSize}</h3>
    <h3>Spams Filter : ${email.spamsFilter}</h3>
    <h3>Signature: ${email.signature}</h3>
</div>
</body>
</html>

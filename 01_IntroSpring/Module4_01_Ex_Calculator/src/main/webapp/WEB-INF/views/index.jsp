<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/13/2021
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculator" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <th>First operand</th>
                <th><input type="text" name="firstOperand"></th>
            </tr>
            <tr>
                <th>Operator</th>
                <th><input type="text" name="operator""></th>
            </tr>
            <tr>
                <th>Second operand</th>
                <th><input type="text" name="secondOperand""></th>
            </tr>
            <tr>
                <th></th>
                <th><input type="submit" id="submit"></th>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

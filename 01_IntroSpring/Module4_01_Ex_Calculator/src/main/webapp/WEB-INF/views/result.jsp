<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/13/2021
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <th>First operand</th>
                <th><input type="text" name="firstOperand" value="${firstOperand}"></th>
            </tr>
            <tr>
                <th>Operator</th>
                <th><input type="text" name="operator" value="${operator}"></th>
            </tr>
            <tr>
                <th>Second operand</th>
                <th><input type="text" name="secondOperand" value="${secondOperand}"></th>
            </tr>
            <tr>
                <th></th>
                <th><input type="submit" id="submit"></th>
            </tr>
            <tr>
                <th>Result</th>
                <th><input type="text" id="result" value="${result}"></th>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>

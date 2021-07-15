<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/14/2021
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
    <c:forEach var="condiment" items="${condiments}">
        <input type="checkbox" name="condiment" value="${condiment.name}">${condiment.name}
    </c:forEach>
    <button>Submit</button>
</form>
</body>
</html>

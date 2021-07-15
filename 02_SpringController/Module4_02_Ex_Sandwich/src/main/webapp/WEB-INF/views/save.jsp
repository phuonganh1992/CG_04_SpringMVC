<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/15/2021
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="name" items="${names}">
    ${name}
</c:forEach>

</body>
</html>

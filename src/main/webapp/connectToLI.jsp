<%@ page import="edu.matc.entity.LinkedIn" %><%--
  Created by IntelliJ IDEA.
  User: nicolesteck
  Date: 3/17/18
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body><a href="<%
    LinkedIn linkedIn = new LinkedIn();


%>">Connect to LinkedIn</a>
<a href="   <% linkedIn.getAuthorizationUrl(); %>">get Auth URL</a>


</body>
</html>

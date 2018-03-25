<%@ page import="java.util.Properties" %>
<%@ page import="edu.matc.entity.LinkedIn" %>
<%--
  Created by IntelliJ IDEA.
  User: nicolesteck
  Date: 3/1/18
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%LinkedIn li = new LinkedIn();%>
<html>
<head>
    <title>Create A New Account</title>
</head>
<body>
<FORM ACTION="newUser" METHOD="POST">
    <TABLE>
        <TR><TD>First Name: <INPUT TYPE="TEXT" NAME="firstName"></TD></TR>
        <TR><TD>Last Name: <INPUT TYPE="TEXT" NAME="lastName"></TD></TR>
        <TR><TD>Email: <INPUT TYPE="TEXT" NAME="email"></TD></TR>
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="username"></TD></TR>
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="password"></TD></TR>
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In"></TH></TR>
    </TABLE>
</FORM>
</body>
</html>


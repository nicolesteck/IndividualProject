<%--
  Created by IntelliJ IDEA.
  User: nicolesteck
  Date: 3/1/18
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <tr><td><a href="https://www.linkedin.com/uas/oauth2/authorization?response_type=code&client_id=XXX&scope=r_basicprofile&state=13378675309&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fnsindieproject%2F">Sign In with LI</a></td></tr>
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>
</body>
</html>

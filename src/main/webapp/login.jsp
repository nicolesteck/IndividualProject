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
    <title>Login</title>
</head>
<body>
<h1><% String clientId = li.getClientId(); %></h1>
<h1>The client ID is <%= clientId %></h1>
<script>
    var urlFirst = "https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=";
    var urlSecond = "<%= clientId %>";
    var urlThird = "&redirect_uri=http://localhost:8080/nsindieproject/importConnections&state=13378675309&scope=r_basicprofile";
    var url = urlFirst + urlSecond + urlThird;
</script>
<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">




        ">Sign In with LI</a></td></tr>
       <!-- <tr><td><a href="javascript:url">Sign In with LI</a></td></tr>  -->
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>
</body>
</html>

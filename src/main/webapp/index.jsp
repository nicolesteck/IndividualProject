<%@include file="head.jsp"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<html>
<body>

<h2>Project - Users</h2>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
    url = "jdbc:mysql://localhost:3306/li_annotate"
    user = "root" password = "password" />

<sql:query dataSource = "${snapshot}" var = "result">
    SELECT * FROM users;
</sql:query>
<table>
<c:forEach var="row" items = "${results.rows}">
    <tr>
        <td><c:out value = "${row.first_name}"/></td>
    </tr>
</c:forEach>
</table>


</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <h2>All Users</h2>
    <%-- ${users} --%>
    <table>
        <c:forEach var="user" items="${users}">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Connections</th>
            </tr>
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>
                <c:forEach var="connection" items="${user.connections}">
                    ${connection.firstName} ${connection.lastName} ${connection.numberOfConnections}
                </c:forEach>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>
</body>
</html>

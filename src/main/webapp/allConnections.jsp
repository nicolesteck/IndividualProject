<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <h2>All Connections</h2>
    <%-- ${users} --%>
    <table>
        <c:forEach var="connection" items="${connections}">
            <tr>
                <td>${connection.firstName}</td>
                <td>${connection.lastName}</td>
                <td>${connection.numberOfConnections}</td>
            </tr>

        </c:forEach>

    </table>
</div>

</body>
</html>

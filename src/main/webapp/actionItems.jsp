<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
IN ACTIONITEMS
<c:forEach var="connection" items="${connections}">
    <tr>
        <td>${connection.firstName}</td>
        <td>${connection.lastName}</td>
        <td>${connection.numberOfConnections}</td>
    </tr>

</c:forEach>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
IN ACTIONITEMS

<c:forEach var="actionItem" items="${actionItems}">
    <tr><td>SOME STUFF!</td></tr>
    <tr>
        <td>${actionItem.actionItemName}</td>
        <td>${actionItem.dateCreated}</td>
    </tr>

</c:forEach>
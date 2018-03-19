<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="edu.matc.entity.ActionItem" %>


<c:forEach var="actionItem" items="${actionItems}">
    <tr><td>ACTION ITEMS</td></tr>
    <tr>
        <td>${actionItem.actionItemName}</td>
    </tr><tr>
        <td>${actionItem.dateCreated}</td>
    </tr>
    <tr><td><% %></td></tr>

</c:forEach>
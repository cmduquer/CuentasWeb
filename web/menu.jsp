<%-- 
    Document   : menu
    Created on : Aug 5, 2018, 5:40:44 PM
    Author     : cmduquer
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty login}">
    <a href="login.jsp">login</a>
    <a href="newAccount.jsp">Register</a>
</c:if>
<c:if test="${not empty login}">
    <a href="AccountServlet?action=logout">Logout</a>
    <a href="AccountServlet?action=list">List Accounts</a>
</c:if>
<a href="about.jsp">about</a>
<hr/>
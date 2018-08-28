<%-- 
    Document   : FileList
    Created on : Aug 28, 2018, 10:56:33 AM
    Author     : cmduquer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Images</h1>
        <c:forEach var="a" items="${files}">
            |${a.fsPk}| |${a.fileName}| <img src="DisplayImage?id=${a.fsPk}" width="50%"/>
            <a onclick="return confirm('Desea eliminar?')" href="FileServlet?action=delete&id=${a.fsPk}">Delete</a>
            <hr/>
        </c:forEach>
    </body>
</html>

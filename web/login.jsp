<%-- 
    Document   : login
    Created on : Aug 5, 2018, 5:41:15 PM
    Author     : cmduquer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>SignIn</h1>
    <c:if test="${param.error==1}">
        <font color="red">Wrong User<font/>
    </c:if>
        <div class="container well">
            <form action="AccountServlet?action=login" method="post">
                <table>
                    <tr>
                        <th>
                            <label><b>Username:</b></label>
                        </th>
                        <th>
                            <input type="text" placeholder="Enter Username" class="form-control" name="username" required="true">
                        </th>
                    </tr>
                        
                    <tr>
                        <th>
                            <label><b>Password:</b></label>
                        </th>
                        <th>
                            <input type="text" placeholder="Enter Password" class="form-control" name="password" required="true">
                        </th>
                    </tr>
                    <div class="break"></div>
                    <tr>
                        <td colspan="2">
                            <input type="submit" class="btn icon-btn btn-success" name="action" value="Login">
                            <span class="glyphicon glyphicon-lock"></span>
                            
                            <input type="reset" class="btn btn-info btn-lg" name="action" value="Reset">
                            <span class="glyphicon glyphicon-remove"></span>
                        </td>
                    </tr>
                </table>
                
            </form>
            
        </div>    
    </body>
</html>

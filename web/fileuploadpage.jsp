<%-- 
    Document   : fileuploadpage
    Created on : Aug 28, 2018, 10:36:17 AM
    Author     : cmduquer
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File/Image Upload Page</title>
    </head>
    <body>
        <h1>Select the file and click on the Submit button!</h1>
        <br />
        <form method="post" enctype="multipart/form-data" action="FileUploadServlet">
            <input type="file" name="selectedFile" value="Select a File..." /><br />
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>

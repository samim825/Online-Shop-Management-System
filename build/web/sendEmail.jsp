<%-- 
    Document   : sendEmail
    Created on : Aug 25, 2019, 10:33:13 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <form action="SendingEmail" method="POST">  
            To:<input type="text" name="to"/><br/>  
            Subject:<input type="text" name="subject"><br/>  
            Text:<textarea rows="10" cols="70" name="msg"></textarea><br/>  
            <input type="submit" value="send"/>  
        </form>  

    </body>
</html>

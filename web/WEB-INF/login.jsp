
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1><b>Login</b></h1>
        <form method="post" action="login">
            
            <label>Username:</label>
            <input type="text" name="username" value="${username}">
            
            <br>
            <br>
            <label>Password:</label>
            <input type="password" name="password" value="${password}">
            <br>
            <br>
            <input type="submit" value="Log In">
        </form>
        
         <c:if test="${message !=null}">
             <p><i>${message}</i></p>
        </c:if>
        
            
        
    </body>
</html>

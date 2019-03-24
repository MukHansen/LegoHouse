<%-- 
    Document   : index
    Created on : 21-03-2019, 20:27:12
    Author     : Mkhansen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LegoHouse Login</title>
    </head>
    <body>
        <h1>Welcome to LegoHouseIkea</h1>
        <table>
            <tr><td>Login</td>
                <hr>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input type="text" name="email" value="robin@somewhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password" value="batman">
                        <br>
                        <input type="submit" value="Login">
                    </form>
                </td>
                <td>Or Register</td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input type="text" name="email" value="someone@nowhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" value="sesam">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" value="sesam">
                        <br>
                        <input type="submit" value="Register User">
                    </form>
                </td>
            </tr>
        </table>
        <hr>
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
        %>
    </body>
</html>

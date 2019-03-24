<%-- 
    Document   : orderPage
    Created on : 20-03-2019, 17:29:47
    Author     : Mkhansen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>This is the order page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter("email")%> </h1>
        <p> Make an order below
            
        </p>
        <table>

            <form name="addproduct" action="FrontController" method="post">
                <input type="hidden" name="command" value="createOrder">
                <tr><td>
                        Length:<br>            
                        <input type="number" name="length" value="1">
                    </td>
                    <td>
                        Width: <br>
                        <input type="number" name="width" value="1">
                    </td>
                    <td>
                        Height: <br>
                        <input type="number" name="height" value="1">
                    </td>
                    <td>
                        <br>
                        <input type="submit" value="Create order">
                    </td>
                </tr>
            </form>
        </table>
        <form name="login" action="FrontController" method="POST">
            <input type="hidden" name="command" value="pastOrders">
            <br>
            <input type="submit" value="PastOrders">
        </form>
    </body>
</html>

<%-- 
    Document   : confirmationPage
    Created on : 24-03-2019, 15:24:11
    Author     : Mkhansen
--%>

<%@page import="logic.OrderLine"%>
<%@page import="logic.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation Page</title>
    </head>
    <body>
        <h1>This is the order confirmation page</h1>
        <hr>
        
        <%
            Order order = (Order)session.getAttribute("order");
            OrderLine orderline = (OrderLine)session.getAttribute("orderline");
            
            out.println("Your order for "+order.getLength()+"x"+order.getWidth()+"x"+order.getHeight()+ " Will require the following bricks");
            %>
            <hr>
            <%
            out.println("Your legohouse will need the following bricks<br>"
                    +"Long: " +orderline.getLongBrick()+"<br>"
                    +"Medium: "+orderline.getMediumBrick()+"<br>"
                    +"Small: "+orderline.getSmallBrick()+"<br>");
        %>

        <form name="confirmorder" action="FrontController" method="post">
            <input type="hidden" name="command" value="confirmorder">
            <input type="submit" value="Confirm Order">
        </form>
    </body>
</html>
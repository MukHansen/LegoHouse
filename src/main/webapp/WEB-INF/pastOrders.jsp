<%-- 
    Document   : pastorders
    Created on : 20-03-2019, 19:14:32
    Author     : Mkhansen
--%>

<%@page import="java.util.List"%>
<%@page import="logic.Order"%>
<%@page import="logic.OrderLine"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
        <title>PastOrders</title>
    </head>
    <body>
        <h2>Welcome <% out.print(session.getAttribute("email")); %></h2>
        <ul>
            <style>
                ul {
                    border-radius: 20px;
                    margin: 5;
                    padding: 0;
                    width: 150px;
                    background-color: #4CAF50;
                }
                li a {
                    text-align: center;
                    display: block;
                    color: #000;
                    padding: 8px 16px;
                    text-decoration: white;
                }
                li a:hover:not(.active) {
                    border-radius: 20px;
                    background-color: black;
                    color: white;
                }
                h2 {
                    text-align: center;
                }
                h3{
                    text-align: right;
                }
                table, th, td {
                    border: 1px solid black;
                }
                th {
                    color: black;
                }
                table {
                    width: 25%;
                }

                th {
                    height: 50px;
                }
                .radiotext {
                    margin: 10px 10px 0px 0px;
                }
                .button {
                    background-color: #4CAF50;
                    border-radius: 20px;
                    color: black;
                    padding: 16px 32px;
                    text-align: center;
                    display: inline-block;
                    font-size: 16px;
                    margin: 4px 2px;
                    transition-duration: 0.4s;
                    cursor: pointer;
                }
            </style>
        </ul>
        <table class="table table-striped">

            <thead><tr><th>Length</th><th>Width</th><th>Height</th></tr></thead> <tbody>
                        <% ArrayList<Order> listOfOrders = (ArrayList<Order>)request.getAttribute("mytable");
                            for (int i = 0; i < listOfOrders.size(); i++) {
                        %>

                <tr>
                    <td><%= listOfOrders.get(i).getLength() %></td><td><%= listOfOrders.get(i).getWidth()%></td><td><%= listOfOrders.get(i).getHeight()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

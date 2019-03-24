/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LegoHouseException;
import logic.LogicFacade;
import logic.Order;
import logic.OrderLine;

/**
 *
 * @author Mkhansen
 */
public class CreateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHouseException {
        int length = Integer.parseInt(request.getParameter("length"));
        int height = Integer.parseInt(request.getParameter("height"));
        int width = Integer.parseInt(request.getParameter("width"));
        Order order = LogicFacade.createOrder((int) request.getSession().getAttribute("user_id"),length, width, height);
        OrderLine orderline = logic.OrderCalculator.calculateOrder(order);
        HttpSession session = request.getSession();
        session.setAttribute("order", order);
        session.setAttribute("orderline", orderline);
        return "confirmationPage";
    }

}

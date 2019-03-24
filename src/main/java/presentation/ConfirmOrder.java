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
import logic.User;

/**
 *
 * @author Mkhansen
 */
public class ConfirmOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHouseException {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");
        User user = (User) session.getAttribute("user");
        LogicFacade.createOrder(order.getId(), order.getLength(), order.getWidth(), order.getHeight() );
        return "orderPage";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.ArrayList;
import java.util.List;
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
public class PastOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHouseException {
        User user = (User)request.getAttribute("user");
        request.setAttribute("mytable", logic.LogicFacade.getPastOrders(user) );
        return "pastOrders";
    }
    
}

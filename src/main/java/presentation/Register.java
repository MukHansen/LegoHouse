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
import logic.User;

/**
 *
 * @author Mkhansen
 */
public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws logic.LegoHouseException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            User user = LogicFacade.createUser(email, password1, 0);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "login";
        } else {
            throw new LegoHouseException("the two passwords did not match");
        }
    }

}

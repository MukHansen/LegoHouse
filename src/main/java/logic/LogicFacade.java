/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DBAccessor;
import java.util.ArrayList;

/**
 *
 * @author Mkhansen
 */
public class LogicFacade {

    public static User login(String email, String password) throws LegoHouseException {
        return DBAccessor.login(email, password);
    }

    public static User createUser(String email, String password, int id) throws LegoHouseException {
        User user = new User(email, password, id);
        DBAccessor.createUser(user);
        return user;
    }

    public static Order createOrder(int id, int length, int width, int height) throws LegoHouseException {
        Order order = new Order(id, length, width, height);
        DBAccessor.createOrder(order);
        return order;
    }

    public static ArrayList<Order> getPastOrders(User user) {
        ArrayList<Order> list = DBAccessor.getPastOrders(user);
        return list;
    }
    public static User getUser(String email, String password){
        return DBAccessor.getUser(email);
    }

}

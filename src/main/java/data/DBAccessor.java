/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import logic.LegoHouseException;
import logic.Order;
import logic.User;

/**
 *
 * @author Bruger
 */
public class DBAccessor {
    private static int counter = 3;

    public static ArrayList<Order> getPastOrders(User user) {
        ArrayList<Order> list = new ArrayList<>();

        try {
            DBConnector c = new DBConnector();

            String query = "SELECT * FROM orders WHERE user_id = " + user.getId() + ";";

            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");

                list.add(new Order(user.getId(), length, width, height));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static User getUser(String email) {
        User user = null;

        try {
            DBConnector c = new DBConnector();
            String query = "SELECT * FROM users WHERE user_email = '" + email + "';";

            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String password = rs.getString("user_password");
                int id = rs.getInt("user_id");
                user = new User(email, password, id);
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User createUser(User user) throws LegoHouseException {
            
        try {
            DBConnector c = new DBConnector();
            Connection connection = c.getConnection();
            counter++;

            String insert = "INSERT INTO users VALUES ('" + counter + "','" + user.getEmail() + "','" + user.getPassword() +"');";

            Statement stmt = connection.createStatement();
            PreparedStatement preparedStmt = connection.prepareStatement(insert);
            preparedStmt.execute();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new LegoHouseException(user.getEmail() + " Already in use");
        }
    }
        public static User login( String email, String password ) throws LegoHouseException {
        try {
            DBConnector c = new DBConnector();
            Connection connection = c.getConnection();
            
            String SQL = "SELECT user_id FROM users "
                    + "WHERE user_email=? AND user_password=?";
            PreparedStatement ps = connection.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                int id = rs.getInt( "user_id" );
                User user = new User( email, password, id);
                return user;
            } else {
                throw new LegoHouseException( "Could not validate user" );
            }
        } catch (SQLException ex ) {
            throw new LegoHouseException(ex.getMessage());
        }
    }
            public static Order createOrder(Order order) throws LegoHouseException {

        try {
            DBConnector c = new DBConnector();
            Connection connection = c.getConnection();

            String insert = "INSERT INTO orders VALUES ('" 
                    + order.getId() + "','" 
                    + order.getLength() + "','" 
                    + order.getWidth() + "','" 
                    + order.getHeight() +"');";

            Statement stmt = connection.createStatement();
            PreparedStatement preparedStmt = connection.prepareStatement(insert);
            preparedStmt.execute();
            return order;
        } catch (Exception e) {
            throw new LegoHouseException("Something went wrong, try againg later");
        }
    }
}

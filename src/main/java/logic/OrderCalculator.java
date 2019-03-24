/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Mkhansen
 */
public class OrderCalculator {

    public static OrderLine calculateOrder(Order order) {
        int smallBricks = 0;
        int mediumBricks = 0;
        int longBricks = 0;
        int remainder = 0;
        longBricks = order.getLength() / 4;
        remainder = order.getLength() % 4;

        if (remainder >= 2) {
            mediumBricks++;
            remainder -= 2;
        }
        if (remainder == 1) {
            smallBricks++;
            remainder = 0;
        }

        longBricks += (order.getWidth() - 4) / 4;
        remainder = (order.getWidth() - 4) % 4;

        if (remainder >= 2) {
            mediumBricks++;
            remainder -= 2;
        }
        if (remainder == 1) {
            smallBricks++;
            remainder = 0;
        }

        longBricks += longBricks;
        mediumBricks += mediumBricks;
        smallBricks += smallBricks;

        if (order.getHeight() > 1) {
            longBricks = longBricks * order.getHeight();
            mediumBricks = mediumBricks * order.getHeight();
            smallBricks = smallBricks * order.getHeight();
        }

        OrderLine orderline = new OrderLine(longBricks, mediumBricks, smallBricks, order.getHeight());
        return orderline;
    }

}

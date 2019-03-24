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
public class OrderLine {
    private int smallBrick;
    private int mediumBrick;
    private int longBrick;
    private int height;

    public OrderLine(int smallBrick, int mediumBrick, int longBrick, int height) {
        this.smallBrick = smallBrick;
        this.mediumBrick = mediumBrick;
        this.longBrick = longBrick;
        this.height = height;
    }

    public int getSmallBrick() {
        return smallBrick;
    }

    public void setSmallBrick(int smallBrick) {
        this.smallBrick = smallBrick;
    }

    public int getMediumBrick() {
        return mediumBrick;
    }

    public void setMediumBrick(int mediumBrick) {
        this.mediumBrick = mediumBrick;
    }

    public int getLongBrick() {
        return longBrick;
    }

    public void setLongBrick(int longBrick) {
        this.longBrick = longBrick;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}

package org.lld;

import java.util.Random;

public class Dice {
    private int sides;

    private int top;

    public Dice(int sides){
        this.sides = sides;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public Integer roll(){
        Random rn = new Random();
        Integer top = Math.abs(rn.nextInt()%sides+1);
        return Integer.valueOf(top);
    }
}

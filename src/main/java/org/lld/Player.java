package org.lld;

public class Player {

    private String name;
    private Integer id;
    private Integer currentPos;

    public Player(String name) {
        this.name = name;
        this.currentPos = Integer.valueOf(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(Integer currentPos) {
        this.currentPos = currentPos;
    }

    public Integer rollDice(Dice dice){
        int top = dice.roll().intValue();
        while(top==0){
            top = dice.roll().intValue();
        }
        return Integer.valueOf(top);
    }
}

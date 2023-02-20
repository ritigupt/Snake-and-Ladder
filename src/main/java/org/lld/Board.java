package org.lld;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private int size;
    private Map<Integer, Integer> snakes = new HashMap<Integer,Integer>();
    private Map<Integer, Integer> ladders = new HashMap<Integer,Integer>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private boolean isCycle(Snake snake){
        for(Map.Entry<Integer,Integer> ladder:ladders.entrySet()){
            if(ladder.getKey()==snake.getTail() && ladder.getValue()==snake.getHead()) return true;
        }
        return false;
    }

    private boolean isCycle(Ladder ladder){
        for(Map.Entry<Integer,Integer> snake:snakes.entrySet()){
            if(snake.getKey()==ladder.getTop() && snake.getValue()==ladder.getBase()) return true;
        }
        return false;
    }

    public Board(int size){
        this.size = size;
    }

    public void addSnake(Snake snake){
        int head = snake.getHead().intValue();
        int tail = snake.getTail().intValue();
        if(head>=(size*size) || tail>=(size*size)){
            System.out.println("Invalid head/tail position of Snake: Out of board.");
        }else if(head/size==tail/size){
            System.out.print("Invalid head/tail position of Snake: head and tail in same row.");
        }else if(isCycle(snake)){
            System.out.println("Invalid head/tail position of Snake: Cycle formed");
        }else{
            snakes.put(snake.getHead(),snake.getTail());
        }
    }

    public void addLadder(Ladder ladder){
        int top = ladder.getTop().intValue();
        int base = ladder.getBase().intValue();
        if(top>(size*size) || base>=(size*size)){
            System.out.println("Invalid top/base position of Ladder: Out of board.");
        }else if(top/size==base/size){
            System.out.print("Invalid top/base position of Ladder: head and tail in same row.");
        }else if(isCycle(ladder)){
            System.out.println("Invalid top/base position of Ladder: Cycle formed");
        }else{
            ladders.put(ladder.getBase(),ladder.getTop());
        }
    }

    public boolean isSnakeAt(Integer piece) {
        return snakes.containsKey(piece);
    }

    public int getTailForSnake(Integer head) {
        return snakes.get(head).intValue();
    }

    public boolean isLadderAt(Integer piece) {
        return ladders.containsKey(piece);
    }

    public int getTopForLadder(Integer base) {
        return ladders.get(base).intValue();
    }
}

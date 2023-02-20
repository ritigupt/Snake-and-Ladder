package org.lld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    Board board;
    Map<Integer,Player> playerMap = new HashMap<Integer,Player>();
    List<Player> players = new ArrayList<Player>();
    List<Dice> dices = new ArrayList<Dice>();
    Player turnPlayer;
    Player winner;
    GameState state;
    public Game(){
        state = GameState.IDLE;
    }

    public void start(){
        state = GameState.STARTED;
        turnPlayer = playerMap.get(Integer.valueOf(1));
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
        for(Player p:players){
            this.playerMap.put(p.getId(),p);
        }
    }

    public List<Dice> getDices() {
        return dices;
    }

    public void setDices(List<Dice> dices) {
        this.dices = dices;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public Player currentTurn(){
        return turnPlayer;
    }

    public void move(Player p, int moves){
       int currPos = p.getCurrentPos().intValue()+moves;
       if(board.isSnakeAt(Integer.valueOf(currPos))){
           currPos = board.getTailForSnake(Integer.valueOf(currPos));
       }else if(board.isLadderAt(Integer.valueOf(currPos))){
           currPos = board.getTopForLadder(Integer.valueOf(currPos));
       }
       if(currPos< board.getSize()* board.getSize()){
           System.out.println("Player "+p.getName()+" reaches "+currPos);
           turnPlayer.setCurrentPos(currPos);
       }else if(currPos==board.getSize()*board.getSize()){
           System.out.println("Player "+p.getName()+"reaches 100");
           winner = p;
           state = GameState.ENDED;
       }else{
           System.out.println("Player "+p.getName()+" cannot be moved");
       }
       //next Player turn
       turnPlayer = playerMap.get(Integer.valueOf(turnPlayer.getId().intValue() % players.size()+1));
    }
}

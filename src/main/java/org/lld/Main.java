package org.lld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Game game = new Game();
        int sizeOfBoard = 10;
        Board board = new Board(sizeOfBoard);
        Scanner scanner = new Scanner(System.in);
        System.out.println("No of snakes:");
        int sn = scanner.nextInt();
        System.out.println("Add "+ sn +" snakes to the board- Enter head followed by tail");
        for(int i=0;i<sn;i++){
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            Snake s = new Snake(head, tail);
            board.addSnake(s);
        }
        System.out.println("No of ladders:");
        int sl = scanner.nextInt();
        System.out.println("Add "+ sl +" ladders to the board- Enter base followed by top");
        for(int i=0;i<sl;i++){
            int base = scanner.nextInt();
            int top = scanner.nextInt();
            Ladder l = new Ladder(base, top);
            board.addLadder(l);
        }
        System.out.println("Add 2 players");
        String name;
        List<Player> playerList = new ArrayList<Player>();
        for(int i=0;i<2;i++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                name = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Player p =new Player(name);
            p.setId(i+1);
            playerList.add(p);
        }
        game.setPlayers(playerList);
        game.setBoard(board);
        Dice d = new Dice(6);
        List<Dice> diceList =  new ArrayList<Dice>();
        diceList.add(d);
        game.setDices(diceList);
        Dice gameDice = game.getDices().get(0);
        game.start();
        while(game.getState()==GameState.STARTED){
            Player turnPlayer = game.currentTurn();
            game.move(turnPlayer,turnPlayer.rollDice(gameDice));
        }
        System.out.println("Game ended: Player "+game.getWinner().getName()+" WINS!!!");
    }
}
package logic;

import model.Board;
import model.creature.Creature;
import model.creature.Enemy;
import model.creature.Player;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Engine {

    private Board startBoard;
    private Set<Creature> entitySet;

    private boolean isRunning = true;

    public Engine(){

        this.entitySet = new HashSet<>();

        Player player_01 = new Player(100, 77, 50);
        player_01.setxPosition(Util.getRandomIntFromRange(1,10));
        player_01.setyPosition(Util.getRandomIntFromRange(1,10));

        entitySet.add(player_01);

        startBoard = new Board(Util.getStartBoardX(), Util.getStartBoardY(), entitySet);
        startBoard.placeCreature(player_01);

    }

    Scanner scanner = new Scanner(System.in);

    public void runGame(Set<Creature> entitySet, Board startBoard) {

        Creature player =  entitySet.stream().findFirst().get();

        while (isRunning){
            System.out.println(player.getxPosition() +" - "+ player.getyPosition() );


            String input = scanner.nextLine();
            char command = input.charAt(0);

            if (command == 'q') isRunning = false;

            if (command == 'p') System.out.println("this is printed text");
////////////
            if (command == 'w'){
                player.setyPosition(player.getyPosition()-1);
                startBoard.placeCreature(player);
            }
            if (command == 's'){
                player.setyPosition(player.getyPosition()+1);
                startBoard.placeCreature(player);
            }

            if (command == 'a'){
                player.setxPosition(player.getxPosition()-1);
                startBoard.placeCreature(player);
            }
            if (command == 'd'){
                player.setxPosition(player.getxPosition()+1);
                startBoard.placeCreature(player);
            }

            startBoard.printBoard();
        }
    }

    private int inputChecker(String input) {
        return input.length();
    }
//////////////////
    public Set<Creature> getEntitySet() {
        return entitySet;
    }

    public Board getStartBoard() {
        return startBoard;
    }
}

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
        Enemy enemy_01 = new Enemy(10, 5, 50);
        entitySet.add(enemy_01);
        entitySet.add(player_01);

        startBoard = new Board(Util.getStartBoardX(), Util.getGetStartBoardY(), entitySet);

    }

    Scanner scanner = new Scanner(System.in);

    public void runGame() {

        while (isRunning){
            System.out.println("the game is running still");

            String input = scanner.nextLine();
            char command = input.charAt(0);

            if (command == 'q') isRunning = false;

            if (command == 'p') System.out.println("this is printed text");

        }
    }

    private int inputChecker(String input) {
        return input.length();
    }

}

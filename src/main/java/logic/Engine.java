package logic;

import model.Board;
import model.Status;
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

    public Engine() {

        this.entitySet = new HashSet<>();

        Player player_01 = new Player(Status.PLAYER, 100, 77, 50);
        player_01.setxPosition(Util.getRandomIntFromRange(1, 10));
        player_01.setyPosition(Util.getRandomIntFromRange(1, 10));

        Enemy enemy_01 = new Enemy(Status.ENEMY, 50, 33, 25);
        enemy_01.setxPosition(Util.getRandomIntFromRange(1, 10));
        enemy_01.setyPosition(Util.getRandomIntFromRange(1, 10));

        entitySet.add(player_01);
        entitySet.add(enemy_01);

        startBoard = new Board(Util.getStartBoardX(), Util.getStartBoardY(), entitySet);
        startBoard.placeCreature(player_01);
        startBoard.placeCreature(enemy_01);

    }

    public void runGame(Set<Creature> entitySet, Board startBoard) {

        Scanner scanner = new Scanner(System.in);

        Creature player = entitySet.stream()
                .filter(creature -> creature.getCreatureStatus() == Status.PLAYER)
                .findAny()
                .orElse(null);

        while (isRunning) {
            System.out.println(player.getxPosition() + "x" + " - " + player.getyPosition() + "y");

            String input = scanner.nextLine();
            char command = input.charAt(0);

            switch (command) {

                case 'q':
                    isRunning = false;

                case 'p':
                    System.out.println("this is printed text");

                case 'd':
                    startBoard.removeCreature(player);
                    player.setyPosition(player.getyPosition() + 1);
                    startBoard.placeCreature(player);
                    startBoard.printBoard();
                    break;

                case 'a':
                    startBoard.removeCreature(player);
                    player.setyPosition(player.getyPosition() - 1);
                    startBoard.placeCreature(player);
                    startBoard.printBoard();
                    break;

                case 'w':
                    startBoard.removeCreature(player);
                    player.setxPosition(player.getxPosition() - 1);
                    startBoard.placeCreature(player);
                    startBoard.printBoard();
                    break;

                case 's':
                    startBoard.removeCreature(player);
                    player.setxPosition(player.getxPosition() + 1);
                    startBoard.placeCreature(player);
                    startBoard.printBoard();
                    break;

            }
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

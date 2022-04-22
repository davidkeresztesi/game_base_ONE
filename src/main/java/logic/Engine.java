package logic;

import model.Board;
import model.Status;
import model.creature.Creature;
import model.creature.Enemy;
import model.creature.Player;
import ui.Util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Engine {

    private Board runBoard;
    private Set<Creature> entitySet;

    private Player player;

    private boolean isRunning = true;

    public Engine(Board board, Set<Creature> creatureSet) {
        this.runBoard = board;
        this.entitySet = creatureSet;
    }

    static public Set<Creature> createEntitySet() {
        HashSet<Creature> entitySet = new HashSet<>();

        Player player_01 = new Player(Status.PLAYER, 100, 77, 50);
        player_01.setxPosition(Util.getRandomIntFromRange(1, 10));
        player_01.setyPosition(Util.getRandomIntFromRange(1, 10));

        Enemy enemy_01 = new Enemy(Status.ENEMY, 50, 33, 25);
        enemy_01.setxPosition(Util.getRandomIntFromRange(1, 10));
        enemy_01.setyPosition(Util.getRandomIntFromRange(1, 10));

        entitySet.add(player_01);
        entitySet.add(enemy_01);

        return entitySet;
    }

    public void runGame(Set<Creature> entitySet, Board startBoard) {
        Scanner scanner = new Scanner(System.in);

        runBoard.putSetOnBoard(this.entitySet);

        Creature player = entitySet.stream()
                .filter(creature -> creature.getCreatureStatus() == Status.PLAYER)
                .findAny()
                .orElse(null);

        while (isRunning) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Step counter:" + startBoard.getStepCounter());
            this.runBoard.printBoard();
            String input = scanner.nextLine();
            char command = input.charAt(0);
            switch (command) {
                case 'q':
                    isRunning = false;

                case 'p':
                    System.out.println(this.runBoard.getxSize());
                    System.out.println(this.runBoard.getySize());
                    break;

                case 'w':
                    if (this.runBoard.isNextMoveEmpty(player, 'w')) {
                        this.runBoard.removeCreature(player);
                        player.setxPosition(player.getxPosition() - 1);
                        this.runBoard.addStepCount();
                        this.runBoard.placeCreature(player);
                    } else System.out.println("move blocked");
                    break;

                case 's':
                    if (this.runBoard.isNextMoveEmpty(player, 's')) {
                        this.runBoard.removeCreature(player);
                        player.setxPosition(player.getxPosition() + 1);
                        this.runBoard.addStepCount();
                        this.runBoard.placeCreature(player);
                    } else System.out.println("move blocked");
                    break;

                case 'a':
                    if (this.runBoard.isNextMoveEmpty(player, 'a')) {
                        this.runBoard.removeCreature(player);
                        player.setyPosition(player.getyPosition() - 1);
                        this.runBoard.addStepCount();
                        this.runBoard.placeCreature(player);
                    } else System.out.println("move blocked");
                    break;

                case 'd':
                    if (this.runBoard.isNextMoveEmpty(player, 'd')) {
                        this.runBoard.removeCreature(player);
                        player.setyPosition(player.getyPosition() + 1);
                        this.runBoard.addStepCount();
                        this.runBoard.placeCreature(player);
                    } else System.out.println("move blocked");
                    break;
            }
        }
    }

    /////////////////////////////GET-SET

    public Set<Creature> getEntitySet() {
        return entitySet;
    }

    public Board getStartBoard() {
        return runBoard;
    }

}

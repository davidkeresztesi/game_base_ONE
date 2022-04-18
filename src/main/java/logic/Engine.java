package logic;

import model.Board;
import model.Status;
import model.creature.Creature;
import model.creature.Enemy;
import model.creature.Player;
import ui.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Engine {

    public static final String DATA_PATH = "src/main/resources/maps/";
    public static final String TXT = ".txt";

    private Board startBoard;
    private Set<Creature> entitySet;

    private boolean isRunning = true;

    public Engine() throws IOException {
        this.entitySet = createEntitySet();
        this.startBoard = createBoardFromList(mapReader("first_level"), entitySet);
        putSetOnBoard(startBoard, entitySet);
    }

    public Board createBoardFromList(List<String> scanList, Set<Creature> creatureSet) {
        Board board = new Board(scanList.get(0).length(), scanList.size(), creatureSet);
        board.createScanBoard(scanList);
        return board;
    }

    public void putSetOnBoard(Board board, Set<Creature> creatureSet) {
        board.placeCreature(creatureSet.stream().filter(e -> e.getCreatureStatus() == Status.PLAYER).findFirst().get());
        board.placeCreature(creatureSet.stream().filter(e -> e.getCreatureStatus() == Status.ENEMY).findFirst().get());
    }

    public Set<Creature> createEntitySet() {
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

    public void runGame(Set<Creature> entitySet, Board startBoard) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Creature player = entitySet.stream()
                .filter(creature -> creature.getCreatureStatus() == Status.PLAYER)
                .findAny()
                .orElse(null);

        while (isRunning) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Step counter:" + startBoard.getStepCounter());
            startBoard.printBoard();
            String input = scanner.nextLine();
            char command = input.charAt(0);
            switch (command) {
                case 'q':
                    isRunning = false;

                case 'w':
                    if (startBoard.isNextMoveEmpty(player, 'w')) {
                        startBoard.removeCreature(player);
                        player.setyPosition(player.getyPosition() + 1);
                        startBoard.addStepCount();
                        startBoard.placeCreature(player);
                    } else System.out.println("you can not move through walls pls");
                    break;

                case 's':
                    if (startBoard.isNextMoveEmpty(player, 's')) {
                        startBoard.removeCreature(player);
                        player.setyPosition(player.getyPosition() -1);
                        startBoard.addStepCount();
                        startBoard.placeCreature(player);
                    } else System.out.println("you can not move through walls pls");
                    break;

                case 'a':
                    if (startBoard.isNextMoveEmpty(player, 'a')) {
                        startBoard.removeCreature(player);
                        player.setxPosition(player.getxPosition() - 1);
                        startBoard.addStepCount();
                        startBoard.placeCreature(player);
                    } else System.out.println("you can not move through walls pls");
                    break;

                case 'd':
                    if (startBoard.isNextMoveEmpty(player, 'd')) {
                        startBoard.removeCreature(player);
                        player.setxPosition(player.getxPosition() + 1);
                        startBoard.addStepCount();
                        startBoard.placeCreature(player);
                    } else System.out.println("you can not move through walls pls");
                    break;
            }
        }
    }

    private List<String> mapReader(String fileName) throws IOException {
        String inPath = DATA_PATH + fileName + TXT;
        List<String> textHolderList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inPath));
            String line;
            while ((line = reader.readLine()) != null) {
                textHolderList.add(line);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return textHolderList;
    }

    private int inputChecker(String input) {
        return input.length();
    }

    public Set<Creature> getEntitySet() {
        return entitySet;
    }

    public Board getStartBoard() {
        return startBoard;
    }

}

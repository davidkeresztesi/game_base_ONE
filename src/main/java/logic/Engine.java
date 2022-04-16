package logic;

import model.Board;
import model.Status;
import model.Tile;
import model.creature.Creature;
import model.creature.Enemy;
import model.creature.Player;

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

    public Engine() {

        this.entitySet = createEntitySet();

//        Player player_01 = new Player(Status.PLAYER, 100, 77, 50);
//        player_01.setxPosition(Util.getRandomIntFromRange(1, 10));
//        player_01.setyPosition(Util.getRandomIntFromRange(1, 10));
//
//        Enemy enemy_01 = new Enemy(Status.ENEMY, 50, 33, 25);
//        enemy_01.setxPosition(Util.getRandomIntFromRange(1, 10));
//        enemy_01.setyPosition(Util.getRandomIntFromRange(1, 10));
//
//        entitySet.add(player_01);
//        entitySet.add(enemy_01);

        startBoard = new Board(Util.getStartBoardX(), Util.getStartBoardY(), entitySet);


//        startBoard.placeCreature(player_01);
//        startBoard.placeCreature(enemy_01);

    }

    public HashSet<Creature> createEntitySet(){
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

            //coordinate test
            //system.out.println(player.getxPosition() + "x" + " - " + player.getyPosition() + "y");

            System.out.println("Step counter:" + startBoard.getStepCounter());

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

                    startBoard.addStepCount();

                    startBoard.placeCreature(player);
                    startBoard.printBoard();
                    break;

                case 'a':
                    startBoard.removeCreature(player);
                    player.setyPosition(player.getyPosition() - 1);

                    startBoard.addStepCount();

                    startBoard.placeCreature(player);
                    startBoard.printBoard();
                    break;

                case 'w':
                    startBoard.removeCreature(player);
                    player.setxPosition(player.getxPosition() - 1);

                    startBoard.addStepCount();

                    startBoard.placeCreature(player);
                    startBoard.printBoard();
                    break;

                case 's':
                    startBoard.removeCreature(player);
                    player.setxPosition(player.getxPosition() + 1);

                    startBoard.addStepCount();

                    startBoard.placeCreature(player);
                    startBoard.printBoard();
                    break;

                case 'r':
                    List<String> listedLevel = mapReader("first_level");

                    Board scannedBoardTileMatrix = new Board(boardFromScan(listedLevel), createEntitySet());

                    scannedBoardTileMatrix.printBoard();

                case 't':
                    List<String> scanTRIAL = mapReader("first_level");
                    for (String line : scanTRIAL) {
                        System.out.println(line);
                    }

            }
        }
    }

    public Tile[][] boardFromScan(List<String> listedLevel) {
        int xScanDimension = listedLevel.get(0).length();
        int yScanDimension = listedLevel.size();
        Tile[][] scannedBoardTileMatrix = new Tile[xScanDimension][yScanDimension];
        for (int i = 0; i < listedLevel.size(); i++) {
            //char[] lineCharArray = listedLevel.get(i).toCharArray();

            for (int j = 0; j < listedLevel.get(i).length(); i++) {
                if (listedLevel.get(i).charAt(j) == 'w') scannedBoardTileMatrix[i][j] = new Tile(i, j, Status.WALL);
                if (listedLevel.get(i).charAt(j) == '-') scannedBoardTileMatrix[i][j] = new Tile(i, j, Status.EMPTY);
            }
        }
        return scannedBoardTileMatrix;
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

    //////////////////
    public Set<Creature> getEntitySet() {
        return entitySet;
    }

    public Board getStartBoard() {
        return startBoard;
    }
}

package model;

import model.creature.Creature;
import ui.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Board {

    private int xSize;
    private int ySize;
    private Tile[][] boardTileMatrix;

    private int stepCounter;

    private Set<Creature> entitySet;

    public Board(String filename, Set<Creature> entitySet) {
        List<String> currentRead = mapReader(filename);

        this.ySize = currentRead.size();
        this.xSize = currentRead.get(0).length();
        this.boardTileMatrix = new Tile[ySize][xSize];
        this.entitySet = entitySet;
        this.stepCounter = 0;

        createTiles();
        fillTilesFromList(currentRead);
    }

    /////////////////////////////MAP

    static private List<String> mapReader(String fileName) {
        String inPath = Util.DATA_PATH + fileName + Util.TXT;
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

    public void createTiles() {
        for (int y = 0; y < this.ySize; y++) {
            for (int x = 0; x < this.xSize; x++) {
                boardTileMatrix[y][x] = new Tile(y, x, Status.EMPTY);
            }
        }
    }

    public void fillTilesFromList(List<String> scanList) {
        for (int y = 0; y < scanList.size(); y++) {
            for (int x = 0; x < scanList.get(0).length(); x++) {
                if (scanList.get(y).charAt(x) == '-') {
                    this.boardTileMatrix[y][x].setTileStatus(Status.EMPTY);
                }
                if (scanList.get(y).charAt(x) == 'w') {
                    this.boardTileMatrix[y][x].setTileStatus(Status.WALL);
                }
            }
        }
    }

    public void printBoard() {
        for (Tile[] tileMatrix : boardTileMatrix) {
            for (Tile matrix : tileMatrix) {
                System.out.print(matrix.getTileStatus().getDisplayChar());
            }
            System.out.println();
        }
    }

    public void putSetOnBoard(Set<Creature> creatureSet) {
        this.placeCreature(creatureSet.stream()
                .filter(e -> e.getCreatureStatus() == Status.PLAYER)
                .findFirst().get());
        this.placeCreature(creatureSet.stream()
                .filter(e -> e.getCreatureStatus() == Status.ENEMY)
                .findFirst().get());
    }

    /////////////////////////////MOVE

    public void placeCreature(Creature creature) {
        for (int y = 0; y < boardTileMatrix.length; y++) {
            for (int x = 0; x < boardTileMatrix[y].length; x++) {
                if (y == creature.getxPosition()
                        && x == creature.getyPosition()
                        && boardTileMatrix[y][x].getTileStatus() == Status.EMPTY) {
                    boardTileMatrix[y][x].setTileStatus(creature.getCreatureStatus());
                }
            }
        }
    }

    public void removeCreature(Creature creature) {
        for (int y = 0; y < boardTileMatrix.length; y++) {
            for (int x = 0; x < boardTileMatrix[y].length; x++) {
                if (y == creature.getxPosition() && x == creature.getyPosition()) {
                    boardTileMatrix[y][x].setTileStatus(Status.EMPTY);
                }
            }
        }
    }

    public boolean isNextTileEmpty(Creature creature, char move) {
        boolean isEmpty = false;
        int xPosCurrent = creature.getxPosition();
        int yPosCurrent = creature.getyPosition();

        switch (move) {
            case 'w':
                if (this.boardTileMatrix[xPosCurrent-1][yPosCurrent]
                        .getTileStatus() == Status.EMPTY) isEmpty = true;
                if (this.boardTileMatrix[xPosCurrent-1][yPosCurrent]
                        .getTileStatus() == Status.ENEMY) System.out.println("well done!");
                break;

            case 's':
                if (this.boardTileMatrix[xPosCurrent+1][yPosCurrent]
                        .getTileStatus() == Status.EMPTY) isEmpty = true;
                if (this.boardTileMatrix[xPosCurrent+1][yPosCurrent]
                        .getTileStatus() == Status.ENEMY) System.out.println("well done!");
                break;

            case 'a':
                if (this.boardTileMatrix[xPosCurrent][yPosCurrent-1]
                        .getTileStatus() == Status.EMPTY) isEmpty = true;
                if (this.boardTileMatrix[xPosCurrent][yPosCurrent-1]
                        .getTileStatus() == Status.ENEMY) System.out.println("well done!");
                break;

            case 'd':
                if (this.boardTileMatrix[xPosCurrent][yPosCurrent+1]
                        .getTileStatus() == Status.EMPTY) isEmpty = true;
                if (this.boardTileMatrix[xPosCurrent][yPosCurrent+1]
                        .getTileStatus() == Status.ENEMY) System.out.println("well done!");
                break;
        }
        return isEmpty;
    }


    public void addStepCount() {
        stepCounter++;
    }

    /////////////////////////////GET-SET

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public int getStepCounter() {
        return stepCounter;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }

    public void setStepCounter(int stepCounter) {
        this.stepCounter = stepCounter;
    }

}

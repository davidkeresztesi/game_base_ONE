package model;

import logic.Engine;
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

    public Board(String filename, Set<Creature> entitySet){
        List<String> currentRead = mapReader(filename);

        this.ySize = currentRead.size();
        this.xSize = currentRead.get(0).length();
        this.boardTileMatrix = new Tile[ySize][xSize];
        this.entitySet = entitySet;
        this.stepCounter = 0;

        createTiles();
        fillTilesFromList(currentRead);

        for (Creature creature : entitySet) placeCreature(creature);
    }

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
        for (int y = 0; y < boardTileMatrix.length; y++) {
            for (int x = 0; x < boardTileMatrix[y].length; x++) {
                System.out.print(boardTileMatrix[y][x].getTileStatus().getDisplayChar());
            }
            System.out.println();
        }
    }

    public void placeCreature(Creature creature) {
        for (int y = 0; y < boardTileMatrix.length; y++) {
            for (int x = 0; x < boardTileMatrix[y].length; x++) {
                if (y == creature.getxPosition() && x == creature.getyPosition()
                        && boardTileMatrix[y][x].getTileStatus() != Status.WALL) {
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

    public boolean isNextMoveEmpty(Creature creature, char move) {
        boolean nextTileIsEmpty = false;
        switch (move) {
            case 'w':
                if(this.boardTileMatrix[creature.getxPosition()][creature.getyPosition()+1].getTileStatus()
                        == Status.EMPTY) nextTileIsEmpty = true;
            case 's':
                if(this.boardTileMatrix[creature.getxPosition()][creature.getyPosition()-1].getTileStatus()
                        == Status.EMPTY) nextTileIsEmpty = true;
            case 'a':
                if(this.boardTileMatrix[creature.getxPosition()-1][creature.getyPosition()].getTileStatus()
                        == Status.EMPTY) nextTileIsEmpty = true;
            case 'd':
                if(this.boardTileMatrix[creature.getxPosition()+1][creature.getyPosition()].getTileStatus()
                        == Status.EMPTY) nextTileIsEmpty = true;
        }
        return nextTileIsEmpty;
    }

    public void addStepCount() {
        stepCounter++;
    }

    ////////////////////////get-set

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

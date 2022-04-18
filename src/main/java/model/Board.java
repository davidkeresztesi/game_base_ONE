package model;

import model.creature.Creature;

import java.util.List;
import java.util.Set;

public class Board {

    private int xSize;
    private int ySize;
    private Tile[][] boardTileMatrix;

    private int stepCounter;

    private Set<Creature> entitySet;

    public Board(int xSize, int ySize, Set<Creature> entitySet) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.boardTileMatrix = new Tile[xSize][ySize];
        this.entitySet = entitySet;
        this.stepCounter = 0;

        createBoard();

        for (Creature creature : entitySet) placeCreature(creature);

        printBoard();

    }

    public void createScanBoard(List<String> scanList) {
        for (int i = 0; i < scanList.get(0).length(); i++) {
            for (int j = 0; j < scanList.size(); j++) {
                if (scanList.get(j).charAt(i) == '-') {
                    this.boardTileMatrix[i][j].setTileStatus(Status.EMPTY);
                }
                if (scanList.get(j).charAt(i) == 'w') {
                    this.boardTileMatrix[i][j].setTileStatus(Status.WALL);
                }
            }
        }

    }

    public void addStepCount() {
        stepCounter++;
    }

    public void createBoard() {
        for (int i = 0; i < boardTileMatrix.length; i++) {
            for (int j = 0; j < boardTileMatrix[i].length; j++) {
                boardTileMatrix[i][j] = new Tile(i, j, Status.EMPTY);
            }
        }
    }

    public void placeCreature(Creature creature) {
        for (int i = 0; i < boardTileMatrix.length; i++) {
            for (int j = 0; j < boardTileMatrix[i].length; j++) {
                if (i == creature.getxPosition() && j == creature.getyPosition()
                        && boardTileMatrix[i][j].getTileStatus() != Status.WALL) {
                    boardTileMatrix[i][j].setTileStatus(creature.getCreatureStatus());
                }
            }
        }
    }

    public boolean isNextMoveEmpty(Creature creature, char move) {
        boolean nextTileIsEmpty = true;
        switch (move) {
            case 'w':
                if(this.boardTileMatrix[creature.getxPosition()][creature.getyPosition()+1].getTileStatus()
                        == Status.WALL) nextTileIsEmpty = false;
            case 's':
                if(this.boardTileMatrix[creature.getxPosition()][creature.getyPosition()-1].getTileStatus()
                        == Status.WALL) nextTileIsEmpty = false;
            case 'a':
                if(this.boardTileMatrix[creature.getxPosition()-1][creature.getyPosition()].getTileStatus()
                        == Status.WALL) nextTileIsEmpty = false;
            case 'd':
                if(this.boardTileMatrix[creature.getxPosition()+1][creature.getyPosition()].getTileStatus()
                        == Status.WALL) nextTileIsEmpty = false;
        }
        return nextTileIsEmpty;
    }

    public void removeCreature(Creature creature) {
        for (int i = 0; i < boardTileMatrix.length; i++) {
            for (int j = 0; j < boardTileMatrix[i].length; j++) {
                if (i == creature.getxPosition() && j == creature.getyPosition()) {
                    boardTileMatrix[i][j].setTileStatus(Status.EMPTY);
                }
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < boardTileMatrix.length; i++) {
            for (int j = 0; j < boardTileMatrix[i].length; j++) {
                System.out.print(boardTileMatrix[i][j].getTileStatus().getDisplayChar());
            }
            System.out.println();
        }
    }

    public Tile getTileWithCoordinate(int xCoordinate, int yCoordinate) {
        return boardTileMatrix[xCoordinate][yCoordinate];
    }

    public Tile[][] getBoardTileMatrix() {
        return boardTileMatrix;
    }

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

package model;

import logic.Util;
import model.creature.Creature;

import java.util.Random;
import java.util.Set;

public class Board {

    private int xSize;
    private int ySize;
    private Tile[][] boardTileMatrix;

    private Set<Creature> entitySet;

    public Board(int xSize, int ySize, Set<Creature> entitySet) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.boardTileMatrix = new Tile[xSize][ySize];
        this.entitySet = entitySet;

        createBoard();

        for (Creature creature : entitySet) placeCreature(creature);

        printBoard();

    }

    public void createBoard() {
        for (int i = 0; i < boardTileMatrix.length; i++) {
            for (int j = 0; j < boardTileMatrix[i].length; j++) {
                boardTileMatrix[i][j] = new Tile(i,j, Status.EMPTY);
            }
        }
    }

    public void placeCreature(Creature creature) {

        for (int i = 0; i < boardTileMatrix.length; i++) {
            for (int j = 0; j < boardTileMatrix[i].length; j++) {
                if (i == creature.getxPosition() && j == creature.getyPosition()){
                    boardTileMatrix[i][j].setTileStatus(Status.FULL);
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

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }

}

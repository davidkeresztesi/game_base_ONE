package Model;

import Model.Creature.Creature;

import java.util.HashSet;
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
    }

    public void createBoard() {
        for (int i = 0; i < boardTileMatrix.length; i++) {
            for (int j = 0; j < boardTileMatrix[i].length; j++) {
                boardTileMatrix[i][j] = new Tile(i,j, Status.EMPTY);
            }
        }
    }

    public void placeElements() {
        Random random = new Random();
        for (Creature e : entitySet) {
            e.setxPosition(random.nextInt(xSize));
            e.setyPosition(random.nextInt(ySize));
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

package World;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

public class Board {

    private int xSize;
    private int ySize;
    private Set<Tile> boardTileSet;

    private Set<Entity> entitySet;

    public Board(int xSize, int ySize, Set<Entity> entitySet) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.boardTileSet = new HashSet<>();
        this.entitySet = entitySet;
    }

    public void generateTileSet() {
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                boardTileSet.add(new Tile(xSize, ySize, Status.EMPTY));
            }
        }
    }

    public void placeElements() {
        Random random = new Random();
        for (Entity e : entitySet) {
            e.setxPosition(random.nextInt(xSize));
            e.setyPosition(random.nextInt(ySize));
        }
    }

    public void printBoard() {
        for (Tile t: boardTileSet) {
            int currentX = t.getxCoordinate();
            int currentY = t.getxCoordinate();
            System.out.println("["+currentX+"]"+"["+currentY+"]"+Status.EMPTY.getDisplayChar());
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

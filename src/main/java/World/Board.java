package World;

import java.util.Set;

public class Board {

    private int xSize;
    private int ySize;

    Set<Entity> entitySet;

    public Board(int xSize, int ySize, Set<Entity> entitySet) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.entitySet = entitySet;
    }

    public void placeElements() {
        for (Entity e : entitySet){
            e.setxPosition(2);
            e.setyPosition(4);
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

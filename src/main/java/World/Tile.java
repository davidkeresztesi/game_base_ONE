package World;

public class Tile {

    private int xCoordinate;
    private int yCoordinate;

    Status tileStatus;

    public Tile(int xCoordinate, int yCoordinate, Status tileStatus) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.tileStatus = tileStatus;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public Status getTileStatus() {
        return tileStatus;
    }

    public void setTileStatus(Status tileStatus) {
        this.tileStatus = tileStatus;
    }

}

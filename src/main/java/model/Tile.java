package model;

public class Tile {

    private int xCoordinate;
    private int yCoordinate;

    Status tileStatus;

    public Tile(int yCoordinate, int xCoordinate, Status tileStatus) {
        this.yCoordinate = yCoordinate;
        this.xCoordinate = xCoordinate;
        this.tileStatus = tileStatus;
    }

    /////////////////////////////GET-SET

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

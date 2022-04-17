package model;

public enum Status {

EMPTY('-'), FULL('F'), PLAYER('p'), ENEMY('e'), WALL('w'), UNKNOWN('?');

    final char displayChar;

    Status(char displayChar) {
        this.displayChar = displayChar;
    }

    public char getDisplayChar() {
        return displayChar;
    }

}

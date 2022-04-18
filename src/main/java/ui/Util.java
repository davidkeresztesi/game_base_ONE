package ui;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    private static int numOfPlayers = 1;
    private static int numOfEnemyAI = 0;

    private static int goalCoins = 10;
    private static int startCoin = 4;

    private static int startBoardX = 10;
    private static int startBoardY = 10;

    public static int getRandomIntFromRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int getStartBoardX() {
        return startBoardX;
    }

    public static int getStartBoardY() {
        return startBoardY;
    }
}

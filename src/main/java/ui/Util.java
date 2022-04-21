package ui;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static final String DATA_PATH = "src/main/resources/maps/";
    public static final String TXT = ".txt";

    public static int getRandomIntFromRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

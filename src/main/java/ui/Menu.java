package ui;

import logic.Engine;
import logic.Util;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Util util = new Util();

    public void mainMenu() throws IOException {

        System.out.println("pick an option please:");
        System.out.println("1 - new game");
        System.out.println("2 - high scores");
        System.out.println("3 - options");
        System.out.println("4 - quit game");

        int input = scanner.nextInt();

        switch (input){
            case 1:
                System.out.println("Loading game");
                startGame();
                break;

            case 2:
                System.out.println("to be implemented1");
                break;
                //highscore.txt read and display

            case 3:
                System.out.println("to be implemented2");
                break;
                //options menu to modify Util

            case 4:
                System.out.println("bye");
                System.exit(0);
        }
    }

    private void startGame() throws IOException {
        Engine engine = new Engine();
        engine.runGame(engine.getEntitySet(), engine.getStartBoard());
    }

}

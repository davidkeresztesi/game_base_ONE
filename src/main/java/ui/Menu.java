package ui;

import logic.Engine;
import model.Board;
import model.creature.Creature;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void mainMenu() throws IOException {

        System.out.println("pick an option please:");
        System.out.println("1 - new game");
        System.out.println("2 - high scores");
        System.out.println("3 - options");
        System.out.println("4 - quit game");

        int input = scanner.nextInt();

        switch (input) {
            case 1 -> startGame();
            case 2 -> System.out.println("to be implemented1");
            case 3 -> System.out.println("to be implemented2");
            case 4 -> System.exit(0);
        }
    }

    private void startGame() throws IOException {
        Board firstBoard = new Board("first_level", Engine.createEntitySet());
        Set<Creature> creatureSet = Engine.createEntitySet();
        Engine engine = new Engine(firstBoard, creatureSet);

        engine.runGame(engine.getEntitySet(), engine.getStartBoard());
    }

}

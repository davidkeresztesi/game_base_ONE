package ui;

import logic.Engine;
import logic.Util;
import model.Board;
import model.creature.Creature;
import model.creature.Enemy;
import model.creature.Player;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Util util = new Util();

    public void mainMenu(){

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

    private void startGame(){
        Engine engine = new Engine();
        engine.runGame();
    }
}

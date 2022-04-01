import Logic.Util;
import Model.Board;
import Model.Creature.Enemy;
import Model.Creature.Creature;
import Model.Creature.Player;

import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args){

        Util settings = new Util();

        Set<Creature> entitySet = new HashSet<>();

        Player player_01 = new Player(100, 77, 50);
        entitySet.add(player_01);
        Enemy enemy_01 = new Enemy(10, 5, 50);
        entitySet.add(enemy_01);


        Board startBoard = new Board( settings.getStartBoardX(), settings.getGetStartBoardY(), entitySet);

        startBoard.createBoard();
        startBoard.placeElements();
        startBoard.printBoard();

    }
}

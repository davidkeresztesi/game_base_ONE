import World.Board;
import World.Enemy;
import World.Entity;
import World.Player;

import java.util.HashSet;
import java.util.Set;

public class Run {
    public static void main(String[] args){

        Set<Entity> entitySet = new HashSet<>();

        Player player_01 = new Player(100, 77, 50);
        entitySet.add(player_01);
        Enemy enemy_01 = new Enemy(10, 5, 50);
        entitySet.add(enemy_01);


        Board startBoard = new Board(25, 25, entitySet);






        startBoard.placeElements();



    }
}

package levels;

import Game.Game;
import Character.Enemy1;
public class Levels implements levelInterface{
    Game gp;
    public Levels(Game gp){
        this.gp = gp;
    }

    public void testLevel(){
        gp.asteroids.clear();

        Enemy1 enemy1 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{768, 300}, 2);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{gp.screenWidth, 520} ,new int[]{300, 400}, new int[]{0, 360}, 1);
        gp.asteroids.add(enemy2);
        Enemy1 enemy3 = new Enemy1(gp, new int[]{gp.screenWidth, 520} ,new int[]{300, 400}, new int[]{500, 100}, 3);
        gp.asteroids.add(enemy3);
    }

    @Override
    public void levelOne() {
        gp.asteroids.clear();

        Enemy1 enemy1 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{768, 300}, 2);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{gp.screenWidth, 520} ,new int[]{300, 400}, new int[]{0, 360}, 1);
        gp.asteroids.add(enemy2);
        Enemy1 enemy3 = new Enemy1(gp, new int[]{gp.screenWidth, 520} ,new int[]{300, 400}, new int[]{500, 100}, 1);
        gp.asteroids.add(enemy3);
        Enemy1 enemy4 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{600, 300}, 2);
        gp.asteroids.add(enemy4);
        Enemy1 enemy5 = new Enemy1(gp, new int[]{gp.screenWidth, 520} ,new int[]{300, 400}, new int[]{10, 250}, 1);
        gp.asteroids.add(enemy5);
        Enemy1 enemy6 = new Enemy1(gp, new int[]{gp.screenWidth, 520} ,new int[]{300, 400}, new int[]{400, 300}, 4);
        gp.asteroids.add(enemy6);
    }
    //Create these levels later by, Sunday night.
    @Override
    public void levelTwo() {

    }

    @Override
    public void levelThree() {

    }

    @Override
    public void levelFour() {

    }

    @Override

}

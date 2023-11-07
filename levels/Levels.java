package levels;

import GUI.GamePanel;
import Character.Enemy1;
public class Levels {
    GamePanel gp;
    public Levels(GamePanel gp){
        this.gp = gp;
    }

    public void testLevel(){
        gp.asteroids.clear();

        Enemy1 enemy1 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{768, 300}, 2);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{gp.screenWidth, 520} ,new int[]{300, 400}, new int[]{0, 360}, 1);
        gp.asteroids.add(enemy2);
    }
}

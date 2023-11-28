package levels;

import Game.Game;
import Character.Enemy1;
public class Levels implements levelInterface{
    Game gp;
    int len = Game.screenWidth;
    int height = Game.screenHeight;
    public double level;
    public Levels(Game gp){
        this.gp = gp;
        setLvl();
    }

    @Override
    public void levelOne() {
        setWave(1.1);
        gp.asteroids.clear();
        Enemy1 enemy1 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{len, 300}, 1,1);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{gp.screenWidth, 520} ,new int[]{300, 400}, new int[]{0, 360}, 1,1);
        gp.asteroids.add(enemy2);
        Enemy1 enemy3 = new Enemy1(gp, new int[]{gp.screenWidth, 300} ,new int[]{300, 400}, new int[]{500, 100}, 1,1);
        gp.asteroids.add(enemy3);
        Enemy1 enemy4 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{600, 300}, 2,1);
        gp.asteroids.add(enemy4);
        Enemy1 enemy5 = new Enemy1(gp, new int[]{gp.screenWidth, 100} ,new int[]{300, 400}, new int[]{10, 250}, 1,1);
        gp.asteroids.add(enemy5);
        Enemy1 enemy6 = new Enemy1(gp, new int[]{gp.screenWidth, 520} ,new int[]{300, 400}, new int[]{400, 300}, 2,1);
        gp.asteroids.add(enemy6);

    }


    public void levelOneWave2(){
        Enemy1 enemy1 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{len, 300}, 1,1);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{len, 200} ,new int[]{300, 100}, new int[]{0, 360}, 1,1);
        gp.asteroids.add(enemy2);
        Enemy1 enemy3 = new Enemy1(gp, new int[]{len, 520} ,new int[]{300, 400}, new int[]{0, 100}, 2,1);
        gp.asteroids.add(enemy3);
        Enemy1 enemy4 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{len, 300}, 2,1);
        gp.asteroids.add(enemy4);
        Enemy1 enemy5 = new Enemy1(gp, new int[]{len, 100} ,new int[]{300, 400}, new int[]{0, 250}, 2,1);
        gp.asteroids.add(enemy5);
        Enemy1 enemy6 = new Enemy1(gp, new int[]{len, 600} ,new int[]{300, 400}, new int[]{0, 300}, 2,1);
        gp.asteroids.add(enemy6);
        setWave(0);
    }
    //Create these levels later by, Sunday night.
    @Override
    public void levelTwo() {
        setWave(2.1);
        gp.asteroids.clear();

        Enemy1 enemy1 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{768, 300}, 2,2);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{len, 200} ,new int[]{300, 400}, new int[]{0, 360}, 2,2);
        gp.asteroids.add(enemy2);
        Enemy1 enemy3 = new Enemy1(gp, new int[]{len, 520} ,new int[]{300, 500}, new int[]{500, 100}, 3,2);
        gp.asteroids.add(enemy3);
        Enemy1 enemy4 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 100}, new int[]{600, 300}, 2,2);
        gp.asteroids.add(enemy4);
        Enemy1 enemy5 = new Enemy1(gp, new int[]{len, 320} ,new int[]{300, 0}, new int[]{10, 250}, 2,2);
        gp.asteroids.add(enemy5);
        Enemy1 enemy6 = new Enemy1(gp, new int[]{len, 0} ,new int[]{300, 200}, new int[]{400, 300}, 3,2);
        gp.asteroids.add(enemy6);

    }

    public void levelTwoWave2(){
        Enemy1 enemy1 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{len, 300}, 2,2);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{len, 200} ,new int[]{300, 100}, new int[]{0, 360}, 2,2);
        gp.asteroids.add(enemy2);
        Enemy1 enemy3 = new Enemy1(gp, new int[]{len, 520} ,new int[]{300, 400}, new int[]{0, 100}, 3,2);
        gp.asteroids.add(enemy3);
        Enemy1 enemy4 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{len, 300}, 2,2);
        gp.asteroids.add(enemy4);
        Enemy1 enemy5 = new Enemy1(gp, new int[]{len, 100} ,new int[]{300, 400}, new int[]{0, 250}, 2,2);
        gp.asteroids.add(enemy5);
        Enemy1 enemy6 = new Enemy1(gp, new int[]{len, 600} ,new int[]{300, 400}, new int[]{0, 300}, 2,2);
        gp.asteroids.add(enemy6);
        Enemy1 enemy7 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{768, 300}, 2,2);
        gp.asteroids.add(enemy7);
        Enemy1 enemy8 = new Enemy1(gp, new int[]{len, 200} ,new int[]{300, 400}, new int[]{0, 360}, 2,2);
        gp.asteroids.add(enemy8);
        Enemy1 enemy9 = new Enemy1(gp, new int[]{len, 520} ,new int[]{300, 500}, new int[]{500, 100}, 3,2);
        gp.asteroids.add(enemy9);
        setWave(0);
    }

    @Override
    public void levelThree() {
        setWave(3.1);
        gp.asteroids.clear();

        Enemy1 enemy1 = new Enemy1(gp, new int[]{0, 0} ,new int[]{len/2, 0}, new int[]{len, 0}, 3,3);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{len, 200} ,new int[]{len/2, 200}, new int[]{0, 200}, 2,3);
        gp.asteroids.add(enemy2);
        Enemy1 enemy3 = new Enemy1(gp, new int[]{0, 400} ,new int[]{len/2, 400}, new int[]{len, 400}, 2,3);
        gp.asteroids.add(enemy3);
        Enemy1 enemy4 = new Enemy1(gp, new int[]{len, height-100} ,new int[]{len/2, height-100}, new int[]{0, height-100}, 3,3);
        gp.asteroids.add(enemy4);
        Enemy1 enemy5 = new Enemy1(gp, new int[]{len, 520} ,new int[]{len/2, 400}, new int[]{0, 250}, 3,3);
        gp.asteroids.add(enemy5);
        Enemy1 enemy6 = new Enemy1(gp, new int[]{0, 520} ,new int[]{300, height/2}, new int[]{len, 300}, 3,3);
        gp.asteroids.add(enemy6);
        Enemy1 enemy7 = new Enemy1(gp, new int[]{len, 520} ,new int[]{len/2, 400}, new int[]{0, 250}, 3,3);
        gp.asteroids.add(enemy7);
        Enemy1 enemy8 = new Enemy1(gp, new int[]{0, 520} ,new int[]{len/2, 300}, new int[]{len, 300}, 3,3);
        gp.asteroids.add(enemy8);
    }

    public void levelThreeWave2(){
        Enemy1 enemy1 = new Enemy1(gp, new int[]{len, 0} ,new int[]{len/2, 0}, new int[]{0, 0}, 4,3);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{0, 200} ,new int[]{len/2, 200}, new int[]{len, 200}, 3,3);
        gp.asteroids.add(enemy2);
        Enemy1 enemy3 = new Enemy1(gp, new int[]{len, 400} ,new int[]{len/2, 400}, new int[]{0, 400}, 3,3);
        gp.asteroids.add(enemy3);
        Enemy1 enemy4 = new Enemy1(gp, new int[]{0, height-100} ,new int[]{len/2, height-100}, new int[]{len, height-100}, 4,3);
        gp.asteroids.add(enemy4);
        Enemy1 enemy5 = new Enemy1(gp, new int[]{0, 520} ,new int[]{len/2, 400}, new int[]{len, 250}, 3,3);
        gp.asteroids.add(enemy5);
        Enemy1 enemy6 = new Enemy1(gp, new int[]{0, 520} ,new int[]{300, height/2}, new int[]{len, 300}, 3,3);
        gp.asteroids.add(enemy6);
        Enemy1 enemy7 = new Enemy1(gp, new int[]{len, 520} ,new int[]{len/2, 400}, new int[]{0, 250}, 3,3);
        gp.asteroids.add(enemy7);
        Enemy1 enemy8 = new Enemy1(gp, new int[]{0, 520} ,new int[]{len/2, 300}, new int[]{len, 300}, 3,3);
        gp.asteroids.add(enemy8);
        setWave(3.2);
    }
    public void levelThreeWave3(){
        Enemy1 enemy1 = new Enemy1(gp, new int[]{0, 0} ,new int[]{len/2, 0}, new int[]{len, 0}, 3,3);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{len, 200} ,new int[]{len/2, 200}, new int[]{0, 200}, 2,3);
        gp.asteroids.add(enemy2);
        Enemy1 enemy3 = new Enemy1(gp, new int[]{0, 400} ,new int[]{len/2, 400}, new int[]{len, 400}, 2,3);
        gp.asteroids.add(enemy3);
        Enemy1 enemy4 = new Enemy1(gp, new int[]{len, height-100} ,new int[]{len/2, height-100}, new int[]{0, height-100}, 3,3);
        gp.asteroids.add(enemy4);
        Enemy1 enemy5 = new Enemy1(gp, new int[]{len, 520} ,new int[]{len/2, 400}, new int[]{0, 250}, 3,3);
        gp.asteroids.add(enemy5);
        Enemy1 enemy6 = new Enemy1(gp, new int[]{0, 520} ,new int[]{300, height/2}, new int[]{len, 300}, 3,3);
        gp.asteroids.add(enemy6);
        Enemy1 enemy7 = new Enemy1(gp, new int[]{len, 520} ,new int[]{len/2, 400}, new int[]{0, 250}, 3,3);
        gp.asteroids.add(enemy7);
        Enemy1 enemy8 = new Enemy1(gp, new int[]{0, 520} ,new int[]{len/3, 300}, new int[]{len, 300}, 3,3);
        gp.asteroids.add(enemy8);
        Enemy1 enemy9 = new Enemy1(gp, new int[]{len, 0} ,new int[]{len/2, 0}, new int[]{0, 0}, 3,3);
        gp.asteroids.add(enemy9);
        Enemy1 enemy10 = new Enemy1(gp, new int[]{0, 200} ,new int[]{len/2, 400}, new int[]{len, 200}, 3,3);
        gp.asteroids.add(enemy10);
        Enemy1 enemy11 = new Enemy1(gp, new int[]{len, 400} ,new int[]{len/2, 300}, new int[]{0, 400}, 3,3);
        gp.asteroids.add(enemy11);
        Enemy1 enemy12 = new Enemy1(gp, new int[]{0, height-100} ,new int[]{len/2, 400}, new int[]{len, height-100}, 3,3);
        gp.asteroids.add(enemy12);
        setWave(0);
    }
    @Override
    public void levelFour() {
        setWave(4.1);
        gp.asteroids.clear();
        Enemy1 enemy;
        for (int i = 0; i <= Game.tileSize*11; i += Game.tileSize * 1.5){
            enemy = new Enemy1(gp, new int[]{0, i} ,new int[]{len/2, i}, new int[]{len, i}, 2,4);
            gp.asteroids.add(enemy);
        }
        Enemy1 enemy1 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{len, 300}, 3,4);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{len, 200} ,new int[]{300, 100}, new int[]{0, 360}, 3,4);
        gp.asteroids.add(enemy2);
        Enemy1 enemy3 = new Enemy1(gp, new int[]{len, 520} ,new int[]{300, 400}, new int[]{0, 100}, 3,4);
        gp.asteroids.add(enemy3);
        Enemy1 enemy4 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{len, 300}, 3,4);
        gp.asteroids.add(enemy4);
        Enemy1 enemy5 = new Enemy1(gp, new int[]{len, 100} ,new int[]{300, 400}, new int[]{0, 250}, 3,4);
        gp.asteroids.add(enemy5);
        Enemy1 enemy6 = new Enemy1(gp, new int[]{len, 600} ,new int[]{300, 400}, new int[]{0, 300}, 3,4);
        gp.asteroids.add(enemy6);
        Enemy1 enemy7 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{768, 300}, 3,4);
        gp.asteroids.add(enemy7);
        Enemy1 enemy8 = new Enemy1(gp, new int[]{len, 200} ,new int[]{300, 400}, new int[]{0, 360}, 3,4);
        gp.asteroids.add(enemy8);
        Enemy1 enemy9 = new Enemy1(gp, new int[]{len, 520} ,new int[]{300, 500}, new int[]{500, 100}, 3,4);
        gp.asteroids.add(enemy9);
    }

    public void levelFourWave2(){
        Enemy1 enemy;
        for (int i = 0; i <= Game.tileSize*11; i += Game.tileSize * 1.5){
            enemy = new Enemy1(gp, new int[]{len, i} ,new int[]{len/2, i}, new int[]{0, i}, 2,4);
            gp.asteroids.add(enemy);
        }
        Enemy1 enemy1 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{len, 300}, 3,4);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{len, 200} ,new int[]{300, 100}, new int[]{0, 360}, 3,4);
        gp.asteroids.add(enemy2);
        Enemy1 enemy3 = new Enemy1(gp, new int[]{len, 520} ,new int[]{300, 400}, new int[]{0, 100}, 3,4);
        gp.asteroids.add(enemy3);
        Enemy1 enemy4 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{len, 300}, 3,4);
        gp.asteroids.add(enemy4);
        Enemy1 enemy5 = new Enemy1(gp, new int[]{0, 100} ,new int[]{300, 400}, new int[]{len, 250}, 3,4);
        gp.asteroids.add(enemy5);
        Enemy1 enemy6 = new Enemy1(gp, new int[]{0, 600} ,new int[]{300, 400}, new int[]{len, 300}, 3,4);
        gp.asteroids.add(enemy6);
        Enemy1 enemy7 = new Enemy1(gp, new int[]{0, 400} ,new int[]{300, 200}, new int[]{768, 300}, 3,4);
        gp.asteroids.add(enemy7);
        Enemy1 enemy8 = new Enemy1(gp, new int[]{len, 200} ,new int[]{300, 400}, new int[]{0, 360}, 3,4);
        gp.asteroids.add(enemy8);
        Enemy1 enemy9 = new Enemy1(gp, new int[]{len, 520} ,new int[]{300, 500}, new int[]{500, 100}, 3,4);
        gp.asteroids.add(enemy9);
        setWave(4.2);
    }
    public void levelFourWave3(){
        Enemy1 enemy;
        for (int i = 0; i <= Game.tileSize*11; i += Game.tileSize * 1.5){
            enemy = new Enemy1(gp, new int[]{len, i} ,new int[]{len/2, i}, new int[]{0, i}, 2,4);
            gp.asteroids.add(enemy);
            enemy = new Enemy1(gp, new int[]{0, i} ,new int[]{len/2, i}, new int[]{len, i}, 2,4);
            gp.asteroids.add(enemy);
        }

        Enemy1 enemy1 = new Enemy1(gp, new int[]{0, 400} ,new int[]{len/2, 200}, new int[]{len, 300}, 4,4);
        gp.asteroids.add(enemy1);
        Enemy1 enemy2 = new Enemy1(gp, new int[]{len, 200} ,new int[]{len/2, 400}, new int[]{0, 220}, 3,4);
        gp.asteroids.add(enemy2);
        Enemy1 enemy3 = new Enemy1(gp, new int[]{len, 520} ,new int[]{len/2, 400}, new int[]{0, 100}, 4,4);
        gp.asteroids.add(enemy3);
        Enemy1 enemy4 = new Enemy1(gp, new int[]{0, 400} ,new int[]{len/2, 200}, new int[]{len, 300}, 3,4);
        gp.asteroids.add(enemy4);
        Enemy1 enemy5 = new Enemy1(gp, new int[]{len, 100} ,new int[]{len/2, 400}, new int[]{0, 250}, 3,4);
        gp.asteroids.add(enemy5);
        Enemy1 enemy6 = new Enemy1(gp, new int[]{len, 600} ,new int[]{len/2, 400}, new int[]{0, 300}, 3,4);
        gp.asteroids.add(enemy6);
        Enemy1 enemy7 = new Enemy1(gp, new int[]{0, 400} ,new int[]{len/2, 200}, new int[]{768, 300}, 4,4);
        gp.asteroids.add(enemy7);
        Enemy1 enemy8 = new Enemy1(gp, new int[]{len, 200} ,new int[]{len/2, 400}, new int[]{0, 360}, 3,4);
        gp.asteroids.add(enemy8);
        Enemy1 enemy9 = new Enemy1(gp, new int[]{len, 520} ,new int[]{300, 500}, new int[]{500, 100}, 3,4);
        gp.asteroids.add(enemy9);

        enemy = new Enemy1(gp, new int[]{len, height+100} ,new int[]{len/2, height/2}, new int[]{150, 0}, 3,4);
        gp.asteroids.add(enemy);
        enemy = new Enemy1(gp, new int[]{200, height+100} ,new int[]{len/2, height/2}, new int[]{len, 0}, 3,4);
        gp.asteroids.add(enemy);
        enemy = new Enemy1(gp, new int[]{len, height+100} ,new int[]{400, height/2}, new int[]{0, 0}, 2,4);
        gp.asteroids.add(enemy);

        setWave(0);
    }

    public void setWave(double level){
        gp.level = level;
    }
    public void setLvl(){
        gp.lvl = this;
    }



}

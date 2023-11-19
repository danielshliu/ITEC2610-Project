package levels;

import Game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;



//The
public class LevelManager {
    private Game game;
    private BufferedImage levelBackGround;
    private Levels levelSelect;

    public LevelManager(Game game, String levelFileName, Levels levelSelect){
        this.game = game;
        levelBackGround = LoadSaves.getImage(levelFileName);
        this.levelSelect = levelSelect;



    }

    public void draw(Graphics g){
        //might have to change x, y on this part to get the background level
        g.drawImage(levelBackGround,0,0,null);


    }

    public void update(){

    }

    public Levels getLevel() {
        return levelSelect;
    }


}

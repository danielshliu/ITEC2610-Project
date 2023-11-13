package levels;

import Game.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;



//The
public class LevelManager {
    private GamePanel game;
    private BufferedImage levelBackGround;

    public LevelManager(GamePanel game,String levelFileName){
        this.game = game;
        levelBackGround = LoadLevel.getLevelBackground(levelFileName);



    }

    public void draw(Graphics g){
        //might have to change x, y on this part to get the background level
        g.drawImage(levelBackGround,0,0,null);
    }


}

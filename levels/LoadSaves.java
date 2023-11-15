package levels;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import javax.imageio.ImageIO;

import javax.swing.*;


//LoadLevel allows Levelmanager to get the levelbackground
//Gets the png file
public class LoadSaves {
    public static final String LevelOne = "levelOneBackground.png";
    public static final String LevelTwo = "levelTwoBackground.png";
    public static final String LevelThree = "levelThreeBackground.png";
    public static final String LevelFour = "levelFourBackground.png";
    public static final String LevelFive = "levelFiveBackground.png";
    public static final String MenuBackGround = "menuBackground.png";
    public static final String PLAYBUTTON = "playButton.png";
    public static final String OPTIONBUTTON = "optionsButton.png";
    public static final String TUTORIALBUTTON = "tutorialButton.png";
    public static final String QUITBUTTON = "quitButton.png";


    public static BufferedImage getLevelBackground(String fileName){
        BufferedImage img = null ;
        InputStream is = LoadSaves.class.getResourceAsStream("/img/" + fileName);
        try{
            img = ImageIO.read(is);
        }catch(IOException e){
            e.printStackTrace();
       }
        finally{

            try{
                is.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return img;
    }


}

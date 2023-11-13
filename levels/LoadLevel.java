package levels;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

//LoadLevel allows Levelmanager to get the levelbackground
//Gets the png file
public class LoadLevel {
    public static final String LevelOne = "levelOneBackground.png";
    public static final String LevelTwo = "levelTwoBackground.png";
    public static final String LevelThree = "levelThreeBackground.png";
    public static final String LevelFour = "levelFourBackground.png";
    public static final String LevelFive = "levelFiveBackground.png";

    public static BufferedImage getLevelBackground(String fileName){
        BufferedImage img = null;
        InputStream is = LoadLevel.class.getResourceAsStream("/" + fileName);
        try{
            img = ImageIO.read(is);
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                is.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return img;
    }


}

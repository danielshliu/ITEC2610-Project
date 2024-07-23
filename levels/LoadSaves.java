package Levels;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

//Gets the png file
public class LoadSaves {
    public static final String Enemy1 = "AsteroidLevel1.png";
    public static final String Enemy2 = "AsteroidLevel2.png";
    public static final String Enemy3 = "AsteroidLevel3.png";
    public static final String Enemy4 = "AsteroidLevel4.png";
    public static final String Ship = "Ship1.png";

    //Ships that we didn't have time to implement to each levels
    public static final String Ship2 = "Ship2.png";
    public static final String Ship3 = "Ship3.png";
    public static final String Ship4 = "Ship4.png";
    public static BufferedImage getImage(String fileName){
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

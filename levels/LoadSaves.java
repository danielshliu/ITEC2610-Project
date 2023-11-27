package levels;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;


//LoadLevel allows Levelmanager to get the levelbackground
//Gets the png file
public class LoadSaves {
    public static final String MenuBackGround = "menuBackground.png";
    public static final String MenuButton = "menuButton.png";
    public static final String Enemy1 = "AsteroidLevel1.png";
    public static final String Enemy2 = "AsteroidLevel2.png";
    public static final String Enemy3 = "AsteroidLevel3.png";
    public static final String Enemy4 = "AsteroidLevel4.png";
    public static final String MainShip = "Ship.png";



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

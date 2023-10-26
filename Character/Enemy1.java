package Character;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;
import java.util.Objects;

import GUI.GamePanel;

public class Enemy1 extends Entity{
    int playersX;
    int playersY;
    int screenCenterX = gp.screenWidth / 2;
    int screenCenterY = gp.screenHeight / 2;

    public Enemy1(GamePanel gp){
        super(gp);
        defaultValues();
        getImage();
    }

    public void defaultValues(){
        x = 40;
        y = 100;
        speed = 4;
        direction = 0;

    }
    public void getImage(){
        try{
            im = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/img/Asteroid.png")));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g){
        g.setColor(Color.white);
        g.drawImage(im, x, y, gp.tileSize, gp.tileSize, null);
        g.drawLine(x, y, 0, 0);
    }

    public void update(){
        playersX = gp.character.x;
        playersY = gp.character.y;

        if (screenCenterX > x){
            x++;
        }
        if (screenCenterX < x){
            x--;
        }
        if (screenCenterY > y){
            y++;
        }
        if (screenCenterY < y){
            y--;
        }

    }
}

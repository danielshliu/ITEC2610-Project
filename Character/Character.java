package Character;
import GUI.*;
import GUI.MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class Character extends Entity {
    public ArrayList<Entity> bulletInChamber;
    private int hitPoint;
    GamePanel gp;
    KeyboardHandler keyH;
    MouseHandler mouseH;
    public Character(GamePanel gp, KeyboardHandler keyH, MouseHandler mouseH) {
        this.gp = gp;
        this.keyH = keyH;
        this.mouseH = mouseH;
        defaultValues();
        getImage();
    }
    public void defaultValues(){
        x = gp.screenWidth/2;
        y = gp.screenHeight/2;
        speed = 4;
    }

    public int getHitPoint(){
        return hitPoint;
    }

    
    public void setHitPoint(int newHitPoint){
        hitPoint = newHitPoint;

    }

    public void getImage(){
        try{
            im = ImageIO.read(getClass().getResourceAsStream("/img/Ship.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (keyH.up && y - speed >= 0) {
            y -= speed;
        }

        if (keyH.down && y + speed <= gp.screenHeight - gp.tileSize) {
            y += speed;
        }

        if (keyH.left && x - speed >= 0) {
            x -= speed;
        }
        if (keyH.right && x + speed <= gp.screenWidth - gp.tileSize) {
            x += speed;
        }

        if (mouseH.mouseClicked){
            System.out.println("X: " + mouseH.mouseLocation[0] + " Y: " + mouseH.mouseLocation[1]);
        }
    }

    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        //g2.rotate(Math.toRadians(45));
        g2.drawImage(im, x, y, gp.tileSize, gp.tileSize, null);

    }

    //
    //$ javac MyClass.java    //getters and setters
    
}

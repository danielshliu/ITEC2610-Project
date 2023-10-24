package Character;
import GUI.*;

import java.awt.*;
import java.util.ArrayList;


public class Character extends Entity {
    public ArrayList<Entity> bulletInChamber;
    private int hitPoint;
    GamePanel gp;
    KeyboardHandler keyH;
    public Character(GamePanel gp, KeyboardHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        defaultValues();
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
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }

    //
    //$ javac MyClass.java    //getters and setters
    
}

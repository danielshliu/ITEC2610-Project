package Character;
import GUI.*;
import GUI.MouseHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;
import java.util.Objects;
import java.awt.event.MouseEvent;


public class Character extends Entity {
    public ArrayList<Entity> bulletInChamber;
    private int hitPoint;
    GamePanel gp;
    KeyboardHandler keyH;
    MouseHandler mouseH;

    // Finding the angle
    int x1, y1, x2, y2, x3, y3;
    double slope13;
    double slope23;
    double directionNew;

    int count;

    double calc;
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
        direction = 0;
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



        g2.setColor(Color.white);

        if (mouseH.mouseClicked){
            x1 = x+(gp.tileSize/2);
            y1 = (y+(gp.tileSize/2)) - 100;

            x2 = mouseH.mouseLocation[0];
            y2 = mouseH.mouseLocation[1];

            x3 = x+(gp.tileSize/2);
            y3 = y+(gp.tileSize/2);

            slope23 = (float)(y3-y2)/(x3-x2);

            if (x3 != x1){
                slope13 = (float)(y3-y1)/(x3-x1);
                calc = Math.abs((slope23-slope13)/(1 + (slope23*slope13)));

                calc = Math.atan(calc);

                calc = calc * (180/ Math.PI);

            } else{
                // If the players looking direction is invalid slope is invalid
                slope13 = 0.0;
                calc = Math.abs((slope23-slope13)/(1 + (slope23*slope13)));
                calc = Math.atan(calc);
                calc = calc * (180/ Math.PI);
                calc = 90-calc;

                if (x2 > x3){
                    if (y2 > y3){
                        calc = (90 - calc) + 90;
                    }
                } else{
                    if (y2 > y3){
                        calc += 180;
                    } else{
                        calc = (90-calc) + 270;
                    }
                }
            }



            //System.out.println((calc + direction) % 360);

            g2.drawRect(mouseH.mouseLocation[0]-5, mouseH.mouseLocation[1]-5, 10, 10);
            g2.drawLine(mouseH.mouseLocation[0], mouseH.mouseLocation[1], x+(gp.tileSize/2), y+(gp.tileSize/2));
            //directionNew = ((calc + direction) % 360);

            direction = calc;

            if (direction > 360){
                direction = direction % 360;
            }
            g2.drawLine(x1, y1 , x2, y2);

        }

        System.out.println(Arrays.toString(mouseH.mouseLocation));

        g2.rotate(Math.toRadians(direction), x+(gp.tileSize/2) , y+(gp.tileSize/2));

        g2.drawImage(im, x, y, gp.tileSize, gp.tileSize, null);




        g2.drawLine(x+(gp.tileSize/2), (y+(gp.tileSize/2)) , x+(gp.tileSize/2), (y+(gp.tileSize/2)) - 100);

    }

    //
    //$ javac MyClass.java    //getters and setters
    
}

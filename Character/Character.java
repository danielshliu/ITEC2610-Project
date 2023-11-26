package Character;
import Game.*;

import gamestates.Playing;
import Game.MouseHandler;
import levels.LoadSaves;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Objects;


public class Character extends Entity {
    boolean hit = false;
    int hitx , hity;
    public ArrayList<Bullet> bulletInChamber = new ArrayList<>();
    Bullet curBullet;
    private int hitPoint = 3;

    Playing Input;
    KeyboardHandler keyH;
    MouseHandler mouseH;

    // Finding the angle
    int x1, y1, x2, y2, x3, y3;
    double slope13;
    double slope23;
    double b23 = 0;
    boolean shot = false;
    long shotTime;

    ArrayList<Rectangle> bulletHitboxes = new ArrayList<>();



    double calc;
    public Character(Game gp, Playing inputs){
        super(gp, gp.tileSize, gp.tileSize);
        this.Input = inputs;
        defaultValues();
        getImage();
    }

    public Character(Game gp, KeyboardHandler keyH, MouseHandler mouseH) {
        super(gp, gp.tileSize, gp.tileSize);
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
        im = LoadSaves.getImage(LoadSaves.MainShip);
    }

    public void update(){

        for (int i = 0; i < bulletInChamber.size(); i++){
            if (bulletInChamber.get(i).valid) {
                //System.out.println(bulletInChamber.get(i).getHitbox());
            }
        }

        //Change Input back to keyH if error
        if (Input.up && y - speed >= 0) {
            y -= speed;
        }

        //Change Input back to keyH if error
        if (Input.down && y + speed <= gp.screenHeight - gp.tileSize) {
            y += speed;
        }

        //Change Input back to keyH if error
        if (Input.left && x - speed >= 0) {
            x -= speed;
        }

        //Change Input back to keyH if error
        if (Input.right && x + speed <= gp.screenWidth - gp.tileSize) {
            x += speed;
        }

        for (int i = 0; i < bulletInChamber.size(); i++){
            if (bulletInChamber.get(i).valid){
                bulletInChamber.get(i).update();
            }

        }

        updateHitBox();
    }

    public void draw(Graphics2D g2){
        //drawHitbox(g2);
        if (hit){
            g2.drawLine(hitx, hity, x, y);
        }

        for (int i = 0; i < bulletInChamber.size(); i++){
            if (bulletInChamber.get(i).valid) {
                bulletInChamber.get(i).draw(g2);
            }
        }
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);


        g2.setColor(Color.white);
        //Change Input back to mouseH if error
        if (Input.mouseClicked){
            x1 = x+(gp.tileSize/2);
            y1 = (y+(gp.tileSize/2)) - 100;
            //Change Input back to mouseH if error
            x2 = Input.mouseLocation[0];
            y2 = Input.mouseLocation[1];

            x3 = x+(gp.tileSize/2);
            y3 = y+(gp.tileSize/2);

            slope23 = (float)(y3-y2)/(x3-x2);
            //System.out.println(Arrays.toString(new int[]{x2, y2, x3, y3}) + " SLOPE: " + slope23);
            b23 = ((slope23 * x2) - y2)*-1;
            //System.out.println(b23);

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
            //Change Input back to mouseH if error
            g2.drawRect(Input.mouseLocation[0]-5, Input.mouseLocation[1]-5, 10, 10);
            g2.drawLine(Input.mouseLocation[0], Input.mouseLocation[1], x+(gp.tileSize/2), y+(gp.tileSize/2));
            //directionNew = ((calc + direction) % 360);

            direction = calc;

            if (direction > 360){
                direction = direction % 360;
            }


            g2.drawLine(x1, y1 , x2, y2);

            shoot(direction, slope23, g2, b23);

        }

        //System.out.println(Arrays.toString(mouseH.mouseLocation));

        g2.rotate(Math.toRadians(direction), x+(gp.tileSize/2.0) , y+(gp.tileSize/2.0));


        g2.drawImage(im, x, y, gp.tileSize, gp.tileSize, null);


        g2.drawLine(x+(gp.tileSize/2), (y+(gp.tileSize/2)) , x+(gp.tileSize/2), (y+(gp.tileSize/2)) - 100);

    }

    public void shoot(double d, double slope, Graphics2D g, double b){
        if (!shot){
            shotTime = System.currentTimeMillis();
            shot = true;
            bulletInChamber.add(new Bullet(gp, x3, y3, d, slope, b));
            curBullet = bulletInChamber.get(bulletInChamber.size()-1);
        }
        else{
            if (System.currentTimeMillis() - shotTime > 300){
                shot = false;
            }
        }

    }

    public void gotHit(int[] xy){
        hit = true;
        hity = xy[1];
        hitx = xy[0];
        hitPoint --;
        if (hitPoint <= 0){
            System.out.println("DEAD GO TO MENU");
        }
    }

    //
    //d$ javac MyClass.java    //getters and setters
    
}

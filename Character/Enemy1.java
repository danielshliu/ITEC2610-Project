package Character;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Objects;


import Levels.LoadSaves;
import Game.Game;

// Asteroid
public class Enemy1 extends Entity{
    double yd;
    int speed;
    double a, b, c;
    boolean left = false, right = false;
    public boolean valid = true;
    long lastHit = System.currentTimeMillis();
    ArrayList<Integer> hitBy = new ArrayList<>();



    public Enemy1(Game gp, int[] startPoint , int[] midPoint, int[] endPoint, int speed,int level){
        super(gp, gp.tileSize, gp.tileSize);
        this.speed = speed;
        defaultValues(startPoint[0], startPoint[1]);
        calculations(startPoint, midPoint, endPoint);
        getImage(level);
    }

    public void defaultValues(int x, int sY){
        this.x = x;
        hitPoints = 3;

        yd = sY;

        if (x <= gp.screenWidth/2){
            left = true;
        } else{
            right = true;
        }
    }

    public void calculations(int[] startP, int[] midP, int[] endP){

        // Calculating the equation of a parabola with 3 points using Cramer's rule
        int[][] D = {{startP[0] * startP[0], startP[0], 1},
                     {midP[0] * midP[0], midP[0], 1},
                     {endP[0] * endP[0], endP[0], 1}};


        int[][] D1 = {{startP[1], startP[0], 1},
                     {midP[1], midP[0], 1},
                     {endP[1], endP[0], 1}};

        int[][] D2 = {{startP[0] * startP[0], startP[1], 1},
                {midP[0] * midP[0], midP[1], 1},
                {endP[0] * endP[0], endP[1], 1}};

        int[][] D3 = {{startP[0] * startP[0], startP[0], startP[1]},
                     {midP[0] * midP[0], midP[0], midP[1]},
                     {endP[0] * endP[0], endP[0], endP[1]}};

        //Are these all the coords for the asterids?
        int evalD = (D[0][0] * D[1][1] * D[2][2] + D[0][1] * D[1][2] * D[2][0] + D[0][2] * D[1][0] * D[2][1])-
                    (D[0][2] * D[1][1] * D[2][0] + D[0][0] * D[1][2] * D[2][1] + D[0][1] * D[1][0] * D[2][2]);

        int evalD1 = (D1[0][0] * D1[1][1] * D1[2][2] + D1[0][1] * D1[1][2] * D1[2][0] + D1[0][2] * D1[1][0] * D1[2][1])-
                    (D1[0][2] * D1[1][1] * D1[2][0] + D1[0][0] * D1[1][2] * D1[2][1] + D1[0][1] * D1[1][0] * D1[2][2]);
        
        int evalD2 = (D2[0][0] * D2[1][1] * D2[2][2] + D2[0][1] * D2[1][2] * D2[2][0] + D2[0][2] * D2[1][0] * D2[2][1])-
                    (D2[0][2] * D2[1][1] * D2[2][0] + D2[0][0] * D2[1][2] * D2[2][1] + D2[0][1] * D2[1][0] * D2[2][2]);



        int evalD3 = (D3[0][0] * D3[1][1] * D3[2][2] + D3[0][1] * D3[1][2] * D3[2][0] + D3[0][2] * D3[1][0] * D3[2][1])-
                (D3[0][2] * D3[1][1] * D3[2][0] + D3[0][0] * D3[1][2] * D3[2][1] + D3[0][1] * D3[1][0] * D3[2][2]);

        // System.out.println(evalD);
        // System.out.println(evalD1);
        // System.out.println(evalD2);
        // System.out.println(evalD3);
        // System.out.println("---");


        this.a = ((double)evalD1/(double)evalD);
        this.b = (double)evalD2/(double)evalD;
        this.c = startP[1] - (a * (startP[0] * startP[0])) - b * startP[0];
        //this.c = (double)evalD3/(double)evalD;

        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);
    }

    //getImage need to add Level to get the correct image for the entity
    public void getImage(int level){
        switch (level){
            case 1:
                im = LoadSaves.getImage(LoadSaves.Enemy1);
                break;
            case 2:
                im = LoadSaves.getImage(LoadSaves.Enemy2);
                break;
            case 3:
                im = LoadSaves.getImage(LoadSaves.Enemy3);
                break;
            case 4:
                im = LoadSaves.getImage(LoadSaves.Enemy4);
                break;

        }

    }
    public void draw(Graphics2D g){
        //drawHitbox(g);
        //g.drawLine(x, (int)yd, gp.tileSize/2, gp.tileSize/2);
        g.drawImage(im, x, (int)yd, gp.tileSize, gp.tileSize, null);
    }

    public void update(){
        updateHitBox();

        if(right){
            yd = (a * (Math.pow(x, 2))) + (b*x) + c;
            x-= speed;
        }

        else if (left){
            //count ++;
            yd = (a * (Math.pow(x, 2))) + (b*x) + c;
            x+= speed;
        }
        y = (int)yd;

        if (!gp.playScreen.contains(getHitbox())){
            valid = false;
        }

    }

    public void hit(int bullet){
        if (!hitBy.contains(bullet) || System.currentTimeMillis() - lastHit > 300) {
            hitBy.add(bullet);
            lastHit = System.currentTimeMillis();
            hitPoints--;
            if (hitPoints == 0) {
                valid = false;
            }
        }
    }
}

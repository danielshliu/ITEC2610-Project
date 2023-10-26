package Character;
import GUI.GamePanel;
import java.awt.geom.Rectangle2D;
import java.lang.Math;
import java.awt.*;
public class Bullet extends Entity{

    double slope;
    double b;
    int speed1, speed2;
    double yd;
    double xd;
    public boolean valid = true;



    public Bullet(GamePanel gp, int x, int y, double direction, double slope, double b) {
        super(gp);
        defaultStats(x, y, direction, slope, b);
    }

    public void defaultStats(int x, int y, double direction, double slope, double b){
        this.slope = slope;
        this.direction = direction;
        this.x = x;
        this.y = y;
        this.b = b;
        this.yd = y;
        this.xd = x;

    }

    public void draw(Graphics2D g){
        g.setColor(Color.green);
        g.fill(new Rectangle2D.Double(xd-5, yd-5, 10, 10));
    }

    public void update(){
        if (xd < gp.screenWidth && xd > 0 && yd < gp.screenHeight && yd > 0 && (!Double.isInfinite(slope))){
            if(direction < 180.00){
                if (slope > 20 || slope < -20){
                    if (slope < 0){
                        xd = ((yd-b) / slope);
                        yd-= Math.abs(slope/10);
                    } else{
                        xd = ((yd-b) / slope);
                        yd+= Math.abs(slope/10);
                    }
                }
                else if (slope > 2 || slope < -2){
                    if (direction < 90){
                        xd = ((yd-b) / slope);
                        yd-=5;
                    } else{
                    xd = ((yd-b) / slope);
                    yd+=5;
                }}

                else{
                    yd = xd * slope + b;
                    xd += 5;
                }

            } else if (direction > 180.00){
                if (slope > 20 || slope < -20){
                    if (slope < 0){
                        xd = ((yd-b) / slope);
                        yd+= Math.abs(slope/10);
                    }
                    else{
                        xd = ((yd-b) / slope);
                        yd-= Math.abs(slope/10);
                    }
                }
                else if (slope > 2 || slope < -2){
                    if (direction < 270){
                        xd = ((yd-b) / slope);
                        yd+=5;
                    } else{
                        xd = ((yd-b) / slope);
                        yd-=5;
                    }}else{
                yd = xd * slope + b;
                xd -= 5;}
            }

        } else{
            valid = false;
        }

    }

}


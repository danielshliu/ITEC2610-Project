package Character;
import GUI.GamePanel;

import java.awt.Image.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    protected int x;
    protected int y;
    protected int speed;
    protected double direction;

    public BufferedImage im;

    public Entity(GamePanel gp){
        this.gp = gp;
    }


}

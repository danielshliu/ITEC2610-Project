package Character;
import Game.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    protected int x;
    protected int y;
    protected int speed;
    protected double direction;

    public BufferedImage im;

    protected Rectangle hitbox;
    int hitPoints;

    public Entity(GamePanel gp, int w, int h){
        this.gp = gp;
        initHitBox(w, h);
    }

    public void drawHitbox(Graphics2D g){
        // for debug
        g.setColor(Color.red);
        g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }

    private void initHitBox(int w, int h) {
        hitbox = new Rectangle(x, y, w, h);
    }

    protected void updateHitBox(){
        hitbox.x = x;
        hitbox.y = y;
    }

    public Rectangle getHitbox(){
        return hitbox;
    }


}

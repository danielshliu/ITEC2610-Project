package Character;

import java.util.ArrayList;


public class Character extends Bullet {
    public ArrayList<Bullet> bulletInChamber;
    private int hitPoint;

    public Character(){

    }

    public int getHitPoint(){
        return hitPoint;
    }

    
    public void setHitPoint(int newHitPoint){
        hitPoint = newHitPoint;

    }

    //
    //getters and setters
    
}

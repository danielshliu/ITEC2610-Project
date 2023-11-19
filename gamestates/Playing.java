package gamestates;


import levels.LevelManager;
import Game.Game;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;

import java.awt.*;
import java.awt.event.*;

public class Playing extends  State implements Statemethods,MouseListener,MouseMotionListener, KeyListener {
    private LevelManager levelManager;

    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;

    public boolean mouseClicked = false;

    public int[] mouseLocation = new int[2];

    public Playing(Game game) {
        super (game);
    }

    //how to get menu into load into level.

    public void playLevelOne(){

    }

    public void playLevelTwo(){

    }
    public void playLevelThree(){

    }

    public void playLevelFour(){

    }

    public void playLevelFive(){

    }


    @Override
    public void update() {
        levelManager.update();
    }

    @Override
    public void draw(Graphics g) {
        levelManager.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseClicked = true;
        mouseLocation[0] = e.getX();
        mouseLocation[1] = e.getY();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseLocation[0] = e.getX();
        mouseLocation[1] = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseClicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
        }
    }
}

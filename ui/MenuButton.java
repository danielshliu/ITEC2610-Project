package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.concurrent.RecursiveAction;

import levels.LoadLevel;
import gamestates.Gamestate;


public class MenuButton {
    private int B_WIDTH = 140;
    private int B_HEIGHT = 56;
    private int xPos,yPos,rowIndex, index;
    private int xOffsetCenter = B_WIDTH/2;
    private Gamestate state;
    private BufferedImage[] imgs;
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;

    public MenuButton(int xPos, int yPos, int rowIndex, Gamestate state){
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        loadImgs();

    }

    private void initBounds(){

    }

    private void loadImgs(){
        imgs = new BufferedImage[3];


    }
    public 
}

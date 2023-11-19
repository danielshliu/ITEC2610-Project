package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Game.Game;
import levels.LoadSaves;
import gamestates.Gamestate;


public class MenuButton {
    private int B_WIDTH_DEFAULT = 140;
    private int B_HEIGHT_DEFAULT = 56;
    private int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.scale);
    private int B_HEIGHT = (int) (B_HEIGHT_DEFAULT *  Game.scale);

    private int xPos,yPos,rowIndex, index;
    private int xOffsetCenter = B_WIDTH_DEFAULT /2;
    private Gamestate state;
    private BufferedImage[] imgs;
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;
    //check
    public MenuButton(int xPos, int yPos, int rowIndex, Gamestate state){
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        loadImgs();
        initBounds();

    }
    private void initBounds(){
        bounds = new Rectangle(xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT);

    }

    private void loadImgs(){
        imgs = new BufferedImage[3];
        BufferedImage temp = LoadSaves.getImage(LoadSaves.MenuButton);
        for (int i = 0; i < imgs.length; i++)
            imgs[i] = temp.getSubimage(i * B_WIDTH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);

//        imgs[0] = LoadSaves.getLevelBackground(LoadSaves.PLAYBUTTON);
//        imgs[1] = LoadSaves.getLevelBackground(LoadSaves.TUTORIALBUTTON);
//        imgs[2] = LoadSaves.getLevelBackground(LoadSaves.OPTIONBUTTON);
//        imgs[3] = LoadSaves.getLevelBackground(LoadSaves.QUITBUTTON);

    }

    public void draw(Graphics g){
        g.drawImage(imgs[index],xPos-xOffsetCenter,yPos, B_WIDTH, B_HEIGHT,null);
    }


    public void update(){
        index = 0 ;
        if (mouseOver)
            index = 1;
        if (mousePressed)
            index = 2;
    }

    public boolean isMouseOver(){
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver){
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed(){
        return  mousePressed;
    }

    public void setMousePressed(boolean mousePressed){
        this.mousePressed = mousePressed;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void applyGameState(){
        Gamestate.state = state;
    }

    public void resetBools(){
        mouseOver = false;
        mousePressed = false;
    }

}

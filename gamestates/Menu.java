package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Game.GamePanel;
import ui.MenuButton;
import levels.LoadSaves;


public class Menu implements Statemethods{
    private MenuButton[] buttons = new MenuButton[4];
    private BufferedImage backgroundImg;
    private int menuX, menuY, menuWidth, menuHeight;


    public Menu(GamePanel game){
        game.startGameThread();


        //super(game);
        loadButtons();
        loadBackground();
    }


    public void loadButtons(){
        buttons[0] = new MenuButton(GamePanel.screenWidth/2 , (int)250 * GamePanel.scale,0,Gamestate.PLAYING);
        buttons[1] = new MenuButton(GamePanel.screenWidth/2 , (int)250 * GamePanel.scale, 1, Gamestate.OPTIONS);
        buttons[3] = new MenuButton(GamePanel.screenWidth/2 , (int)250 * GamePanel.scale,2,Gamestate.TUTORIAL);
        buttons[4] = new MenuButton(GamePanel.screenWidth/2 , (int)250 * GamePanel.scale, 3, Gamestate.QUIT);
    }

    public void loadBackground(){
        backgroundImg = LoadSaves.getLevelBackground(LoadSaves.MenuBackGround);

    }
    @Override
    public void update() {
        for (MenuButton mb : buttons)
            mb.update();

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImg,menuX,menuY,menuWidth,menuHeight,null);

        for(MenuButton mb: buttons)
            mb.draw(g);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Game.Game;
import ui.MenuButton;
import levels.LoadSaves;



public class Menu extends State implements Statemethods{
    private MenuButton[] buttons = new MenuButton[3];
    private BufferedImage backgroundImg;
    private int menuX, menuY, menuWidth, menuHeight;


    public Menu(Game game){
        super(game);
        loadButtons();
        loadBackground();
    }


    public void loadButtons(){
        //0 To Level Selection
        //1 to Options
        //2 to Tutorial
        //3 to quit
        buttons[0] = new MenuButton(Game.screenWidth/2 , (int)(250 * Game.scale),0,Gamestate.PLAYING);
        buttons[1] = new MenuButton(Game.screenWidth/2 , (int)(250 * Game.scale), 1, Gamestate.OPTIONS);
        buttons[2] = new MenuButton(Game.screenWidth/2 , (int)(250 * Game.scale),2,Gamestate.QUIT);
        //buttons[3] = new MenuButton(Game.screenWidth/2 , (int)250 * Game.scale, 3, Gamestate.QUIT);
    }

    public void loadBackground(){
        this.backgroundImg = LoadSaves.getImage(LoadSaves.MenuBackGround);
        menuWidth = (int) (backgroundImg.getWidth() * game.scale);
        menuHeight = (int) (backgroundImg.getHeight() * game.scale);
        menuX = game.screenWidth / 2 - menuWidth/2;
        menuY = (int) (45 * game.scale);
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
        for(MenuButton mb: buttons){
            mb.setMouseOver(false);
        }

        for(MenuButton mb: buttons){

            if (isIn(e,mb)){
                mb.setMouseOver(true);
                break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(MenuButton mb : buttons){
            if(isIn(e,mb)){
                mb.setMousePressed(true);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(MenuButton mb: buttons){
            if(isIn(e,mb)){
                if(mb.isMousePressed()){
                    mb.applyGameState();
                }
                break;
            }
        }
    }

    private void resetButton(){
        for(MenuButton mb: buttons){
            mb.resetBools();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            Gamestate.state = Gamestate.PLAYING;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}

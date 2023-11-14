package gamestates;


import Game.GamePanel;
import ui.MenuButton;

import java.awt.event.MouseEvent;

public class State {
    protected GamePanel game;


    public State(GamePanel game){
        this.game = game;
    }
    //fiqure out why Menu is not taking in IsIn().

    public boolean isIn(MouseEvent e, MenuButton mb){
        return mb.getBounds().contains(e.getX(),e.getY());
    }

    public GamePanel getGame(){
        return game;
    }


}

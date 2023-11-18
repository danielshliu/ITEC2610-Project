package gamestates;


import Game.Game;
import ui.MenuButton;

import java.awt.event.MouseEvent;

public class State {
    protected Game game;


    public State(Game game){
        this.game = game;
    }
    //fiqure out why Menu is not taking in IsIn().

    public boolean isIn(MouseEvent e, MenuButton mb){
        return mb.getBounds().contains(e.getX(),e.getY());
    }

    public Game getGame(){
        return game;
    }


}

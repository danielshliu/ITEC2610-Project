package gamestates;


import Game.GamePanel;

public class State {
    private GamePanel game;


    public State(GamePanel game){
        this.game = game;
    }

    public GamePanel getGame(){
        return game;
    }
}

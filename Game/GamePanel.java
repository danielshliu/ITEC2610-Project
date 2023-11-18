package Game;


import java.awt.*;
import javax.swing.JPanel;

import static Game.Game.screenWidth;
import static Game.Game.screenHeight;
import gamestates.Playing;


public class GamePanel extends JPanel{
    private MouseHandler mouseInputs;
    private Game game;
    Playing inputs;



    public GamePanel(Game game){
        this.game = game;

        inputs = new Playing(game);
        mouseInputs = new MouseHandler();
        setPanelSize(game);
        game.setBackground(Color.black);
        game.setDoubleBuffered(true);
        game.addKeyListener(inputs);
        game.addMouseListener(inputs);
        game.addMouseMotionListener(inputs);
        game.setFocusable(true);

    }

    private void setPanelSize(Game game) {
        Dimension size = new Dimension(screenWidth,screenHeight);
        game.setPreferredSize(size);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        game.render(g);
    }

    public Game getGame(){
        return game;
    }
}

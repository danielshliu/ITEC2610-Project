package Game;


import java.awt.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import MenuInputs.MouseInputs;
import MenuInputs.KeyboardInput;

import static Game.Game.screenWidth;
import static Game.Game.screenHeight;


public class GamePanel extends JPanel{
    private MouseInputs mouseInputs;
    private Game game;



    public GamePanel(Game game){
        this.game = game;
        mouseInputs = new MouseInputs(this);

        //setBackground(Color.black);

        setPanelSize();
        setDoubleBuffered(true);
        addKeyListener(new KeyboardInput(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        setFocusable(true);

    }

    private void setPanelSize() {
        Dimension size = new Dimension(screenWidth,screenHeight);
        setPreferredSize(size);
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

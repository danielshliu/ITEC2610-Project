package Game;

import javax.swing.*;

public class MainFrame{
    private JFrame jFrame;

    public MainFrame(GamePanel gamePanel){
        jFrame = new JFrame();

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setTitle("Asteriod Invaders");

        jFrame.add(gamePanel);

    }

}
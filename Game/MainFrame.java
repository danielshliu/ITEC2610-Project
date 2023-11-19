package Game;

import javax.swing.*;



public class MainFrame{
    private JFrame jFrame;

    public MainFrame(GamePanel gamePanel){
        jFrame = new JFrame();

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setResizable(false);
        jFrame.setTitle("Asteriod Invaders");
        jFrame.setLocationRelativeTo(null);


        jFrame.pack();
        jFrame.setVisible(true);
    }

}
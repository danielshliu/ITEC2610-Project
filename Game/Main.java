package Game;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Asteroid Invaders");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);


        gamePanel.startGameThread();


        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //This starts the game

    }

}

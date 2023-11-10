package GUI;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        JButton start = new JButton("Start");
        JButton options = new JButton("Options");
        JButton tutorial = new JButton("Tutorial");
        JButton exit = new JButton("Exit");


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Asteroid Invaders");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);


        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //This starts the game.

        //gamePanel.startGameThread();

    }
    private void startMenu(){

    }
    private void optionsMenu(){

    }
    private void tutorial(){

    }
}

package Game;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame{
    //Initiallizing the buttions and cardlayout for when clicking
    JFrame frame;
    JLabel title;
    JPanel mainMenuPanel, getStartMenuPanel, getTutorialPanel, getOptionsPanel, main;
    JButton startMenuButton, tutorialMenuButton, optionsMenuButton, exitButton , exitGame;
    JSlider volumeSlider;
    JTextArea Temp,tutorialText;
    CardLayout Card;



    public MainFrame(){
            frame = new JFrame("Astroids Invaders");
            title = new JLabel("Welcome Astroids Invaders");
            Card = new CardLayout();

            startMenuButton = new JButton("Start Menu");
            tutorialMenuButton = new JButton("Tutorial");
            optionsMenuButton = new JButton("Options");
            exitButton = new JButton("Main Menu");
            exitGame = new JButton("Exit");

            mainMenuPanel = new JPanel();
            mainMenuPanel.add(title);
            mainMenuPanel.add(startMenuButton,"1");
            mainMenuPanel.add(tutorialMenuButton,"2");
            mainMenuPanel.add(optionsMenuButton,"3");
            mainMenuPanel.add(exitGame,"4");

            getStartMenuPanel = new JPanel();
            Temp = new JTextArea("Temp...");
            getStartMenuPanel.add(Temp);
            getStartMenuPanel.add(exitButton);

            getTutorialPanel = new JPanel();
            String tutorial  = """
                   This is where the tutorial is...
                    """;
            tutorialText = new JTextArea(tutorial);
            getTutorialPanel.add(tutorialText);
            getTutorialPanel.add(exitButton);

            getOptionsPanel = new JPanel();
            volumeSlider = new JSlider(0,100,50);
            getOptionsPanel.add(volumeSlider);
            getOptionsPanel.add(exitButton);

            main = new JPanel(new CardLayout());
            main.add(mainMenuPanel);



        //The main menu Card
//        mainMenuPanel.setLayout(card);
//        startMenuButton.setVerticalTextPosition(AbstractButton.TOP);
//        startMenuButton.setHorizontalTextPosition(AbstractButton.LEFT);
//
//        mainMenuPanel.add(startMenuButton);
//        tutorialMenuButton.setVerticalTextPosition(AbstractButton.CENTER);
//        tutorialMenuButton.setHorizontalTextPosition(AbstractButton.CENTER);
//        mainMenuPanel.add(tutorialMenuButton);
//
//        optionsMenuButton.setVerticalTextPosition(AbstractButton.TOP);
//        optionsMenuButton.setHorizontalTextPosition(AbstractButton.RIGHT);
//        mainMenuPanel.add(optionsMenuButton);
//
//        //startMenu Card
//        startMenuPanel.add(exitButton);
//        startMenuPanel.add(Temp);
//
//        //Tutorial Card
//        tutorialPanel.add(exitButton);
//
//        //Option Card
//        optionsPanel.add(volumeSlider);
//        optionsPanel.add(exitButton);
//
//        mainMenuPanel.add(startMenuPanel,"1");
//        mainMenuPanel.add(tutorialPanel,"2");
//        mainMenuPanel.add(optionsPanel,"3");
//
//        card.show(mainMenuPanel,"0");

        startMenuButton.addActionListener(e -> {
            System.out.println("Start");
            Card.show(mainMenuPanel,"1");
        });

        tutorialMenuButton.addActionListener(e -> {
            System.out.println("Tutorial Work");
            Card.show(mainMenuPanel,"2");
        });

        optionsMenuButton.addActionListener(e -> {
            System.out.println("Option Work");
            Card.show(mainMenuPanel,"3");
        });

        exitButton.addActionListener(e -> {
            System.out.println("Exit Work");
            Card.show(mainMenuPanel,"4");
        });

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setTitle("Astroids Invaders");
        frame.add(main);
        //frame.add(startMenuButton);
        //frame.add(tutorialMenuButton);
        //frame.add(optionsMenuButton);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400,400);
        //frame.pack();
        frame.setVisible(true);

    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());

    }

}
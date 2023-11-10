package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainFrame implements ItemListener {
    JPanel Cards;
    final static String startButton = "Start Menu!";
    final static String optionMenu = "Options!";
    final static String tutorialMenu = "Tutorial!";

    public void addComponentToCard(Container card){
        JPanel tutorialCard  = new JPanel();
        tutorialCard.add(new JTextArea("This is a Tutorial"));

        JPanel startMenu = new JPanel();


        JPanel options = new JPanel();
        options.add(new JSlider(0,100,50));

    }

    public void itemStateChanged(ItemEvent event){
        CardLayout cardlayout = (CardLayout)(Cards.getLayout());
        cardlayout.show(Cards, (String)event.getItem());

    }

    private static void generateAndShowGUI(){
        JFrame frame = new JFrame("Testing out stuff");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainFrame main = new MainFrame();
        main.addComponentToCard(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

    }


}
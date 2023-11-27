package Game;


import javax.swing.*;

import static Game.Game.screenWidth;
import static Game.Game.screenHeight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;

import levels.Levels;



public class MainFrame{
    private JFrame jFrame;
    static CardLayout cl;
    static JPanel deck;


    public static class Testing extends JFrame {
        private Levels levelSelect;
        //private JPanel levelOnePanel,levelTwoPanel,levelThreePanel,levelFourPanel;
        private JButton levelSelectionButton,TutorialButton,Exit;
        private JButton LevelOne,LevelTwo,LevelThree,LevelFour,Back;

        public Testing(){
            super("Asteriod Invaders");
            Container container = getContentPane();
            deck = new JPanel();
            cl = new CardLayout();
            deck.setLayout(cl);


            deck.add(MenuPanel(),"menu");
            deck.add(Tutorial(),"tut");
            deck.add(LevelSelection(),"select");

            deck.add(Level1Panel(),"lvl1");

            deck.add(Level2Panel(),"lvl2");

            deck.add(Level3Panel(),"lvl3");

            deck.add(Level4Panel(),"lvl4");

            container.add(deck);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setSize(screenWidth,screenHeight);
            setLocationRelativeTo(null);
            setVisible(true);

        }

        public JPanel MenuPanel() {
            JPanel menuButtonPanel = new JPanel();
//            menuButtonPanel.setLayout(new GridLayout(1,3));
            menuButtonPanel.setLayout(new BoxLayout(menuButtonPanel, BoxLayout.Y_AXIS));

            JLabel menuLabel = new JLabel("Asteroids Inavaders!!!");
            menuLabel.setAlignmentX(menuLabel.CENTER_ALIGNMENT);
            menuLabel.setFont(new Font("Verdana",Font.BOLD,20));
            menuLabel.setForeground(Color.WHITE);

            levelSelectionButton = new JButton("Level Selection");
            levelSelectionButton.setPreferredSize(new Dimension(125,40));
            levelSelectionButton.setBackground(new Color(131, 96, 255));
            levelSelectionButton.setForeground(Color.BLACK);
            levelSelectionButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            levelSelectionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            levelSelectionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cl.show(deck,"select");
                }
            });

            TutorialButton = new JButton("Tutorial");
            TutorialButton.setPreferredSize(new Dimension(125,40));
            TutorialButton.setBackground(Color.CYAN);
            TutorialButton.setForeground(Color.BLACK);
            TutorialButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            TutorialButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            TutorialButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cl.show(deck,"tut");
                }
            });

            Exit = new JButton("Exit");
            Exit.setPreferredSize(new Dimension(125,40));
            Exit.setBackground(new Color(131, 96, 255));
            Exit.setForeground(Color.BLACK);
            Exit.setFont(new Font("Tahoma", Font.BOLD, 12));
            Exit.setAlignmentX(Component.CENTER_ALIGNMENT);

            Exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            menuButtonPanel.add(Box.createVerticalGlue());
            menuButtonPanel.add(menuLabel);
            menuButtonPanel.add(Box.createRigidArea(new Dimension(0,10)));
            menuButtonPanel.add(levelSelectionButton);
            menuButtonPanel.add(Box.createRigidArea(new Dimension(0,10)));
            menuButtonPanel.add(TutorialButton);
            menuButtonPanel.add(Box.createRigidArea(new Dimension(0,10)));
            menuButtonPanel.add(Exit);
            menuButtonPanel.add(Box.createVerticalGlue());
            menuButtonPanel.setBackground(Color.BLACK);
            return menuButtonPanel;
        }
        public JPanel LevelSelection(){

            JLabel levelSelectionLabel = new JLabel("Level Selection");
            JPanel levelSelectionPanel = new JPanel();
            levelSelectionPanel.setLayout(new BoxLayout(levelSelectionPanel,BoxLayout.Y_AXIS));

            levelSelectionLabel.setFont(new Font("Verdana",Font.BOLD,20));
            levelSelectionLabel.setAlignmentX(levelSelectionLabel.CENTER_ALIGNMENT);
            levelSelectionLabel.setForeground(Color.white);
            LevelOne = new JButton("Level One");
            LevelOne.setPreferredSize(new Dimension(125,40));
            LevelOne.setBackground(new Color(131, 96, 255));
            LevelOne.setForeground(Color.BLACK);
            LevelOne.setFont(new Font("Tahoma", Font.BOLD, 12));
            LevelOne.setAlignmentX(Component.CENTER_ALIGNMENT);

            LevelTwo = new JButton("Level Two");
            LevelTwo.setPreferredSize(new Dimension(125,40));
            LevelTwo.setBackground(new Color(131, 96, 255));
            LevelTwo.setForeground(Color.BLACK);
            LevelTwo.setFont(new Font("Tahoma", Font.BOLD, 12));
            LevelTwo.setAlignmentX(Component.CENTER_ALIGNMENT);


            LevelThree = new JButton("Level Three");
            LevelThree.setPreferredSize(new Dimension(125,40));
            LevelThree.setBackground(new Color(131, 96, 255));
            LevelThree.setForeground(Color.BLACK);
            LevelThree.setFont(new Font("Tahoma", Font.BOLD, 12));
            LevelThree.setAlignmentX(Component.CENTER_ALIGNMENT);

            LevelFour = new JButton("Level Four");
            LevelFour.setPreferredSize(new Dimension(125,40));
            LevelFour.setBackground(new Color(131, 96, 255));
            LevelFour.setForeground(Color.BLACK);
            LevelFour.setFont(new Font("Tahoma", Font.BOLD, 12));
            LevelFour.setAlignmentX(Component.CENTER_ALIGNMENT);


            Back = new JButton("Back");
            Back.setPreferredSize(new Dimension(125,40));
            Back.setBackground(new Color(131, 96, 255));
            Back.setForeground(Color.BLACK);
            Back.setFont(new Font("Tahoma", Font.BOLD, 12));
            Back.setAlignmentX(Component.CENTER_ALIGNMENT);
            Back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cl.show(deck,"menu");
                }
            });

            LevelOne.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cl.show(deck,"lvl1");
                }
            });
            LevelTwo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cl.show(deck,"lvl2");
                }
            });
            LevelThree.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cl.show(deck,"lvl3");
                }
            });
            LevelFour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cl.show(deck,"lvl4");
                }
            });

            levelSelectionPanel.add(Box.createVerticalGlue());
            levelSelectionPanel.add( levelSelectionLabel );
            levelSelectionPanel.add(Box.createRigidArea(new Dimension(0,10)));
            levelSelectionPanel.add(LevelOne);
            levelSelectionPanel.add(Box.createRigidArea(new Dimension(0,10)));
            levelSelectionPanel.add(LevelTwo);
            levelSelectionPanel.add(Box.createRigidArea(new Dimension(0,10)));
            levelSelectionPanel.add(LevelThree);
            levelSelectionPanel.add(Box.createRigidArea(new Dimension(0,10)));
            levelSelectionPanel.add(LevelFour);
            levelSelectionPanel.add(Box.createRigidArea(new Dimension(0,10)));
            levelSelectionPanel.add(Back);
            levelSelectionPanel.add(Box.createVerticalGlue());
            levelSelectionPanel.setBackground(Color.BLACK);


            return levelSelectionPanel;
        }


        public JPanel Tutorial(){
            JLabel tutorialLabel = new JLabel("Tutorial");
            tutorialLabel.setForeground(Color.WHITE);
            tutorialLabel.setAlignmentX(tutorialLabel.CENTER_ALIGNMENT);

            JTextField tutorialField = new JTextField("How to Play this game? Each level gets harder try and hit as many enemies as possible!");
            tutorialField.setEditable(false);

            JPanel tutorialPanel = new JPanel();
            tutorialPanel.setLayout(new BoxLayout(tutorialPanel, BoxLayout.Y_AXIS));

            Back = new JButton("Back");
            Back.setPreferredSize(new Dimension(125,40));
            Back.setBackground(new Color(59, 89, 182));
            Back.setForeground(Color.BLACK);
            Back.setFont(new Font("Tahoma", Font.BOLD, 12));
            Back.setAlignmentX(Component.CENTER_ALIGNMENT);
            Back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cl.show(deck,"menu");
                }
            });

            tutorialPanel.add( tutorialLabel);
            tutorialPanel.add(tutorialField);
            tutorialPanel.add(Back);
            tutorialPanel.setBackground(Color.BLACK);
            return tutorialPanel;
        }

        public JPanel Level1Panel(){
            JPanel levelOnePanel = new JPanel();
            Game game = new Game();
            levelSelect = new Levels(game);
            levelOnePanel.add(game);


            levelSelect.levelOne();
            return levelOnePanel;
        }
        public JPanel Level2Panel(){
            JPanel levelTwoPanel = new JPanel();
            Game game = new Game();
            levelSelect = new Levels(game);
            levelTwoPanel.add(game);
            levelTwoPanel.setFocusable(true);


            levelSelect.levelTwo();
            return levelTwoPanel;
        }
        public JPanel Level3Panel(){
            JPanel levelThreePanel = new JPanel();
            Game game = new Game();
            levelSelect = new Levels(game);
            levelThreePanel.add(game);

            levelSelect.levelThree();
            return levelThreePanel;
        }
        public JPanel Level4Panel(){
            JPanel levelFourPanel = new JPanel();
            Game game = new Game();
            levelSelect = new Levels(game);
            levelFourPanel.add(game);

            levelSelect.levelFour();
            return levelFourPanel;
        }


    }

}
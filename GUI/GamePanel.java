package GUI;

import Character.Character;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{

    //Screen Settings
    final int originalTileSize = 16;
    final int scale = 3;

    final double FPS = 60;
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    KeyboardHandler keyH = new KeyboardHandler();
    MouseHandler mouseH = new MouseHandler();
    Character character = new Character(this, keyH, mouseH);
    Thread gameThread;

    // Players Default Position
    int playerX = screenWidth/2;
    int playerY = screenHeight/2;
    int playerSpeed = 4;
    int gravity = 4;

    // For Jump
    int jumpTimer = 0;
    boolean jump = false;

    // Collision Hit-boxes
    int[][] tileLocations = new int[1000][];
    int currentPosLoc = 0;

    // Player Hitbox
    int[][][] hitbox = new int[tileSize * tileSize][tileSize][2];
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.setFocusable(true);

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        double lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime ) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1){

                update();

                repaint(); // calls paintComponent()
                delta--;
            }
        }
    }

    public void update() {

        character.update();
        // Player Hit-box

        /*for (int i = 0; i < tileSize; i++){
            for (int o = 0; i < tileSize; i++){

                // x hit-box
                hitbox[i][o][0] = playerX + i;
                // y hit-box
                hitbox[i][o][1] = playerY + o;

                System.out.print("x: " + hitbox[i][o][0] + " y: " + hitbox[i][o][1] + " | ");
            }
            System.out.println(" ");

        }*/
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        // User
        Graphics2D g2 = (Graphics2D)g;
        character.draw(g2);
        g2.dispose();


    }

    protected boolean within2(int[][]list, int[]check){
        for (int[] element : list) {
            if (element == null){
                continue;
            }
            if (element[0] == check[0] && element[1] == check[1]) {
                return true;
            }
        }
        return false;
    }

    protected boolean within3(int[][][]list, int[][]check){
        for (int[][] element : list) {
            if (element == null){
                continue;
            }
            for (int[] element2 : element){
                for (int[]check1 : check){
                    if (element2 == null) {
                        continue;
                    }
                    if (element2[0] == check1[0] && element2[1] == check1[1]) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private int[][] hitBox(int[][]x){
        int[][] output = new int[2304][2];
        int count1 = 0;
        int count2 = 0;
        for(int[] elements : x){
            for (int i = 0; i < 2304; i++){
                output[i][0] = elements[0] + count1;
                output[i][1] = elements[1] + count2;
                count1++;
                if (count1 == 48){
                    count2 ++;
                    count1 = 0;
                }
            }
            return output;
        }
        return output;
    }


}

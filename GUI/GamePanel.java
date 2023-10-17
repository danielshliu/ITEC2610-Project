package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{

    //Screen Settings
    final int originalTileSize = 16;
    final int scale = 3;

    final double FPS = 60;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    KeyHandler keyH = new KeyHandler();
    MouseHandler mouseH = new MouseHandler();
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

        if (keyH.up && playerY - playerSpeed >= 0) {
            playerY -= playerSpeed;
        }

        if (keyH.down && playerY + playerSpeed <= screenHeight - tileSize) {
            playerY += playerSpeed;
        }

        if (keyH.left && playerX - playerSpeed >= 0) {
            playerX -= playerSpeed;
        }
        if (keyH.right && playerX + playerSpeed <= screenWidth - tileSize) {
            playerX += playerSpeed;
        }

        if (mouseH.mouseClicked){
            System.out.println("X: " + mouseH.mouseLocation[0] + " Y: " + mouseH.mouseLocation[1]);
        }
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        // User
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);

        Graphics2D g3 = (Graphics2D)g;
        /* // Floor
        for (int i=0; i < screenWidth/tileSize; i++){
            g3.setColor(Color.green);
            g3.fillRect(tileSize * i,screenHeight-tileSize,tileSize,tileSize);
            if (!within2(tileLocations, new int[]{tileSize * i, screenHeight - tileSize})){
                tileLocations[currentPosLoc] = new int[]{tileSize * i, screenHeight - tileSize};
                currentPosLoc ++;
            }
            } */

        /*
        Graphics g4 = (Graphics2D)g;
        g4.setColor(Color.pink);
        g4.fillRect(tileSize * 4, tileSize*7, tileSize, tileSize);

        tileLocations[currentPosLoc] = new int[]{tileSize * 4, tileSize * 7};
        currentPosLoc ++;

        g4.dispose(); */
        g2.dispose();
        g3.dispose();


    }

    /*
    protected void jump(){
        jumpTimer += 1;
        playerY -= playerSpeed*2.5;
        System.out.println(jumpTimer);
        if (jumpTimer >15){
            jump = false;
            jumpTimer = 0;
        }
    }*/

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

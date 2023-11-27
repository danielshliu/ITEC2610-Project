package Game;

import Character.Character;
import Character.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import gamestates.Gamestate;
import gamestates.Menu;
import levels.LevelManager;
import levels.Levels;
import gamestates.Playing;


public class Game extends JPanel implements Runnable{

    //Menu stuff
    private Menu menu;
    private MainFrame mainFrame;
    Thread gameThread;

    //Screen Settings
    final static int originalTileSize = 16;
    private final double FPS = 60;
    private final double UPS_SET = 200;
    public final static int scale = 3;
    public static final int tileSize = originalTileSize * scale; // 48
    final static int maxScreenCol = 16;
    final static int maxScreenRow = 12;
    public static final int screenWidth = tileSize * maxScreenCol; // 768
    public static final int screenHeight = tileSize * maxScreenRow; // 576
    public Rectangle playScreen = new Rectangle(-tileSize, -tileSize, screenWidth+(tileSize*2), screenHeight+(tileSize*2));
    KeyboardHandler keyH = new KeyboardHandler();
    MouseHandler mouseH = new MouseHandler();

    public Character character = new Character(this, keyH, mouseH);

    public ArrayList<Enemy1> asteroids = new ArrayList<>();
    ArrayList<Enemy1> enemies = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();
    int enemyCount;
    Font stringFont = new Font( "SansSerif", Font.BOLD, 60 );



    public Game(){ //Default constructor
        //menu = new Menu(this);

        //gamePanel = new GamePanel(this);
        //mainFrame = new MainFrame(gamePanel);
        //gamePanel.requestFocus();

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        startGameThreadLoop();

        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.addMouseMotionListener(mouseH);
//        this.setFocusable(true);

    }

    public void startGameThreadLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    // Making the game 60FPS
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;

        double delta = 0;
        double lastTime = System.nanoTime();
        long currentTime;
        int FPStest = 0;
        long lastCheck = System.currentTimeMillis();

        while (gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime ) / drawInterval;

            lastTime = currentTime;
            if (delta >= 1){
                // Check the FPS if it prints 1000 thats 60FPS
                /*
                FPStest += 1;
                if (FPStest == 60){
                    System.out.println(System.currentTimeMillis() - lastCheck);
                    FPStest = 0;
                    lastCheck = System.currentTimeMillis();
                } */
                updateGameCharacter();
                repaint(); // calls paintComponent()
                delta--;
            }

        }
    }


    public void updateGameCharacter() {

        enemies.clear();
        for (Enemy1 e : asteroids){
            if (e.valid){
                enemies.add(e);
            }
        }

        enemyCount = enemies.size();

        //Change character back to testCharacter if error
        for (int o = 0; o < character.bulletInChamber.size(); o++){
            if (character.bulletInChamber.get(o).valid) {
                bullets.add(character.bulletInChamber.get(o));
            }
        }
        //HitBoxes.add(character.getHitbox());

        for (Enemy1 e : enemies) {
            for (Bullet b : bullets) {
                if(e.getHitbox().contains(b.getHitbox())){
                    e.hit(bullets.indexOf(b));
                    b.valid = false;
                }
            }
            if (rectCheck(e.getHitbox(), character.getHitbox())){
                if (e.getHitbox().x != 0 || e.getHitbox().y != 0){
                    character.gotHit(rectCheckTest(e.getHitbox(), character.getHitbox()));
                    e.valid = false;
                }

            }
        }
;
        //Change character back to testCharacter if error
        character.update();
        for (Enemy1 e : asteroids){
            if (e.valid){
                e.update();
            }
        }

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        // Enemy (Asteroid)
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.gray);
        g2.setFont(stringFont);
        g2.drawString(""+enemyCount, screenWidth/2, screenHeight/2);
        g2.setColor(Color.white);
        character.drawHitbox(g2);

        for (Enemy1 e : asteroids){
            if (e.valid){
                e.draw(g2);
            }
        }
        //Change character back to testCharacter if error

        // User (Paint last)
        character.draw(g2);

        g2.dispose();
    }




    public static boolean rectCheck(Rectangle r1, Rectangle r2){

        for (int i = 0 ; i <= r1.width; i++){
            for (int o = 0 ; o <= r1.height; o++){
                if (r2.contains(r1.x + i, r1.y + o)){
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] rectCheckTest(Rectangle r1, Rectangle r2){

        for (int i = 0 ; i <= r1.width; i++){
            for (int o = 0 ; o <= r1.height; o++){
                if (r2.contains(r1.x + i, r1.y + o)){
                    return new int[]{r1.x + i, r1.y + o};
                }
            }
        }
        return new int[]{};
    }

}

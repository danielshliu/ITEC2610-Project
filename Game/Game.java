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
    private GamePanel gamePanel;
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


    private LevelManager levelManager;
    private Playing playing = new Playing(this);
    Levels lvl = new Levels(this);
    public Character character = new Character(this, keyH, mouseH);

    public Character testCharacter = new Character (this, playing);


    public ArrayList<Enemy1> asteroids = new ArrayList<>();
    ArrayList<Enemy1> enemies = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();

    int enemyCount;
    Font stringFont = new Font( "SansSerif", Font.BOLD, 60 );



    public Game(){ //Default constructor
        menu = new Menu(this);

        gamePanel = new GamePanel(this);
        mainFrame = new MainFrame(gamePanel);
        gamePanel.requestFocus();

        startGameThreadLoop();

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);


        //Change Input back to keyH if error
        this.addKeyListener(playing);

        //Change Input back to mouseH if error
        this.addMouseListener(playing);
        this.addMouseMotionListener(playing);

       this.setFocusable(true);

        lvl.levelOne();
        //lvl.testLevel();
    }

    public void startGameThreadLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void inittClasses(){
       //menu = new Menu(this);
    }

    // Making the game 60FPS
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double timePerUpdate = 1000000000/UPS_SET;

        double delta = 0;
        double deltaU = 0;
        double lastTime = System.nanoTime();
        long currentTime;
        int FPStest = 0;
        long lastCheck = System.currentTimeMillis();

        while (gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime ) / drawInterval;
            deltaU += (currentTime - lastTime) / timePerUpdate;

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
                update();
                updateGameCharacter();
                repaint(); // calls paintComponent()
                //gamePanel.repaint();
                delta--;
            }

//            if(deltaU >=1){
//                gamePanel.repaint();
//                deltaU--;
//            }
        }
    }


    public void update(){
        switch(Gamestate.state){
            case MENU:
                menu.update();
                break;
            case PLAYING:
                playing.update();
                break;
            case OPTIONS:
            case QUIT:
            default:
                System.exit(0);
                break;
        }
    }

    public void render(Graphics g) {
        switch(Gamestate.state){
            case MENU:
                menu.draw(g);
                break;
            //add level selection: I'll fiqure it out.
            case PLAYING:
                playing.draw(g);
                break;
            default:
                break;
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
        for (int o = 0; o < testCharacter.bulletInChamber.size(); o++){
            if (testCharacter.bulletInChamber.get(o).valid) {
                bullets.add(testCharacter.bulletInChamber.get(o));
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
            if (rectCheck(e.getHitbox(), testCharacter.getHitbox())){
                if (e.getHitbox().x != 0 || e.getHitbox().y != 0){
                    testCharacter.gotHit(rectCheckTest(e.getHitbox(), testCharacter.getHitbox()));
                    e.valid = false;
                }

            }
        }
;
        //Change character back to testCharacter if error
        testCharacter.update();
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
        testCharacter.drawHitbox(g2);

        for (Enemy1 e : asteroids){
            if (e.valid){
                e.draw(g2);
            }
        }
        //Change character back to testCharacter if error

        // User (Paint last)
        testCharacter.draw(g2);

        g2.dispose();
    }


    public Menu getMenu(){
        return menu;
    }

    public Playing getPlaying(){
        return playing;
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

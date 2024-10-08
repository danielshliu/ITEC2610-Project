package Game;

import Character.Character;
import Character.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import Levels.Levels;


public class Game extends JPanel implements Runnable{
    public Levels lvl;
    Thread gameThread;
    //Screen Settings
    public double level;
    private int enemyCount;
    private final static int originalTileSize = 16;
    private final double FPS = 60;
    private final static int maxScreenCol = 16;
    private final static int maxScreenRow = 12;
    public final static int scale = 3;
    public static final int tileSize = originalTileSize * scale; // 48
    public static final int screenWidth = tileSize * maxScreenCol; // 768
    public static final int screenHeight = tileSize * maxScreenRow; // 576
    public Rectangle playScreen = new Rectangle(-tileSize, -tileSize, screenWidth+(tileSize*2), screenHeight+(tileSize*2));
    private KeyboardHandler keyH = new KeyboardHandler();
    private MouseHandler mouseH = new MouseHandler();
    public Character character = new Character(this, keyH, mouseH);
    public ArrayList<Enemy1> asteroids = new ArrayList<>();
    private ArrayList<Enemy1> enemies = new ArrayList<>();
    private ArrayList<Bullet> bullets = new ArrayList<>();
    Font stringFont = new Font( "SansSerif", Font.BOLD, 60 );
    Font healthFont = new Font( "SansSerif", Font.TRUETYPE_FONT, 30 );



    public Game(){ //Default constructor
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.addMouseMotionListener(mouseH);
        this.setFocusable(true);

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
                updateGameCharacter();
                repaint(); // calls paintComponent()
                delta--;
            }

        }
    }


    public void updateGameCharacter() {
        enemies.clear();
        try{
            for (Enemy1 e : asteroids){
                if (e.valid){
                    enemies.add(e);
                }
            }
        } catch(Error e){
            e.printStackTrace();
        }

        enemyCount = enemies.size();

        if (enemyCount == 0){
            if (level == 1.1){
                lvl.levelOneWave2();
                bullets.clear();
            } else if(level == 2.1){
                lvl.levelTwoWave2();
                bullets.clear();
            } else if(level == 3.1){
                lvl.levelThreeWave2();
                bullets.clear();
            } else if(level == 3.2){
                lvl.levelThreeWave3();
                bullets.clear();
            } else if(level == 4.1){
                lvl.levelFourWave2();
                bullets.clear();
            } else if(level == 4.2){
                lvl.levelFourWave3();
                bullets.clear();
            } else if(level == 4.3){
                lvl.levelFourWave4();
                bullets.clear();
            }
        } else if (enemyCount <= 24 && level == 4.4){
            lvl.levelFourWave2();
        }

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

        if (character.getHitPoint() <= 0){
            g2.setColor(Color.red);
            g2.setFont(stringFont);
            g2.drawString("DEAD", screenWidth/2-60, screenHeight/2);
            g2.setFont(healthFont);
            g2.setColor(Color.white);
            g2.drawString("click esc", screenWidth/2-30, screenHeight/2+60);
        } else if(enemyCount == 0 && level == 0){
            g2.setColor(Color.green);
            g2.setFont(stringFont);
            g2.drawString("LEVEL COMPLETE!!", screenWidth/2-300, screenHeight/2);
            g2.setFont(healthFont);
            g2.setColor(Color.white);
            g2.drawString("click esc to return", screenWidth/2-100, screenHeight/2+60);
        }

        else{
            g2.setColor(Color.gray);
            g2.setFont(stringFont);
            g2.drawString(""+enemyCount, screenWidth/2-60, screenHeight/2);
            g2.setColor(Color.red);
            g2.setFont(healthFont);
            g2.drawString("HP: "+character.getHitPoint(), screenWidth-tileSize*2-30, tileSize);
            g2.setColor(Color.white);

            for (Enemy1 e : asteroids){
                if (e.valid){
                    e.draw(g2);
                }
            }
            // User (Paint last)
            character.draw(g2);
        }
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

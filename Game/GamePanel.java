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


public class GamePanel extends JPanel implements Runnable{

    //Menu stuff
    private Menu menu = new Menu(this);
    private LevelManager levelManager;


    //Screen Settings
    final static int originalTileSize = 16;
    final double FPS = 60;
    public final static int scale = 3;
    public static final int tileSize = originalTileSize * scale; // 48
    final static int maxScreenCol = 16;
    final static int maxScreenRow = 12;
    public static final int screenWidth = tileSize * maxScreenCol; // 768
    public static final int screenHeight = tileSize * maxScreenRow; // 576
    public Rectangle playScreen = new Rectangle(-tileSize, -tileSize, screenWidth+(tileSize*2), screenHeight+(tileSize*2));
    KeyboardHandler keyH = new KeyboardHandler();
    MouseHandler mouseH = new MouseHandler();
    Playing Input = new Playing(this);
    Levels lvl = new Levels(this);
    public Character character = new Character(this, keyH, mouseH);

    public Character testCharacter = new Character (this, Input);
    public ArrayList<Enemy1> asteroids = new ArrayList<>();

    //Jacob I'm guessing these enemies here don't really matter since enemies are created in the level class.

    //Enemy1 enemy1 = new Enemy1(this, new int[]{-3, -1} ,new int[]{1,1}, new int[]{2, 3});
//    Enemy1 enemy1 = new Enemy1(this, new int[]{0, 400} ,new int[]{300, 200}, new int[]{768, 300}, 2);

//    Enemy1 enemy2 = new Enemy1(this, new int[]{screenWidth, 520} ,new int[]{300, 400}, new int[]{0, 360}, 1);
    Thread gameThread;

    ArrayList<Enemy1> enemies = new ArrayList<>();
    ArrayList<Bullet> bullets = new ArrayList<>();
    Rectangle t1;
    int hit1;

    public GamePanel(){ //Default constructor
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        //Change Input back to keyH if error
        this.addKeyListener(Input);
        //Change Input back to mouseH if error
        this.addMouseListener(Input);
        this.addMouseMotionListener(Input);

        this.setFocusable(true);

        //Disabling this for now
        lvl.testLevel();
        lvl.levelOne();
    }

    public void startGameThread(){
        //Menu things click things.

        switch(Gamestate.state){
            case MENU:
                menu.update();
                break;
            case PLAYING:
                gameThread = new Thread(this);
                gameThread.start();
                break;
            case OPTIONS:
            case QUIT:
            default:
                System.exit(0);
                break;
        }
    }

    // Making the game 60FPS
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

        enemies.clear();
        for (Enemy1 e : asteroids){
            if (e.valid){
                enemies.add(e);
            }
        }
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
        }

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
        for (Enemy1 e : asteroids){
            if (e.valid){
                e.draw(g2);
            }
        }
        //Change character back to testCharacter if error
        testCharacter.drawHitbox(g2);
        // User (Paint last)
        testCharacter.draw(g2);

        g2.dispose();
    }

    public Rectangle checkCollision2(ArrayList<Rectangle> l, ArrayList<Rectangle> l2){
        for (Rectangle rectangle : l) {
            for (Rectangle rectangle2 : l2) {
                if(rectangle.contains(rectangle2)){
                    return rectangle;
                }
            }
        }
        return null;
    }
}

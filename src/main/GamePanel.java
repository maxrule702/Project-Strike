package main;

import entity.Player;
import objects.SuperObject;
import sound.Sound;
import tiles.tileManger;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {
    //Screen settings
    final int oringinalTileSize = 32; // 16*16 tile
    final int scale = 2; //scaling character

    public final int tileSize = oringinalTileSize * scale;
    public final int maxScreenCol = 24;
    public final float maxScreenRow = 14F;
    public final int screenwidth = tileSize * maxScreenCol; //1080 pixels
    public final float screenHeight = tileSize * maxScreenRow; //1920 pixels

    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;


    //FPS Limter
    int FPS = 60;

    tileManger tileM = new tileManger(this);
    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();
    Thread gameThread;
    public collisionChecker cChecker = new collisionChecker(this);
    public assetSetter aSetter = new assetSetter(this);
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10];


    //set player default location
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


    public GamePanel() {
        this.setPreferredSize((new Dimension((int) screenwidth, (int) screenHeight)));
        this.setBackground(new Color(255, 255, 255));
        this.setDoubleBuffered(true); //performance increase
        this.addKeyListener(keyH);
        this.setFocusable(true);


    }

    public void setupGame() {
        aSetter.setObject();

        playMusic(0);

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {
//This loop runs constantly until it the game is closed

        while (gameThread != null) {

            double drawInterval = 1000000000 / FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            long timer = 0;
            int drawCount = 0;


            while (gameThread != null) {
                currentTime = System.nanoTime();
                timer += (currentTime - lastTime);
                delta += (currentTime - lastTime) / drawInterval;
                lastTime = currentTime;

                if (delta >= 1) {
                    update();
                    repaint();
                    delta--;
                    drawCount++;
                }
                if (timer >= 1000000000) {
                    System.out.println("FPS " + drawCount);
                    drawCount = 0;
                    timer = 0;
                }
            }


            update();

            repaint();


        }
    }

    //movement
    public void update() {
        player.update();
    }


    public void paintComponent(Graphics g) {
        //repaint()
        //update graphics
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }

        }
        player.draw(g2);
        g2.dispose();


    }

    public void playMusic(int i) {

        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {

        sound.stop();
    }

    public void playSE(int i) {

        sound.setFile(i);
    }
}

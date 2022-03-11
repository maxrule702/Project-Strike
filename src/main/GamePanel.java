package main;

import entity.Player;
import objects.SuperObject;
import sound.Sound;
import tiles.tileManger;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {
    //Screen settings
    final int originalTileSize = 32; // 16*16 tile
    final int scale = 2; //scaling character

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 24;
    public final float maxScreenRow = 14F;
    public final int screenWidth = tileSize * maxScreenCol; //1080 pixels
    public final float screenHeight = tileSize * maxScreenRow; //1920 pixels

    //WORLD SETTINGS
    //change these setting for map size
    public final int maxWorldCol = 50;
    //use the editor to make sure it works;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;


    //FPS Limiter
    int FPS = 60;

    // System
    tileManger tileM = new tileManger(this);
    KeyHandler keyH = new KeyHandler(this);
    Sound sound = new Sound();
    public collisionChecker cChecker = new collisionChecker(this);
    public assetSetter aSetter = new assetSetter(this);
    Thread gameThread;
    // Entity and Object
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10];

    //Game State
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;

    //set playerChar default location
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


    public GamePanel() {
        this.setPreferredSize((new Dimension((int) screenWidth, (int) screenHeight)));
        this.setBackground(new Color(255, 255, 255));
        this.setDoubleBuffered(true); //performance increase
        this.addKeyListener(keyH);
        this.setFocusable(true);


    }

    public void setupGame() {
        aSetter.setObject();
        playMusic(0);
        gameState = playState;
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
        if(gameState == playState) {
            player.update();
        }
        if (gameState == pauseState) {
            //nothing
        }

    }


    public void paintComponent(Graphics g) {
        //repaint()
        super.paintComponent(g);

        //update graphics
        Graphics2D g2 = (Graphics2D) g;


        //debug
        long drawStart = 0;
        if (keyH.checkDrawTime == true){
            drawStart = System.nanoTime();
        }





        //tiles
        tileM.draw(g2);

        //obj
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }

        }

        //player
        player.draw(g2);

        //debug
        if (keyH.checkDrawTime == true){


        long drawend = System.nanoTime();
        long passed = drawend - drawStart;
        g2.setColor(Color.white);
        g2.drawString ("draw time:" + passed,10,400);
        System.out.println("draw time;" + passed);
        }
        //end
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
        sound.play();

    }
}

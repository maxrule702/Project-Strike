package main;

import entity.Entity;
import objects.OBJ_Heart;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_20, arial_80B;
    BufferedImage emptyHeart, fullHealth, halveHealth;
    //BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public int commandNum = 0;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_20 = new Font ("Arial", Font.PLAIN, 20);
        arial_80B = new Font ("Arial", Font.BOLD, 80);
        //OBJ Key key = new OBJ_Key(gp);
        //keyImage = key.image;
        Entity heart = new OBJ_Heart(gp);
        fullHealth = heart.image;
        halveHealth = heart.image1;
        emptyHeart = heart.image2;
    }
    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }
    public void draw(Graphics g2) {

        this.g2 = (Graphics2D) g2;
        g2.setFont(arial_20);
        g2.setColor(Color.white);

        //Title State
        if(gp.gameState == gp.titleState) {
           drawTitleScreen();
        }

        //Play State
        if (gp.gameState == gp.playState) {
            drawPlayerLife(); //shows player life
            //Do playState stuff later
        }
        //Pause State
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
            drawPlayerLife();
        }
    }

    public void drawPlayerLife() {
    // USE THIS FOR CHANGING THE HEALTH APPEARENCE gp.player.life = 5;
        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;
        //DRAW MAX LIFE
        while (i < gp.player.maxLife / 2) {
            g2.drawImage(fullHealth, x, y, null);
            i++;
            x += gp.tileSize + 4;
        }


//RESET don't forget to add 4 to X+= gp.tilesize for spacing
         x = gp.tileSize / 2;
         y = gp.tileSize / 2;
         i = 0;

        // DRAW CURRENT LIFE
        while (i < gp.player.life) {
        g2.drawImage(halveHealth,x,y,null);
        i++;
        if(i < gp.player.life){
            g2.drawImage(emptyHeart,x,y,null);
        }
        i++;
        x += gp.tileSize +4;


        }
    }


    public void drawTitleScreen() {

        g2.setColor((new Color(0,0,0)));
        g2.fillRect(0, 0, gp.screenWidth, (int) gp.screenHeight);

        //Title Name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Project Strike";
        int x = getXForCenteredText(text);
        int y = gp.tileSize*3;

        //Shadow
        g2.setColor(Color.gray);
        g2.drawString(text, x+5, y+5);
        //Main Colour
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //Project Strike Image
        x = gp.screenWidth/2 - (gp.tileSize*2)/2;
        y += gp.tileSize*2;
        g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);
        //menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "NEW GAME";
        x = getXForCenteredText(text);
        y+= gp.tileSize*3.5;
        g2.drawString(text, x, y);
        if(commandNum == 0) {
            g2.drawString(">", x- gp.tileSize, y);
        }

        text = "LOAD GAME";
        x = getXForCenteredText(text);
        y+= gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1) {
            g2.drawString(">", x- gp.tileSize, y);
        }

        text = "QUIT";
        x = getXForCenteredText(text);
        y+= gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2) {
            g2.drawString(">", x- gp.tileSize, y);
        }
    }

    public void drawPauseScreen() {

        g2.setFont(arial_80B);
        g2.setColor(Color.blue);
        String text = "PAUSED";
        int x = getXForCenteredText(text);
        float y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }
    public int getXForCenteredText(String text) {

        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}

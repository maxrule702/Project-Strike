package main;

import objects.OBJ_Heart;
import objects.SuperObject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_20, arial_40B;
    BufferedImage emptyHeart, fullHealth, halveHealth;
    //BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_20 = new Font ("Arial", Font.PLAIN, 20);
        arial_40B = new Font ("Arial", Font.BOLD, 40);
        //OBJ Key key = new OBJ_Key(gp);
        //keyImage = key.image;
        SuperObject heart = new OBJ_Heart(gp);
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

        if (gp.gameState == gp.playState) {
            drawPlayerLife(); //shows player life
            //Do playState stuff later
        }
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
            drawPlayerLife();
        }
    }

    public void drawPlayerLife(){
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;
        while (i < gp.player.maxLife /2){
            g2.drawImage(emptyHeart,x,y,null);
            i++;
            x+= gp.tileSize;
        }
    }

    public void drawPauseScreen() {

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,40F));
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

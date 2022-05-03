package main;

import entity.Entity;
import objects.OBJ_Heart;
import sound.Sound;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;




public class UI {
    GamePanel gp;

    Graphics2D g2;
    Font arial_20, arial_80B;
    BufferedImage empty_heart, full_heart, half_heart; //Buffered reader for heart images
    //BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public int commandNum = 0;
public int slotCol = 0 ;
public int slotRow = 0;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    Sound sound = new Sound();
    public UI(GamePanel gp) {
        this.gp = gp;
        arial_20 = new Font ("Arial", Font.PLAIN, 20);
        arial_80B = new Font ("Arial", Font.BOLD, 80);
        //OBJ Key key = new OBJ_Key(gp);
        //keyImage = key.image;

        //Creation of heart objects to go on UI
        Entity heart = new OBJ_Heart(gp);
        full_heart = heart.image;
        half_heart = heart.image1;
        empty_heart = heart.image2;
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

        }

        //charScreen
        if(gp.gameState == gp.characterState){
            drawCharacterScreen();
            drawInventory();
        }

    }

    public void drawPlayerLife() {
        // USE THIS FOR CHANGING THE HEALTH APPEARANCE gp.player.life = 5;
        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;
        //DRAW MAX LIFE
        while (i < gp.player.maxLife / 2) {
            g2.drawImage(full_heart, x, y, null);
            i++;
            x += gp.tileSize + 4;
        }


//RESET don't forget to add 4 to X+= gp.tilesize for spacing
         x = gp.tileSize / 2;
         y = gp.tileSize / 2;
         i = 0;

        // DRAW CURRENT LIFE
        while (i < gp.player.life) {
            g2.drawImage(half_heart,x,y,null);
            i++;
            if(i < gp.player.life){
                g2.drawImage(empty_heart,x,y,null);
            }
            i++;
            x += gp.tileSize +4;


        }
    }





    public void  drawSkinsScreen() {
    g2.dispose();
    g2.drawImage(gp.player.down1, 300, 100, gp.tileSize*2, gp.tileSize*2, null);
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

        text = "SKINS";
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
    public int getXForRightText(String text, int tailX) {

        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX-length;
        return x;
    }



public void drawCharacterScreen(){
        //create a frame
    final int frameX = gp.tileSize * 2;
    final int frameY = gp.tileSize;
    final int frameWidth = gp.tileSize * 5;
            final int frameHeight = gp.tileSize * 10;
drawSubWindow(frameX,frameY,frameWidth,frameHeight);


//text
    g2.setColor(Color.white);

    g2.setFont(g2.getFont().deriveFont(32F));
    int textX = frameX +20;
    int textY = frameY + gp.tileSize;
    final int lineHeight = 32;
    //name
    g2.drawString("level",textX,textY);
    textY += lineHeight;

    g2.drawString("life "  ,textX,textY);
    textY += lineHeight;

    g2.drawString("weapon",textX,textY);
    textY += lineHeight;


    g2.drawString("shield",textX,textY);
    textY += lineHeight;
// values
    int tailX = (frameX + frameWidth ) -30;
//rest textY
    textY = frameY + gp.tileSize;
    String value;

    value = String.valueOf(gp.player.level);
    textX = getXForRightText(value , tailX);
    g2.drawString(value, textX,textY);
    textY += lineHeight;

    value = String.valueOf(gp.player.life);
    textX = getXForRightText(value , tailX);
    g2.drawString(value, textX,textY);
    textY += lineHeight;




    g2.drawImage(gp.player.currentWeapon.down1,tailX - gp.tileSize, textY,null);
    textY += gp.tileSize;
    g2.drawImage(gp.player.currentShield.down1, tailX - gp.tileSize ,textY, null);
}






    public void drawInventory(){
        int frameX = gp.tileSize * 18;
        int frameY = gp.tileSize;
        int frameHeight = gp.tileSize * 6;
        int frameWidth = gp.tileSize * 5;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        //slots

        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX  = slotXstart;
        int slotY = slotYstart;

        int cursorX = slotXstart + (gp.tileSize * slotCol);
        int cursorY = slotYstart + (gp.tileSize * slotRow);
        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;
        //draw
        g2.setColor(Color.WHITE);
        g2.drawRoundRect(cursorX,cursorY,cursorWidth,cursorHeight,10,10);
    }









public  void drawSubWindow (int x, int y , int width , int height){
        Color c = new Color(0,0,0);
        g2.setColor(c);
        g2.fillRect(x,y,width,height);
        c =  new Color (255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5 ,y+5, width-10,height-10,25,25);
}







}

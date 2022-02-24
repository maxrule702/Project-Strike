package entity;

import main.GamePanel;
import main.KeyHandler;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;


    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefultValues();
        getPlayerImage();
        direction = "right1";
        screenX = (int) (gp.screenwidth / 2 - (gp.tileSize/2));
        screenY = (int) (gp.screenHeight /2- (gp.tileSize/2));
    }

    public void setDefultValues() {
         worldX = gp.tileSize * 23;
         worldY = gp.tileSize * 21;
        speed = 4;
    }


    public  void getPlayerImage() {
        try {
up1 = ImageIO.read(getClass().getResourceAsStream("/player/spriteUp.png"));
right1 = ImageIO.read(getClass().getResourceAsStream("/player/spriteRight.png"));
down1 = ImageIO.read(getClass().getResourceAsStream("/player/spriteDown.png"));
left1 = ImageIO.read(getClass().getResourceAsStream("/player/spriteLeft.png"));







        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void update() {
        //movement
        if (keyH.upPressed == true) {
            worldY -= speed;
            direction = "up";
        } else if (keyH.downPressed == true) {
            worldY += speed;
            direction = "down";
        } else if (keyH.leftPressed == true) {
            worldX -= speed;
            direction = "left";
        } else if (keyH.rightPressed == true) {
            worldX += speed;
            direction = "right";
        }

    }

    public void draw(Graphics2D g2) {


//        g2.setColor(Color.blue);
//
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);


        BufferedImage image = null;
        switch(direction){
            case "up":
            image = up1;
            break;

            case "down":
               image = down1;
                break;

            case "left":
                image = left1;
                break;

            case "right":
                image = right1;
                break;

        }


        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);




    }
}





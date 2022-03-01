package entity;

import main.GamePanel;
import main.KeyHandler;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public static int prev = 0;


    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
        screenX =  (gp.screenwidth / 2 - (gp.tileSize/2));
        screenY = (int) (gp.screenHeight /2- (gp.tileSize/2));
        soildArea = new Rectangle(8,16,32,32);



        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
         worldX = gp.tileSize * 23;
         worldY = gp.tileSize * 14;
        speed = 4;
        direction = "right1";

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
        int previous = 0;
        //movement
        if (keyH.upPressed == true) {
            direction = "up";
            prev = 0;

        }

        else if (keyH.downPressed == true) {
            direction = "down";
            prev = 1;


        } else if (keyH.leftPressed == true) {
            direction = "left";
            prev = 2;



        } else if (keyH.rightPressed == true) {
            direction = "right";
            prev = 3;
        }


        else if (keyH.upPressed == false) {
            direction = "stop";
        }

        else if (keyH.downPressed == false) {
            direction = "stop";
        }

        else if (keyH.leftPressed == false) {
            direction = "stop";
        }

        else if (keyH.rightPressed == false) {
            direction = "stop";
        }





        // checking tile collision
        collisonOn = false;
        gp.cChecker.checkTile((this));

         //if collsion is false then player can move
        if (collisonOn == false){
            switch(direction){
                case "up":
                    worldY -= speed;
                    break;


                case "down":
                    worldY += speed;
                    break;


                case "left":
                    worldX -= speed;
                    break;


                case "right":
                    worldX += speed;
                    break;

                case "stop":

                    break;
            }
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

            case "stop":
                  if (prev == 0){
                      image = up1;
                  }

                  else if (prev == 1){
                    image = down1;
                }

                else if (prev == 2){
                    image = left1;
                }

                else if (prev == 3){
                    image = right1;
                }

                break;

        }


        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);




    }
}





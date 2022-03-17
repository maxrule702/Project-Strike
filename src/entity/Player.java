package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    int hasKey = 0;


    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);

        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
        screenX = (gp.screenWidth / 2 - (gp.tileSize / 2));
        screenY = (int) (gp.screenHeight / 2 - (gp.tileSize / 2));
        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;


        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 14;
        speed = 4;
        direction = "right";
         //player status
        maxLife = 6;
        life = maxLife;

    }


    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/playerChar/spriteUp.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/playerChar/spriteRight.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/playerChar/spriteDown.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/playerChar/spriteLeft.png"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    up1 = setup("spriteUp");
        right1 = setup("spriteRight");

        down1 = setup("spriteDown");

        left1 = setup("spriteLeft");

    }
public BufferedImage setup(String imageName){
    UtilityTool uTool  = new UtilityTool();
    BufferedImage image = null;
    try{
        image = ImageIO.read(getClass().getResourceAsStream("/playerChar/"  + imageName + ".png"));
        image = uTool.scaleImage(image,gp.tileSize,gp.tileSize);



    } catch (Exception e) {
        e.printStackTrace();
    }
    return image;
}

    public void update() {
        //movement
        if (keyH.downPressed || keyH.upPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed == true) {
                direction = "up";

            } else if (keyH.downPressed == true) {
                direction = "down";

            } else if (keyH.leftPressed == true) {
                direction = "left";

            } else if (keyH.rightPressed == true) {
                direction = "right";


            }
            // checking tile collision
            collisionOn = false;
            gp.cChecker.checkTile((this));

            // object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);


            //if collision is false then playerChar can move
            if (collisionOn == false) {
                switch (direction) {
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

                }
            }
        }
    }


    public void pickUpObject(int i) {

        if (i != 999) {
            String objectName = gp.obj[i].name;



            switch (objectName) {
                case "ammo":
                    gp.playSE(2);
                    gp.obj[i] = null;
                    System.out.println("key:" + hasKey);
                    break;

                case "door":
                    if (hasKey > 0) {
                        gp.playSE(1);
                        gp.obj[i] = null;
                        hasKey--;
                    }
                    System.out.println("key:" + hasKey);
                    break;

                case "c4":
                    gp.playSE(3);
                    hasKey++;
                    gp.obj[i] = null;
                    System.out.println("key:" + hasKey);
                    break;


            }
        }
    }

    public void draw(Graphics2D g2) {



        BufferedImage image = null;
        switch (direction) {
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


        int x = screenX;
        int y = screenY;

        if(screenX > worldX) {
            x = worldX;
        }
        if(screenY > worldY) {
            y = worldY;
        }
        int rightOffset = gp.screenWidth - screenX;
        if(rightOffset > gp.worldWidth - worldX) {
            x = gp.screenWidth - (gp.worldWidth - worldX);
        }
        float bottomOffset = (gp.screenHeight - screenY);
        if(bottomOffset > gp.worldHeight - worldY) {
            y = (int) (gp.screenHeight - (gp.worldHeight - worldY));
        }

        g2.drawImage(image, x, y, null);

    }
}





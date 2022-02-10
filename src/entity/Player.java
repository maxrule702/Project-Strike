package entity;

import com.gaming.GamePanel;
import com.gaming.KeyHandler;
import com.gaming.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefultValues();
        getPlayerImage();
        direction = "right1";
    }

    public void setDefultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }


    public  void getPlayerImage() {
        try {
up1 = ImageIO.read(getClass().getResourceAsStream("/player/spritePistolUp.png"));
right1 = ImageIO.read(getClass().getResourceAsStream("/player/spritePistolRight.png"));
down1 = ImageIO.read(getClass().getResourceAsStream("/player/spritePistolDown.png"));
left1 = ImageIO.read(getClass().getResourceAsStream("/player/spritePistolLeft.png"));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void update() {
        //movement
        if (keyH.upPressed == true) {
            y -= speed;
        } else if (keyH.downPressed == true) {
            y += speed;
        } else if (keyH.leftPressed == true) {
            x -= speed;
        } else if (keyH.rightPressed == true) {
            x += speed;
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


        g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);



    }
}





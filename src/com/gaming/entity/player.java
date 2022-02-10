package com.gaming.entity;

import com.gaming.GamePanel;
import com.gaming.KeyHandler;

import java.awt.*;

public class player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefultValues();
    }

    public void setDefultValues() {
        x = 100;
        y = 100;
        speed = 4;
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


        g2.setColor(Color.blue);

        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}





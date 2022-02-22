package com.gaming;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import main.GamePanel;

public class Crosshair {

    GamePanel gp;
    Crosshair[] crosshair;

    public Crosshair(GamePanel gp) {

        this.gp = gp;

        crosshair = new Crosshair[1];

        getCrosshairImage();
    }
    public BufferedImage up1,down1,left1,right1,image1,image2,image3,image4,image5,image6;

    public void getCrosshairImage() {
        try {

            crosshair[0] = new Crosshair();
            crosshair[0].image1 = ImageIO.read(getClass() .getResourceAsStream("/player/crosshairPrototype.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}

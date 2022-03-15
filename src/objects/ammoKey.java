package objects;

import main.GamePanel;

import javax.imageio.ImageIO;

public class ammoKey extends SuperObject {

    GamePanel gp;
    public ammoKey(GamePanel gp) {
        this.gp = gp;
        name = "ammo";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/ammoBox.png"));
            uTool.scaleImage(image,gp.tileSize, gp.tileSize);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



package objects;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_Heart extends SuperObject {

    GamePanel gp;
    public OBJ_Heart(GamePanel gp) {
        this.gp = gp;
        name = "Heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/emptyHeart.png"));
            image1 = ImageIO.read(getClass().getResourceAsStream("/objects/halveHeart.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/fullHealth.png"));
           image =  uTool.scaleImage(image,gp.tileSize, gp.tileSize);
            image1 = uTool.scaleImage(image1,gp.tileSize, gp.tileSize);
           image2 =  uTool.scaleImage(image2,gp.tileSize, gp.tileSize);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
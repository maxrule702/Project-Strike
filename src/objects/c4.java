package objects;

import main.GamePanel;

import javax.imageio.ImageIO;

public class c4 extends  SuperObject{
    GamePanel gp;
    public c4(GamePanel gp) {
        name = "c4";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/c4.png"));
            uTool.scaleImage(image,gp.tileSize, gp.tileSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

}
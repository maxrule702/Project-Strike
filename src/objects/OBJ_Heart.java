package objects;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_Heart extends Entity {

    public OBJ_Heart(GamePanel gp) {
        super(gp);
        name = "heart";
        image = setup("/objects/emptyHeart", gp.tileSize, gp.tileSize);
        image1 = setup("/objects/halveHeart", gp.tileSize, gp.tileSize);
        image2 = setup("/objects/fullHealth", gp.tileSize, gp.tileSize);
    }
}
package objects;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_Heart extends Entity {

    public OBJ_Heart(GamePanel gp) {
        super(gp);
        name = "heart";
        image = setup("/objects/empty_heart", gp.tileSize, gp.tileSize);
        image1 = setup("/objects/half_heart", gp.tileSize, gp.tileSize);
        image2 = setup("/objects/full_heart", gp.tileSize, gp.tileSize);
    }
}
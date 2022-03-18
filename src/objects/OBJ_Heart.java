package objects;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_Heart extends Entity {

    public OBJ_Heart(GamePanel gp) {
        super(gp);
        name = "heart";
        image = setup("/objects/emptyHeart");
        image1 = setup("/objects/halveHeart");
        image2 = setup("/objects/fullHealth");


    }
}
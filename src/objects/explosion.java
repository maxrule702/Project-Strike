package objects;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;


public class explosion extends Entity {

    public explosion(GamePanel gp) {
        super(gp);
        name = "explosion";
        down1 = setup("/objects/explosion_animated", gp.tileSize, gp.tileSize);

    }
}

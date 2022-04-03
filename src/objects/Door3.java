package objects;

import entity.Entity;
import main.GamePanel;

public class Door3 extends Entity {
    public Door3(GamePanel gp) {
        super(gp);
        name = "Door3";
        down1 = setup("/objects/door3", gp.tileSize, gp.tileSize);
        collision = true;
        //
    }

}







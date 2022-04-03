package objects;

import entity.Entity;
import main.GamePanel;

public class Door1 extends Entity {
    public Door1(GamePanel gp) {
        super(gp);
        name = "Door";
        down1 = setup("/objects/door1", gp.tileSize, gp.tileSize);
        collision = true;
        //
    }

}







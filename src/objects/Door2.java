package objects;

import entity.Entity;
import main.GamePanel;

public class Door2 extends Entity {
    public Door2(GamePanel gp) {
        super(gp);
        name = "Door2";
        down1 = setup("/objects/door2", gp.tileSize, gp.tileSize);
        collision = true;
        //
    }

}







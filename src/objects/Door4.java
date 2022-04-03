package objects;

import entity.Entity;
import main.GamePanel;

public class Door4 extends Entity {
    public Door4(GamePanel gp) {
        super(gp);
        name = "Door4";
        down1 = setup("/objects/door4", gp.tileSize, gp.tileSize);
        collision = true;
        //
    }

}







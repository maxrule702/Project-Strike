package objects;

import entity.Entity;
import main.GamePanel;

public class ammoKey extends Entity {

    public ammoKey(GamePanel gp) {
     super(gp);
                name = "ammo";
                down1 = setup("/objects/ammoBox", gp.tileSize, gp.tileSize);

    }
}



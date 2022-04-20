package objects;

import entity.Entity;
import main.GamePanel;

public class OBJ_Weapon  extends Entity {
    public OBJ_Weapon(GamePanel gp) {
        super(gp);

        name = "normal gun";
        down1 = setup("/objects/gun",gp.tileSize,gp.tileSize);
        attackValue = 1;
    }
}

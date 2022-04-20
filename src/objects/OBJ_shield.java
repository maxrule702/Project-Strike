package objects;

import entity.Entity;
import main.GamePanel;

public class OBJ_shield  extends Entity {
    public OBJ_shield(GamePanel gp) {
        super(gp);

    name = "riot";
    down1 = setup("/objects/riotShield",gp.tileSize,gp.tileSize);
defenseValue = 1;


    }



}

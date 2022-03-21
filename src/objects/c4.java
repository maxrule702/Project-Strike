package objects;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;


    public class c4 extends Entity {

        public c4(GamePanel gp) {
            super(gp);
            name = "c4";
            down1 = setup("/objects/c4", gp.tileSize, gp.tileSize);

        }
    }

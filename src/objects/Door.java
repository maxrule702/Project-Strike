package objects;

import entity.Entity;
import entity.Player;
import main.GamePanel;
import org.ietf.jgss.GSSManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Door extends Entity {
    public Door(GamePanel gp,int imageID) {
        super(gp);
        name = "door";

        if (imageID == 0){
            down1 = setup("/objects/door", gp.tileSize, gp.tileSize);
        }else if (imageID == 1){
            down1 = setup("/objects/door1", gp.tileSize, gp.tileSize);
        }else if (imageID == 2){
            down1 = setup("/objects/door2", gp.tileSize, gp.tileSize);
        }else if (imageID == 3){
            down1 = setup("/objects/door3", gp.tileSize, gp.tileSize);
        }else if (imageID == 4){
            down1 = setup("/objects/door4", gp.tileSize, gp.tileSize);
        }
        collision = true;
        //
    }

}







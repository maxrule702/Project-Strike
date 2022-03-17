package objects;

import entity.Entity;
import entity.Player;
import main.GamePanel;
import org.ietf.jgss.GSSManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Door extends Entity {
    public Door(GamePanel gp) {
        super(gp);
        name = "door";
        down1 = setup("/objects/door");
        collision = true;
    }

}







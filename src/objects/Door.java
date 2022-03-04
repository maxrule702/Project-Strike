package objects;

import entity.Player;
import main.GamePanel;
import org.ietf.jgss.GSSManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Door extends  SuperObject{


    public Door(GamePanel gp) {
        name = "door";


        try {

            if (gp.player.doorSprite == 0) {
                image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
            } else if (gp.player.doorSprite == 1) {
                image = ImageIO.read(getClass().getResourceAsStream("/objects/door1.png"));
            } else if (gp.player.doorSprite == 2) {
                image = ImageIO.read(getClass().getResourceAsStream("/objects/door2.png"));
            } else if (gp.player.doorSprite == 3) {
                image = ImageIO.read(getClass().getResourceAsStream("/objects/door3.png"));
            } else if (gp.player.doorSprite == 4) {
                image = ImageIO.read(getClass().getResourceAsStream("/objects/door4.png"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

}







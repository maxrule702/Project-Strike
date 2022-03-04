package objects;

import entity.Player;
import main.GamePanel;
import org.ietf.jgss.GSSManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Door extends  SuperObject{
GamePanel gp;

    public Door(GamePanel gp) {
        this.gp = gp;
        name = "door";


        try {

            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
            utool.scaleImage(image,gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

}







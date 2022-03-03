package objects;

import entity.Player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Door extends  SuperObject{

    public Door() {
        name = "door";
        try {

            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));


        } catch (Exception e) {
            e.printStackTrace();
        }





        collision = true;
    }

}







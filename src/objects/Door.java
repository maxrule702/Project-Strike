package objects;

import javax.imageio.ImageIO;

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







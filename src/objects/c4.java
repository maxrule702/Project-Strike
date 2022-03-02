package objects;

import javax.imageio.ImageIO;

public class c4 extends  SuperObject{
    public c4() {
        name = "c4";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/c4.png"));


        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

}
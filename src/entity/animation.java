package entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class animation extends Entity {


    public void getDoorImage() {
        try {
            doorImage1 = ImageIO.read(getClass().getResourceAsStream("/objects/door1.png"));
            doorImage2 = ImageIO.read(getClass().getResourceAsStream("/objects/door2.png"));
            doorImage3 = ImageIO.read(getClass().getResourceAsStream("/objects/door3.png"));
            doorImage4 = ImageIO.read(getClass().getResourceAsStream("/objects/door4.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

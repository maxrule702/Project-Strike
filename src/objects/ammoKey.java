package objects;

import javax.imageio.ImageIO;

public class ammoKey extends SuperObject {
    public ammoKey() {

        name = "ammo";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/ammoBox.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



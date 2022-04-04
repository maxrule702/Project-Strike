package objects;

import entity.Entity;
import entity.Player;
import main.GamePanel;
import org.ietf.jgss.GSSManager;
import sound.Sound;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Door extends Entity {
    int doorCounter = 0;
    public Door(GamePanel gp) {
        super(gp);
        name = "door";
        getDoorImage(0);
        collision = true;
        isDoor = true;
        //
    }

    public void update(){
        Sound sound = new Sound();
        doorCounter++;
        if (doorCounter== 1){
            sound.setFile(7);
            sound.play();
        }
        if (doorCounter== 100){
            getDoorImage(1);
        }
        if (doorCounter== 155){
            getDoorImage(2);
            sound.setFile(1);
            sound.play();
        }



        if (doorCounter== 165){
            getDoorImage(3);
        }
        if (doorCounter== 175){
            getDoorImage(4);


        }
        if (doorCounter== 225){
            actionFinished = true;
        }

    }

    public void getDoorImage(int imageID){
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
    }

}








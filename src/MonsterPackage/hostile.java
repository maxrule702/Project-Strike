package MonsterPackage;

import entity.Entity;
import main.GamePanel;

import java.util.Random;

public class hostile extends Entity {

    public hostile(GamePanel gp) {
        super(gp);

        name = "combine";
        speed = 2;
        maxLife = 4;
        life = maxLife;
        getImage();

    }
    public  void getImage(){
        right1 = setup("combine",gp.tileSize,gp.tileSize);

    }

    public void setAction(){
        int actionLockCounter=0;
        actionLockCounter ++;


        if (actionLockCounter == 120){
            Random random = new Random();

            int i = random.nextInt(100)+1;
            if(i <= 25){
                direction = "up";
            }

            if (i > 25 && i <= 50){
                direction = "down";
            }

            if(i > 50 && i <= 75){
                direction = "left";
            }

            if(i > 75 && i <= 100){
                direction = "right";
            }
            actionLockCounter=0;

        }
    }
}

package main;

import objects.Door;
import objects.ammoKey;
import objects.c4;

public class assetSetter {
    GamePanel gp;
    public  assetSetter (GamePanel gp){
        this.gp = gp;
    }
    public  void setObject(){
        gp.obj[0] = new ammoKey();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new c4();
        gp.obj[1].worldX = 22 * gp.tileSize;
        gp.obj[1].worldY = 7 * gp.tileSize;

        gp.obj[2] = new Door();
        gp.obj[2].worldX = 21 * gp.tileSize;
        gp.obj[2].worldY = 7 * gp.tileSize;



    }
}

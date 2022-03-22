package main;

import MonsterPackage.hostile;
import objects.Door;
import objects.ammoKey;
import objects.c4;

public class assetSetter {
    GamePanel gp;
    public  assetSetter (GamePanel gp){
        this.gp = gp;
    }
    public  void setObject(){
        gp.obj[0] = new ammoKey(gp);
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new c4(gp);
        gp.obj[1].worldX = 22 * gp.tileSize;
        gp.obj[1].worldY = 7 * gp.tileSize;

        gp.obj[2] = new Door(gp);
        gp.obj[2].worldX = 21 * gp.tileSize;
        gp.obj[2].worldY = 17 * gp.tileSize;

        gp.obj[3] = new Door(gp);
        gp.obj[3].worldX = 22 * gp.tileSize;
        gp.obj[3].worldY = 17 * gp.tileSize;

        gp.obj[4] = new Door(gp);
        gp.obj[4].worldX = 23 * gp.tileSize;
        gp.obj[4].worldY = 17 * gp.tileSize;

    }

    public void setHostile(){
        gp.hostile[1]= new hostile(gp);
        gp.hostile[1].worldX = gp.tileSize *23;
        gp.hostile[1].worldY = gp.tileSize *20;



    }

}

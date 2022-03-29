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
//        gp.obj[0] = new ammoKey(gp);
//        gp.obj[0].worldX = 23 * gp.tileSize;
//        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new c4(gp);
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 12 * gp.tileSize;

        gp.obj[2] = new Door(gp);
        gp.obj[2].worldX = 31 * gp.tileSize;
        gp.obj[2].worldY = 5 * gp.tileSize;

        gp.obj[3] = new Door(gp);
        gp.obj[3].worldX = 32 * gp.tileSize;
        gp.obj[3].worldY = 5 * gp.tileSize;



    }

    public void setHostile(){
        gp.hostile[0]= new hostile(gp);
        gp.hostile[0].worldX = gp.tileSize *32;
        gp.hostile[0].worldY = gp.tileSize *4;


        gp.hostile[1]= new hostile(gp);
        gp.hostile[1].worldX = gp.tileSize *31;
        gp.hostile[1].worldY = gp.tileSize *4;


    }

}

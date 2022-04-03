package main;

import MonsterPackage.hostile;
import objects.*;

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
        gp.obj[1].worldX = 31 * gp.tileSize;
        gp.obj[1].worldY = 10 * gp.tileSize;

        gp.obj[2] = new Door3(gp);
        gp.obj[2].worldX = 31 * gp.tileSize;
        gp.obj[2].worldY = 11 * gp.tileSize;

        gp.obj[3] = new Door3(gp);
        gp.obj[3].worldX = 31 * gp.tileSize;
        gp.obj[3].worldY = 11 * gp.tileSize;

        gp.obj[4] = new Door2(gp);
        gp.obj[4].worldX = 31 * gp.tileSize;
        gp.obj[4].worldY = 11 * gp.tileSize;

        gp.obj[5] = new Door1(gp);
        gp.obj[5].worldX = 31 * gp.tileSize;
        gp.obj[5].worldY = 11 * gp.tileSize;

        gp.obj[6] = new Door(gp);
        gp.obj[6].worldX = 31 * gp.tileSize;
        gp.obj[6].worldY = 11 * gp.tileSize;



    }

    public void setHostile(){
        gp.hostile[0]= new hostile(gp);
        gp.hostile[0].worldX = gp.tileSize *31;
        gp.hostile[0].worldY = gp.tileSize *13;


        gp.hostile[1]= new hostile(gp);
        gp.hostile[1].worldX = gp.tileSize *32;
        gp.hostile[1].worldY = gp.tileSize *13;


    }

}

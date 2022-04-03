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

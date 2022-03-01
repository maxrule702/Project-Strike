package main;

import objects.OBJ_Key;

public class assetSetter {
    GamePanel gp;
    public  assetSetter (GamePanel gp){
        this.gp = gp;
    }
    public  void setObject(){
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 30 * gp.tileSize;
        gp.obj[1].worldY = 14 * gp.tileSize;


    }
}

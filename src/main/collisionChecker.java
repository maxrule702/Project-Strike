package main;

import entity.Entity;

public class collisionChecker {
    GamePanel gp;


    public collisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile (Entity entity){
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNumber[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNumber[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisonOn = true;
                }
                break;


            case "down":
                entityBottomRow = (entityBottomWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNumber[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisonOn = true;
                }
                break;


            case "left":

                entityLeftCol= (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNumber[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNumber[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisonOn = true;
                }

                break;

            case "right":

                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNumber[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNumber[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisonOn = true;
                }



                break;
        }
    }

public  int checkObject(Entity entity, boolean player) {
    //if playerChar hit object returns 999
    int index = 999;
    int i;
    for (i = 0; i < gp.obj.length; i++) {
        if (gp.obj[i] != null) {
            //get entitys solid area postion
            entity.solidArea.x = entity.worldX + entity.solidArea.x;
            entity.solidArea.y = entity.worldY + entity.solidArea.y;
            //gets the solid area postion
            gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
            gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

//BROKEN CODE STARTS HERE
          switch (entity.direction){
              case "up":
                  entity.solidArea.y -= entity.speed;
                  if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                      if(gp.obj[i].collision == true){
                          entity.collisonOn = true;
                      }
                      if(player == true){
                          index = i;
                      }


                  break;}

              case "down":
                  entity.solidArea.y += entity.speed;
                  if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                      if(gp.obj[i].collision == true){
                          entity.collisonOn = true;
                      }
                      if(player == true){
                          index = i;
                      }
                  break;}


              case "left":
                  entity.solidArea.x -= entity.speed;
                  if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                      if(gp.obj[i].collision == true){
                          entity.collisonOn = true;
                      }
                      if(player == true){
                          index = i;
                      }
                  break;}

              case "right":
                  entity.solidArea.x += entity.speed;
                  if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                      if(gp.obj[i].collision == true){
                          entity.collisonOn = true;
                      }
                      if(player == true){
                          index = i;
                      }
                      break;
                  }
          }
// ENDS HERE

            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
            gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
        }
    }
    return index;
}

    }



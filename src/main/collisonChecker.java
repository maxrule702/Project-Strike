package main;

import entity.Entity;

public class collisonChecker {
    GamePanel gp;

    public collisonChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile (Entity entity){
        int entityLeftWorldX = entity.worldX + entity.soildArea.x;
        int entityRightWorldX = entity.worldX + entity.soildArea.x + entity.soildArea.width;
        int entityTopWorldY = entity.worldY + entity.soildArea.y;
        int entityBottomWorldY = entity.worldY + entity.soildArea.y + entity.soildArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightcol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightcol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;

            case "down":
                break;

            case "left":
                break;

            case "right":
                break;
        }
    }












}


package objects;

import main.GamePanel;
import main.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
public BufferedImage image;
public int spriteCount;
public String name;
public boolean collision = false;
public int worldX, worldY;
public Rectangle solidArea = new Rectangle(0,0,32,32);
public int solidAreaDefaultX = 0;
public int solidAreaDefaultY = 0;
UtilityTool uTool = new UtilityTool();


public void draw(Graphics2D g2, GamePanel gp){

    int screenX = worldX - gp.player.worldX + gp.player.screenX;
    int screenY = worldY - gp.player.worldY + gp.player.screenY;

    //This allows for only the necessary tiles to be rendered
    if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
            && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
            && worldY+ gp.tileSize > gp.player.worldY - gp.player.screenY &&
            worldY - gp.tileSize< gp.player.worldY + gp.player.screenY){
        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);

    }
}



}

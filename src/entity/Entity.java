package entity;
import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX,worldY;
    public int speed;
    public GamePanel gp;
    public BufferedImage up1,down1,left1,right1,doorImage1,doorImage2,doorImage3,doorImage4;
    public BufferedImage attackUp1,attackRight1,attackDown1, attackLeft1, attackUp2,attackRight2, attackDown2, attackLeft2;
    public String direction = "down";
    public int actionLockCounter = 0;
 public boolean invincible = false;
 public int invincibleCounter = 0;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int type; // o = player, 1 = npc, 2 = hostile
   public boolean attacking = false;

    //CHARACTER HEALTH
    public int maxLife;
    public int life;

    public BufferedImage image,image1,image2;
    public String name;
    public boolean collision = false;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
        public void setAction(){}
    public void update(){

        setAction();
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkEntity(this,gp.hostile);
        boolean contactplayer = gp.cChecker.checkPlayer(this);
if (this.type ==2 && contactplayer == true){
    if (gp.player.invincible == false){
        gp.player.life -=1;
        gp.player.invincible = true;
    }
}

        if (collisionOn == false) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;

                case "down":
                    worldY += speed;
                    break;

                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;

            }
        }
    }



    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        //This allows for only the necessary tiles to be rendered
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
                && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
                && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

        }
        switch (direction) {
            case "up":
                image = up1;
                break;

            case "down":
                image = down1;
                break;

            case "left":
                image = left1;
                break;

            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
    }

    public BufferedImage setup(String imagePath,int width,int height) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;


        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, width, height);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }





}

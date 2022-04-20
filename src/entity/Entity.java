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
    public Rectangle attackArea = new Rectangle(0,0,0,0);
    public boolean alive = true;
    public boolean dying = false;
    int dyingcounter = 0;
    boolean hpbarOn = false;
    int hpBarCounter = 0;


    //CHARACTER HEALTH
    public int maxLife;
    public int life;

    public int level;
    public int attack;
    public int defense;
    public Entity currentWeapon;
    public Entity currentShield;
    public  int attackValue;
    public int defenseValue;


    public BufferedImage image,image1,image2;
    public String name;
    public boolean collision = false;

    public boolean triggered = false;
    public boolean actionFinished = false;
    public boolean isDoor = false;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
        public void setAction(){}

    public void damageReaction(){}

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


        if (invincible ==true){
            invincibleCounter++;
            if(invincibleCounter > 15){
                invincible =false;
                invincibleCounter =0;
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

        //hostile health bar
        if(type ==2 && (hpbarOn == true)) {
            hpBarCounter =0;
            double oneScale = (double)gp.tileSize/maxLife;
            double hpBarvalue = oneScale * life;


            g2.setColor(new Color(0,0,0));
            g2.fillRect(screenX-1,screenY-16,gp.tileSize+2,12);
            g2.setColor(new Color(255, 0, 0));
            g2.fillRect(screenX, screenY - 15, (int) hpBarvalue, 10);
            hpBarCounter ++;
            if (hpBarCounter ==600){
                hpBarCounter =0;
                hpbarOn = false;
            }
        }






        if (invincible == true) {
            changeAlpha(g2,0.3F);
            hpbarOn = true;

        }

        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);

        g2.setComposite((AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f)));

        if(dying == true){
            dyingAnimation(g2);
        }



    }










    public void dyingAnimation (Graphics2D g2){
        dyingcounter++;
 int i = 5;
        if(dyingcounter <= i*2){
            changeAlpha(g2,0f);
        }

        if(dyingcounter <= i*3){
            changeAlpha(g2,1);
        }

     if(dyingcounter <= i*4){
         changeAlpha(g2,0f);

    }

        if(dyingcounter <= i*5){
            changeAlpha(g2,1f);
        }

        if(dyingcounter <= i*6){
            changeAlpha(g2,0f);
        }


        if (dyingcounter > 30){
            dying = false;
            alive = false;
        }
    }


    public void changeAlpha (Graphics2D g2, float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alphaValue));
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

package entity;
import java.util.concurrent.TimeUnit;
import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import sound.Sound;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    int hasKey = 0;
    public int spriteCounter;
    public int spriteNum = 0;
    Sound sound = new Sound();
    public int switchTimer =0;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);

        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
        screenX = (gp.screenWidth / 2 - (gp.tileSize / 2));
        screenY = (int) (gp.screenHeight / 2 - (gp.tileSize / 2));
        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        attackArea.width = 36;
        attackArea.height = 36;


        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 31;
        worldY = gp.tileSize * 9;
        speed = 4;
        direction = "right";
        //player status
        maxLife = 6;
        life = maxLife;

    }


    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/playerChar/spriteUp.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/playerChar/spriteRight.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/playerChar/spriteDown.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/playerChar/spriteLeft.png"));


        } catch (Exception e) {
            e.printStackTrace();
        }
        up1 = setup("spriteUp");

        right1 = setup("spriteRight");

        down1 = setup("spriteDown");

        left1 = setup("spriteLeft");

    }

    public void getPlayerAttackImage() {
        attackUp1 = setup("/entity/spriteKnifeHoldUp1", gp.tileSize + 12, gp.tileSize + 12);
        attackRight1 = setup("/entity/spriteKnifeHoldRight1", gp.tileSize + 12, gp.tileSize + 12);
        attackDown1 = setup("/entity/spriteKnifeHoldDown1", gp.tileSize + 12, gp.tileSize + 12);
        attackLeft1 = setup("/entity/spriteKnifeHoldLeft1", gp.tileSize + 12, gp.tileSize + 12);

        attackUp2 = setup("/entity/spriteKnifeStabbingUp2", gp.tileSize + 12, gp.tileSize + 12);
        attackRight2 = setup("/entity/spriteKnifeStabbingRight2", gp.tileSize + 12, gp.tileSize + 12);
        attackDown2 = setup("/entity/spriteKnifeStabbingDown2", gp.tileSize + 12, gp.tileSize + 12);
        attackLeft2 = setup("/entity/spriteKnifeStabbingLeft2", gp.tileSize + 12, gp.tileSize + 12);

    }


    public BufferedImage setup(String imageName) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/playerChar/" + imageName + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public void update() {
        //movement


        if (attacking == true) {
            attacking();
        } else if (keyH.downPressed || keyH.upPressed || keyH.leftPressed || keyH.rightPressed || keyH.spacePressed) {
            if (keyH.upPressed == true) {
                direction = "up";
                attacking = false;
            } else if (keyH.downPressed == true) {
                direction = "down";
                attacking = false;

            } else if (keyH.leftPressed == true) {
                direction = "left";
                attacking = false;

            } else if (keyH.rightPressed == true) {
                direction = "right";
                attacking = false;
            } else if (keyH.spacePressed == true) {

                attacking = true;


            }


            // checking tile collision
            collisionOn = false;
            gp.cChecker.checkTile((this));

            // object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);


            //hostile collsion

            int hostileIndex = gp.cChecker.checkEntity(this, gp.hostile);
            contactHostile(hostileIndex);

            //check event
            gp.eHandler.checkEvent();

            //if collision is false then playerChar can move
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
        if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 30) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }


    public void attacking() {
        spriteCounter++;


        if (spriteCounter <= 5) {
            spriteNum = 1;
            sound.setFile(5);
            sound.play();

        }
        if (spriteCounter > 5 && spriteCounter <= 25) {
            spriteNum = 2;

            //saves current World X and world Y and solid area
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            //adjusts players world X /Y for the attackArea

            switch (direction) {
                case "up":
                    worldY -= attackArea.height;
                    break;
                case "down":
                    worldY += attackArea.height;
                    break;
                case "left":
                    worldX -= attackArea.width;
                    break;
                case "right":
                    worldX += attackArea.width;
                    break;
            }

            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            int hostileIndex = gp.cChecker.checkEntity(this, gp.hostile);
            damageHostile(hostileIndex);


            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;


        }
        if (spriteCounter > 25) {
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }

    }

    public boolean doorHit = false;

    public void pickUpObject(int i) {

        if (i != 999) {
            String objectName = gp.obj[i].name;


            switch (objectName) {
                case "ammo":
                    gp.playSE(2);
                    gp.obj[i] = null;
                    System.out.println("key:" + hasKey);
                    break;

                case "door":
                    if (hasKey > 0) {

                        doorHit = true;
                        counter++;
                        if(counter == 1){
                            gp.playSE(1);
                        }
                        gp.obj[i].triggered = true;
//
//                        if (doorHit == true) {
//                            switchTimer++;
//                            if (switchTimer == 5) {
//                                gp.obj[i] = null;
//
//                            }
//
//                            }
//                        }
//                    break;
//
//                case"Door2":
//                    if (doorHit == true) {
//                        switchTimer++;
//                        if (switchTimer == 10) {
//                            gp.obj[i] = null;
//
//                        }
                    }
                    break;



                case "c4":
                    gp.playSE(3);
                    hasKey++;
                    gp.obj[i] = null;
                    System.out.println("key:" + hasKey);
                    break;


            }
        }
    }


    public void contactHostile(int i) {
        if (i != 999) {

            if (invincible == false) {
                life -= 1;
                invincible = true;
            }
        }
    }


    public void damageHostile(int i) {
        if (i != 999) {
            if (gp.hostile[i].invincible == false) {
                gp.hostile[i].life -= 1;
                gp.hostile[i].invincible = true;


                if (gp.hostile[i].life <= 0) {
                    gp.hostile[i].dying = true;
                    sound.setFile(6);
                    sound.play();
                }
            }
        }
    }

    public int counter = 0;


    public void draw(Graphics2D g2) {
        int tempScreenX = screenX;
        int tempScreenY = screenY;

        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (attacking == true) {
                    if (spriteNum == 1) {
                        image = attackUp1;
                    }
                    if (spriteNum == 2) {
                        image = attackUp2;
                    }
                }

                if (attacking == false) {
                    image = up1;
                }
                break;

            case "down":
                if (attacking == true) {
                    if (spriteNum == 1) {
                        image = attackDown1;
                    }
                    if (spriteNum == 2) {
                        image = attackDown2;
                    }
                }

                if (attacking == false) {
                    image = down1;
                }


                break;

            case "left":
                if (attacking == true){
                    if(spriteNum ==1){image = attackLeft1;}
                    if(spriteNum ==2){image = attackLeft2;}
                }

                if (attacking == false){
                    image = left1;
                }
                break;

            case "right":
                if (attacking == true){
                    if(spriteNum ==1){image = attackRight1;}
                    if(spriteNum ==2){image = attackRight2;}
                }

                if (attacking == false){
                    image = right1;
                }
                break;
        }


        int x = screenX;
        int y = screenY;

        if (screenX > worldX) {
            x = worldX;
        }
        if (screenY > worldY) {
            y = worldY;
        }
        int rightOffset = gp.screenWidth - screenX;
        if (rightOffset > gp.worldWidth - worldX) {
            x = gp.screenWidth - (gp.worldWidth - worldX);
        }
        float bottomOffset = (gp.screenHeight - screenY);
        if (bottomOffset > gp.worldHeight - worldY) {
            y = (int) (gp.screenHeight - (gp.worldHeight - worldY));
        }

        int playcount = 0;

        if (invincible == true) {
            g2.setComposite((AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f)));
        }

        if (invincibleCounter == 15) {

            if (playcount == 0) {
                sound.setFile(4);
                sound.play();
                playcount++;
            }
        }




            g2.drawImage(image,tempScreenX,tempScreenY, null);
        //rest alpha
        g2.setComposite((AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1)));



        if (keyH.showDebugText == true) {

            g2.setColor(Color.red);
            g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width+15, solidArea.height+10);




            //Debug
            g2.setFont(new Font("Arial",Font.PLAIN,26));
            g2.drawString("damageCoolDown" + invincibleCounter,10,550);
        }
    }
}





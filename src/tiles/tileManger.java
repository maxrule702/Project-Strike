package tiles;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class tileManger {
    GamePanel gp;
   public tile [] tile;
   public int mapTileNumber[] [];


    public tileManger(GamePanel gp) {
        this.gp = gp;

        tile = new tile[12]; //tile different limit
        mapTileNumber = new int [gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/worldMap.txt");
    }

    public void getTileImage() {
        try{
//sets the images and collision status
            setup(0, "borderTile",true);
            setup(7, "wallTile",true);
            setup(5, "steelTile",true);
            setup(4, "kitchenTile",false);
            setup(3, "grassTile",false);
            setup(2, "dirtTile",false);
            setup(1, "carpetTile",false);
            setup(6, "lavaTile",true);
            setup(8, "waterTile",true);
            setup(9, "wood2Tile",false);
            setup(10, "woodTile",false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public void setup(int index,String imagePath,boolean collision){
    UtilityTool uTool = new UtilityTool();

    try{

     tile[index] = new tile();
     tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+ imagePath + ".png"));
     tile[index].image = uTool.scaleImage(tile[index].image,gp.tileSize,gp.tileSize);
     tile[index].collision = collision;




    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void loadMap (String filePath) {
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader((new InputStreamReader(is)));

            int col = 0;
            int row = 0;


            while (col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while (col < gp.maxWorldCol){
                    String numbers [] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;

                }


            }



        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }





    public void draw(Graphics2D g2){



        int worldCol = 0;
        int worldRow = 0;


        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNumber = mapTileNumber[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            //Camera stops moving at the edge
            if (gp.player.screenX > gp.player.worldX) {
                screenX = worldX;
            }
            if (gp.player.screenY > gp.player.worldY) {
                screenY = worldY;
            }
            int rightOffset = gp.screenWidth - gp.player.screenX;
            if(rightOffset > gp.worldWidth - gp.player.worldX) {
                screenX = gp.screenWidth - (gp.worldWidth - worldX);
            }
            float bottomOffset = gp.screenHeight - gp.player.screenY;
            if(bottomOffset > gp.worldHeight - gp.player.worldY) {
                screenY = (int) (gp.screenHeight - (gp.worldHeight - worldY));
            }

            //This allows for only the necessary tiles to be rendered
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
                    && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
                    && worldY+ gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize< gp.player.worldY + gp.player.screenY){
                g2.drawImage(tile[tileNumber].image,screenX,screenY,null);
            }
            else if (gp.player.screenX > gp.player.worldX ||
            gp.player.screenY > gp.player.worldY ||
                    rightOffset > gp.worldWidth - gp.player.worldX ||
                    bottomOffset > gp.worldHeight - gp.player.worldY) {
                g2.drawImage(tile[tileNumber].image,screenX,screenY,null);
            }



            worldCol++;


            if (worldCol == gp.maxWorldCol){
                worldCol = 0;

                worldRow++;

            }
        }


    }
}

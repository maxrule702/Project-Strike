package tiles;

import main.GamePanel;

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

        tile = new tile[12]; //tile different limt
        mapTileNumber = new int [gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/worldMap.txt");
    }

    public void getTileImage() {
        try{

            tile[0] = new tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/backupTile.png"));


            tile[1] = new tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wallTile.png"));
            tile[1].collision = true;

            tile[2] = new tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/steelTile.png"));
            tile[2].collision = true;

            tile[3] = new tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/kitchenTile.png"));

            tile[4] = new tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassTile.png"));

            tile[5] = new tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirtTile.png"));

            tile[6] = new tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/carpetTile.png"));

            tile[7] = new tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lavaTile.png"));
            tile[7].collision = true;



            tile[8] = new tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/waterTile.png"));
            tile[8].collision = true;


            tile[9] = new tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood2Tile.png"));

            tile[10] = new tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/woodTile.png"));

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

            //This allows for only the necessary tiles to be rendered
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
                    && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
                    && worldY+ gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize< gp.player.worldY + gp.player.screenY){
                g2.drawImage(tile[tileNumber].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
            }



            worldCol++;


            if (worldCol == gp.maxWorldCol){
                worldCol = 0;

                worldRow++;

            }
        }


    }
}

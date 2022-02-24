package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class tileManger {
    GamePanel gp;
    tile [] tile;
    int mapTileNumber[] [];


    public tileManger(GamePanel gp) {
        this.gp = gp;

        tile = new tile[10]; //tile different limt
        mapTileNumber = new int [gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/worldMap.txt");
    }

    public void getTileImage() {
        try{

            tile[0] = new tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/woodTile.png"));

            tile[1] = new tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wallTile.png"));

            tile[2] = new tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/steelTile.png"));

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

//        g2.drawImage(tile[0].image,0,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tile[1].image,60,0,gp.tileSize,gp.tileSize,null);

        int worldCol = 0;
        int worldRow = 0;


        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNumber = mapTileNumber[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            g2.drawImage(tile[tileNumber].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
            worldCol++;


            if (worldCol == gp.maxWorldCol){
                worldCol = 0;

                worldRow++;

            }
        }


    }
}

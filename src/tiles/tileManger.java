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
        getTileImage();
        loadMap();
        mapTileNumber = new int [(int) gp.maxScreenCol][(int) gp.maxScreenRow];

    }

    public void getTileImage() {
        try{

            tile[0] = new tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/woodTile.png"));

            tile[1] = new tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wallTile.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void loadMap () {
        try{
            InputStream is = getClass().getResourceAsStream("/mapdata.txt");
            BufferedReader br = new BufferedReader((new InputStreamReader(is)));

            int col = 0;
            int row = 0;


            while (col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();

                while (col < gp.maxScreenCol){
                    String numbers [] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = num;
                    col++;
                    if (col == gp.maxScreenCol) {
                        col = 0;
                        row++;

                    }
                }
                br.close();

            }



        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }





    public void draw(Graphics2D g2){

//        g2.drawImage(tile[0].image,0,0,gp.tileSize,gp.tileSize,null);
//        g2.drawImage(tile[1].image,60,0,gp.tileSize,gp.tileSize,null);

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow){
            int tileNumber = mapTileNumber[col][row];

            g2.drawImage(tile[tileNumber].image,x,y,gp.tileSize,gp.tileSize,null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }


    }
}

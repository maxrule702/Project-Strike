package main;

import java.awt.*;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;

    Font arial_40, arial_80B;
    //BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font ("Arial", Font.PLAIN, 40);
        arial_80B = new Font ("Arial", Font.BOLD, 80);
        //OBJ Key key = new OBJ_Key(gp);
        //keyImage = key.image;
    }
    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }
    public void draw(Graphics g2) {

    }
}

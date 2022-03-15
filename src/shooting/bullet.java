package shooting;

import java.awt.*;

public class bullet extends GameObjectShoot {


    private Handler handler;

    public bullet(int x, int y, ID id, Handler handler,int mouseX, int mouseY) {
        super(x, y, id);
        this.handler = this.handler;
        velx = (mouseX - x) /10;
        vely = (mouseY - y) /10;

    }

    public void tick() {
 x+= velx;
 y+= vely;
    }


    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x,y,8,8);
    }


    public Rectangle getBounds() {

        return new Rectangle(x,y,8,8);


    }
}

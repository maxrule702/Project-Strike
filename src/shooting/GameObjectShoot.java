package shooting;

import java.awt.Graphics;

import java.awt.Rectangle;

public abstract class GameObjectShoot {

    protected int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getVelx() {
        return velx;
    }

    public void setVelx(float velx) {
        this.velx = velx;
    }

    public float getVely() {
        return vely;
    }

    public void setVely(float vely) {
        this.vely = vely;
    }

    protected int y;
    protected float velx = 0, vely = 0;
    protected  ID id;

    public GameObjectShoot(int x, int y, ID id) {
        this.id = id;
        this.x = x;
        this.y = y;

    }

    public abstract void tick ();
    public abstract void render (Graphics g);
    public abstract Rectangle getBounds ();

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }





}

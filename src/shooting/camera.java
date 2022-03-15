package shooting;

public class camera {
    private float x,y;

    public camera(float x,float y){
        this.x = x;
        this.y = y;
    }

    public void tick(GameObjectShoot object){
        x += ((object.getX()-x)-1000/2) * 0.05f;
        y += ((object.getX()-y)-563/2) * 0.05f;


        if(x<= 0) x=0;
        if(x>= 1032) x =1032;
        if(y<=0) y=0;
        if(x>= 563+48) y = 563+48;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}

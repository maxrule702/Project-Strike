package com.gaming;

public class Camera {

    private float x, y;

    public Camera(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void tick(GameObject object){
        x += ((object.getX() - x) - 1000/2) * 0.05f;
        y += ((Object.getY() - y) - 563/2) *0.05f;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    } //I'm in pain, have we even got an object anywhere? Help -Matei
}

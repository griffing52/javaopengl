package com.galimi.lwjgl.math;

public class Vec {

    protected float x,y;

    public Vec(float x, float y) {
        this.x = x;
        this.y = y;
    }

    
    public Vec add(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vec add(Vec a) {
        this.x += a.getX();
        this.y += a.getY();
        return this;
    }
    
    public Vec sub(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vec sub(Vec a) {
        this.x -= a.getX();
        this.y -= a.getY();
        return this;
    }
    
    public Vec mult(float o) {
        this.x *= o;
        this.y *= o;
        return this;
    }
    
    public Vec set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }
    
    public Vec set(Vec a) {
        this.x = a.getX();
        this.y = a.getY();
        return this;
    }

    public Vec normalize() {
        float offset = 1/(float)Math.sqrt(x*x+y*y);
        x*=offset;
        y*=offset;
        return this;
    }

    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }

    public boolean equals(Vec v) {
        return x == v.getX() && y == v.getY();
    }
}

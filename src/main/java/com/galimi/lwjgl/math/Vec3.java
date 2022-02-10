package com.galimi.lwjgl.math;

public class Vec3 extends Vec {
    protected float z;
    
    public Vec3(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }
    
    public Vec3 add(float x, float y, float z) {
        super.add(x, y);
        this.z += z;
        return this;
    }

    public Vec3 add(Vec3 a) {
        super.add(a);
        this.z += z;
        return this;
    }

    public Vec3 sub(float x, float y, float z) {
        super.sub(x, y);
        this.z -= z;
        return this;
    }

    public Vec3 sub(Vec3 a) {
        super.sub(a);
        this.z -= z;
        return this;
    }

    public Vec3 mult(float o) {
        super.mult(o);
        this.z *= 0;
        return this;
    }

    public Vec3 set(float x, float y, float z) {
        super.set(x, y);
        this.z = z;
        return this;
    }

    public Vec3 rotateX(float theta) {
        float temp = y;
        y = (float) (temp*Math.cos(theta) - z*Math.sin(theta));
        z = (float) (temp*Math.sin(theta) + z*Math.cos(theta));
        return this;
    }

    public Vec3 rotateY(float theta) {
        float temp = x;
        x = (float) (temp*Math.cos(theta)-z*Math.sin(theta));
        z = (float) (-temp*Math.sin(theta)+z*Math.cos(theta));
        return this;
    }

    public Vec3 rotateZ(float theta) {
        float temp = x;
        x = (float) (temp*Math.cos(theta)-y*Math.sin(theta));
        y = (float) (temp*Math.sin(theta)+y*Math.cos(theta));
        return this;
    }

    public Vec3 normalize() {
        double offset = 1/Math.sqrt(x*x+y*y+z*z);
        x *= offset;
        y *= offset;
        z *= offset;
        return this;
    }

    public float getZ() {
        return z;
    }

    public Vec3 copy() {
        return new Vec3(x, y, z);
    }

    public String toString() {
        return new StringBuffer().append("(").append(x).append(", ").append(y).append(", ").append(z).append(")").toString();
    }
}

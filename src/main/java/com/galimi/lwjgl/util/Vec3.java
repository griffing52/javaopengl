package com.galimi.lwjgl.util;

public class Vec3 extends Vec {
    protected float z;
    
    public Vec3(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }
    
    /**
     * Add the given x, y, and z values to the x, y, and z values of this vector
     * 
     * @param x The x-coordinate of the vector.
     * @param y The y-coordinate of the vector.
     * @param z The z coordinate of the vector.
     * @return Nothing.
     */
    public Vec3 add(float x, float y, float z) {
        super.add(x, y);
        this.z += z;
        return this;
    }

    public Vec3 add(Vec3 a) {
        super.add(a);
        this.z += a.getZ();
        return this;
    }

    public Vec3 sub(float x, float y, float z) {
        super.sub(x, y);
        this.z -= z;
        return this;
    }

    public Vec3 sub(Vec3 a) {
        super.sub(a);
        this.z -= a.getZ();
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

    /**
     * rotates vector around x-axis clockwise
     * @param theta radian rotation clockwise
     * @return this
     */
    public Vec3 rotateX(float theta) {
        float temp = y;
        y = (float) (temp*Math.cos(theta) - z*Math.sin(theta));
        z = (float) (temp*Math.sin(theta) + z*Math.cos(theta));
        return this;
    }

    /**
     * rotates vector around y-axis clockwise
     * @param theta radian rotation clockwise
     * @return this
     */
    public Vec3 rotateY(float theta) {
        float temp = x;
        x = (float) (temp*Math.cos(theta)+z*Math.sin(theta));
        z = (float) (-temp*Math.sin(theta)+z*Math.cos(theta));
        return this;
    }

    /**
     * rotates vector around z-axis clockwise
     * @param theta radian rotation clockwise
     * @return this
     */
    public Vec3 rotateZ(float theta) {
        float temp = x;
        x = (float) (temp*Math.cos(theta)-y*Math.sin(theta));
        y = (float) (temp*Math.sin(theta)+y*Math.cos(theta));
        return this;
    }

    /**
     * Normalize the vector
     * 
     * @return Nothing.
     */
    public Vec3 normalize() {
        double offset = 1/Math.sqrt(x*x+y*y+z*z);
        x *= offset;
        y *= offset;
        z *= offset;
        return this;
    }

    /**
     * Returns the z component of the vector
     * 
     * @return The z value.
     */
    public float getZ() {
        return z;
    }

    /**
     * Return a new Vec3 object with the same values as this Vec3
     * 
     * @return A new Vec3 object.
     */
    public Vec3 copy() {
        return new Vec3(x, y, z);
    }

    public String toString() {
        return new StringBuffer().append("(").append(x).append(", ").append(y).append(", ").append(z).append(")").toString();
    }

    public boolean equals(Vec3 vec) {
        return super.equals(vec) && z == vec.getZ();
    }
}

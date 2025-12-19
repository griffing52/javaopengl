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
     * @return this
     */
    public Vec3 add(float x, float y, float z) {
        super.add(x, y);
        this.z += z;
        return this;
    }

    /**
     * Adds given vector componenets to this vector
     * @param a vector to add
     * @return this
     */
    public Vec3 add(Vec3 a) {
        super.add(a);
        this.z += a.getZ();
        return this;
    }

    /**
     * It subtracts the given x, y, and z values from the x, y, and z values of the vector.
     * 
     * @param x The x coordinate of the vector to subtract from this vector.
     * @param y The y coordinate of the vector.
     * @param z The z coordinate of the vector.
     * @return this
     */
    public Vec3 sub(float x, float y, float z) {
        super.sub(x, y);
        this.z -= z;
        return this;
    }


    /**
     * It subtracts this vectors components from the components of the given vector.
     * 
     * @param a The vector to subtract from this vector.
     * @return this
     */
    public Vec3 sub(Vec3 a) {
        super.sub(a);
        this.z -= a.getZ();
        return this;
    }

    /**
     * Multiply the vector by a scalar
     * 
     * @param o The scalar to multiply the vector by.
     * @return this
     */
    public Vec3 mult(float o) {
        super.mult(o);
        this.z *= o;
        return this;
    }

    /**
     * It sets the x, y, and z values of the vector.
     * 
     * @param x The x-coordinate of the vector.
     * @param y The y-coordinate of the vector.
     * @param z The z coordinate of the vector.
     * @return this
     */
    public Vec3 set(float x, float y, float z) {
        super.set(x, y);
        this.z = z;
        return this;
    }

    /**
     * It sets the x, y, and z values of the vector.
     * 
     * @param x The x-coordinate of the vector.
     * @param y The y-coordinate of the vector.
     * @param z The z coordinate of the vector.
     * @return this
     */
    public Vec3 set(Vec3 a) {
        super.set(a);
        this.z = a.getZ();
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
     * @return this
     */
    public Vec3 normalize() {
        return setMag(1);
    }

    public Vec3 setMag(float a) {
        double offset = a/getMag();
        x *= offset;
        y *= offset;
        z *= offset;
        return this;
    }

    public Vec3 limit(float a) {
        if (getMag() > a) setMag(a);
        return this;
    }

    public Vec3 limitX(float a) {
        x = Math.max(-a, Math.min(a, x));
        return this;
    }

    public Vec3 limitZ(float a) {
        z = Math.max(-a, Math.min(a, z));
        return this;
    }

    public double getMag() {
        return Math.sqrt(x*x+y*y+z*z);
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

    /**
     * Return a new Vec3 that is the sum of the two Vec3s
     * 
     * @param a The first vector.
     * @param b The vector to add to the current vector.
     * @return A new Vec3 object.
     */
    public static Vec3 add(Vec3 a, Vec3 b) {
        return a.copy().add(b);
    }

    /**
     * `sub` subtracts the second vector from the first vector
     * 
     * @param a The first vector.
     * @param b The vector to subtract from a.
     * @return A new Vec3 object.
     */
    public static Vec3 sub(Vec3 a, Vec3 b) {
        return a.copy().sub(b);
    }

    /**
     * Multiply a vector by a scalar
     * 
     * @param a The vector to be multiplied.
     * @param o The scalar to multiply the vector by.
     * @return A new Vec3 object.
     */
    public static Vec3 mult(Vec3 a, float o) {
        return a.copy().mult(o);
    }

    public String toString() {
        return new StringBuffer().append("(").append(x).append(", ").append(y).append(", ").append(z).append(")").toString();
    }

    /**
     * Check if this vector is equal to another vector.
     * 
     * @param vec The vector to compare to.
     * @return true if equal
     */
    public boolean equals(Vec3 vec) {
        return super.equals(vec) && z == vec.getZ();
    }
}

package com.galimi.lwjgl.util;

public class Vec {

    protected float x,y;

    public Vec(float x, float y) {
        this.x = x;
        this.y = y;
    }

    
    /**
     * Add the given x and y to the x and y of this vector
     * 
     * @param x The value to add to the x component of the vector.
     * @param y The value to add to the y coordinate.
     * @return This method returns a reference to the object itself.
     */
    public Vec add(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    /**
     * Add the x and y components of the given vector to the x and y components of this vector
     * 
     * @param a The vector to add to this vector.
     * @return This method returns a reference to the object itself.
     */
    public Vec add(Vec a) {
        this.x += a.getX();
        this.y += a.getY();
        return this;
    }
    
    /**
     * Subtracts the given x and y from the x and y of this vector
     * 
     * @param x The x coordinate of the vector to subtract from this vector.
     * @param y The y coordinate of the vector to subtract from this vector.
     * @return This is a void method, so it returns nothing.
     */
    public Vec sub(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    /**
     * Subtracts the x and y components of the given vector from the x and y components of this vector
     * 
     * @param a The vector to subtract from this vector.
     * @return This method returns a reference to the object itself.
     */
    public Vec sub(Vec a) {
        this.x -= a.getX();
        this.y -= a.getY();
        return this;
    }
    
    /**
     * Multiply the vector by a scalar
     * 
     * @param o The number to multiply the vector by.
     * @return Nothing.
     */
    public Vec mult(float o) {
        this.x *= o;
        this.y *= o;
        return this;
    }
    
    /**
     * It sets the x and y values of the vector.
     * 
     * @param x The x coordinate of the vector.
     * @param y The y coordinate of the vector.
     * @return Nothing.
     */
    public Vec set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }
    
    /**
     * It sets the x and y values of the vector to the x and y values of the vector a.
     * 
     * @param a The vector to be copied.
     * @return Nothing.
     */
    public Vec set(Vec a) {
        this.x = a.getX();
        this.y = a.getY();
        return this;
    }

    /**
     * Normalize the vector
     * 
     * @return Nothing.
     */
    public Vec normalize() {
        float offset = 1/(float)Math.sqrt(x*x+y*y);
        x*=offset;
        y*=offset;
        return this;
    }

    /**
     * Return the value of the x variable
     * 
     * @return The value of the instance variable x.
     */
    public float getX() {
        return x;
    }
    
    /**
     * Returns the y-coordinate of the point
     * 
     * @return The y-coordinate of the point.
     */
    public float getY() {
        return y;
    }

    /**
     * Return true if the x and y coordinates of this vector are the same as the x and y coordinates of
     * the given vector.
     * 
     * @param v the vector to compare to this vector.
     * @return The result of the expression `x == v.getX() && y == v.getY()`.
     */
    public boolean equals(Vec v) {
        return x == v.getX() && y == v.getY();
    }
}

package com.galimi.lwjgl.shapes;

import com.galimi.lwjgl.util.Vec3;

public interface Collidable {
    /**
     * Returns true if the given point is inside the Collidable Object
     * 
     * @param point The point to test for intersection with.
     * @return A boolean value.
     */
    public boolean intersects(Vec3 point);
    public Vec3[] boundingBox();
}

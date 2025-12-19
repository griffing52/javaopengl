package com.galimi.lwjgl.game;

import com.galimi.lwjgl.entities.Vehicle;
import com.galimi.lwjgl.shapes.Box;
import com.galimi.lwjgl.shapes.Collidable;
import com.galimi.lwjgl.shapes.Drawable;
import com.galimi.lwjgl.util.Vec3;

public class Player extends Vehicle implements Drawable, Collidable {
    private Box body;
    float width = 30, height = 65, depth = width/30;
    Vec3 gravity = new Vec3(0, -2, 0);

    public Player(float x, float y, float z) {
        super(x, y, z);
        body = new Box(x, y+height, z, width, height, depth);
        body.setColors(new float[][]{{1f, 1f, 0}, 
                                    {1f, 0f, 0}, 
                                    {0.87f, 0.6f, 0}, 
                                    {0.87f, 0.6f, 0}, 
                                    {0.87f, 0.6f, 0}, 
                                    {0.87f, 0.6f, 0}});
    }

    public boolean intersects(Vec3 point)  {
        System.out.println(body.intersects(point));
        return body.intersects(point);
    }
    public Vec3[] boundingBox() {
        return body.boundingBox();
    }

    public void repell() {
        vel.mult(-1);
    }

    @Override
    public void update() {
        vel.add(acc);
        // vel.limit(4); 
        vel.limitX(8);
        vel.limitZ(0.4f);
        add(vel);
        acc.mult(0);
        // body.set(this); // set mesh position to current position, bottom-center
        body.set(this.copy().add(0, height, 0)); // set mesh position to current position, bottom-center
        // applyForce(gravity);
    }

    @Override
    public void draw() {
        body.draw();
    }

    @Override
    public void draw(Runnable r) {
        body.draw(r);
    }
}

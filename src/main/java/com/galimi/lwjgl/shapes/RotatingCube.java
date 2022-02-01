package com.galimi.lwjgl.shapes;

import static org.lwjgl.opengl.GL11.*;

public class RotatingCube extends Cube {
    private float speed, rotation = 0;
    private float _x, _y, _z;
    private double random;

    public RotatingCube(int x, int y, int z, int s, float speed) {
        super(x, y, z, s);
        this.speed = speed;
        _x = x;
        _y = y;
        _z = z;
        random = Math.random()*0.5;
    }

    public void draw() {
        super.draw(() -> {
            glRotatef(rotation, 2, 3, 1);
            // glRotatef(20, 1, 0, 0);
            x = _x + (float) Math.sin(rotation*0.014)*100;
            y = _y + (float) Math.sin(rotation*0.023)*100;
            z = _z + (float) Math.sin(rotation*0.004)*100;
        });
        rotation += speed;
    }
}

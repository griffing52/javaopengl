package com.galimi.lwjgl.shapes;

import static org.lwjgl.opengl.GL11.*;

public class RotatingCube extends Cube {
    private float speed, rotation = 0;

    public RotatingCube(int x, int y, int z, int s, float speed) {
        super(x, y, z, s);
        this.speed = speed;
    }

    public void draw() {
        super.draw(() -> {
            // glRotatef(rotation, 1, 1, 1);
            // glTranslatef(1, 1, 1);
            // z = (float) Math.sin(rotation)*50;
            glRotatef(rotation, 1, 1, 1);
        });
        rotation += speed;
    }
}

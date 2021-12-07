package com.galimi.lwjgl.shapes;

import static org.lwjgl.opengl.GL11.*;

public class RotatingSquare extends Square {
    private float speed, rotation = 0;

    public RotatingSquare(int x, int y, int s, float speed) {
        super(x, y, s);
        this.speed = speed;
    }

    public void draw() {
        super.draw(() -> glRotatef(rotation, 0, 0, 1));
        rotation += speed;
    }
}
package com.galimi.lwjgl.shapes;

import static org.lwjgl.opengl.GL11.*;

import com.galimi.lwjgl.util.NumUtil;

public class RotatingCube extends Cube {
    private float speed, rotation = 0;
    private float _x, _y, _z;
    private double a, b, c;

    public RotatingCube(int x, int y, int z, int s, float speed) {
        super(x, y, z, s);
        this.speed = speed;
        _x = x;
        _y = y;
        _z = z;
        // a = NumUtil.randomFloat(0.8, 1.2);
        // b = NumUtil.randomFloat(0.8, 1.2);
        // c = NumUtil.randomFloat(0.8, 1.2);
        a = 1;
        b = 1;
        c = 1;
    }

    public void draw() {
        super.draw(() -> {
            // glRotatef(rotation, 1, 0, 1);
            // glRotatef(rotation, 2, 3, 1);
            // glRotatef(20, 1, 0, 0);
            // x = _x + (float) Math.sin(rotation*0.014*a)*100;
            // y = _y + (float) Math.sin(rotation*0.023*b)*100;
            // z = _z + (float) Math.sin(rotation*0.004*c)*40;
        });
        rotation += speed;
    }
}

package com.galimi.lwjgl.game;

import com.galimi.lwjgl.math.Vec3;
import com.galimi.lwjgl.shapes.Box;
import com.galimi.lwjgl.shapes.Drawable;

public class Player extends Vec3 implements Drawable {
    private Box body;

    public Player(float x, float y, float z) {
        super(x, y, z);
        float width = 30, height = 90;
        body = new Box(x, y+height*0.5f, z, width, height, width/30);
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

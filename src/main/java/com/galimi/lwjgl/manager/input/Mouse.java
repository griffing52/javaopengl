package com.galimi.lwjgl.manager.input;

import com.galimi.lwjgl.manager.Camera;
import com.galimi.lwjgl.util.Vec;

public abstract class Mouse {
    private Vec pos, prev;
    private float sensitivity = 0.5f;

    public Mouse() {
        pos = new Vec(0, 0);
        prev = new Vec(0, 0);
    }

    public void update(double x, double y) {
        prev.set(pos);
        pos.set((float) x, (float) y);
    }

    public int getdx() {
        return (int) (pos.getX() - prev.getX());
    }
    
    public int getdy() {
        return (int) (pos.getY() - prev.getY());
    }

    public int getX() {
        return (int) pos.getX();
    }

    public int getY() {
        return (int) pos.getY();
    }

    public float getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(float sensitivity) {
        this.sensitivity = sensitivity;
    }

    public abstract void callback(Camera cam);
}

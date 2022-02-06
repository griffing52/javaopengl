package com.galimi.lwjgl.manager.input;

public class Key {
    private final int code;
    private final Runnable r;
    private boolean pressed = false;

    public Key(int code, Runnable r) {
        this.code = code;
        this.r = r;
    }

    public void press(boolean p) {
        pressed = p;
    }

    public void update() {
        if (pressed) r.run();
    }

    public int getCode() {
        return code;
    }
}

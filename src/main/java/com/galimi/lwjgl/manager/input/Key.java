package com.galimi.lwjgl.manager.input;

public class Key {
    private final int code;
    private final KeyCallback r;
    private boolean pressed = false;

    public Key(int code, KeyCallback r) {
        this.code = code;
        this.r = r;
    }

    public void press(boolean p) {
        pressed = p;
    }

    public void update(long window) {
        if (pressed) r.run(window);
    }

    public int getCode() {
        return code;
    }
}

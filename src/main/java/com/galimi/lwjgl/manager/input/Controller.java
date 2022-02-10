package com.galimi.lwjgl.manager.input;

import static org.lwjgl.glfw.GLFW.*;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Key> keys = new ArrayList<Key>();
    private long w;

    public void addKeys(Key... ks) {
        for (Key k: ks) {
            keys.add(k);
        }
    }

    public void setWindow(long window) {
        w = window;
    }

    public void callback(long w, int key, int scancode, int action, int mods) {
        for (Key k: keys) {
            if (key == k.getCode() && action == GLFW_PRESS) k.press(true);
            if (key == k.getCode() && action == GLFW_RELEASE) k.press(false);
        }
    }

    public void update() {
        for (Key k: keys) {
            k.update(w);
        }
    }
}

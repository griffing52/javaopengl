package com.galimi.lwjgl;

import com.galimi.lwjgl.manager.Camera;
import com.galimi.lwjgl.manager.Graphics;
import com.galimi.lwjgl.manager.input.Controller;
import com.galimi.lwjgl.manager.input.Key;
import com.galimi.lwjgl.shapes.*;
import com.galimi.lwjgl.util.NumUtil;

import static org.lwjgl.glfw.GLFW.*;

public class App {
    private static Camera cam;
    private static Graphics g;
    private static Controller c;

    public static void main(String[] args) {
        int width = 1920; // 800
        int height = 1080; // 600

        RotatingCube[] rtCubes = new RotatingCube[40];
        fillCubeArray(rtCubes, width, height);
        
        c = new Controller();
        cam = new Camera(0, 0, 0, 45);
        g = new Graphics(cam, c);
        setController(c);
        
        g.add(rtCubes);
        g.run(width, height, 45.0f);
    }

    private static void setController(Controller c) {
        float fSpeed = 0.4f;
        float hSpeed = 4;

        c.addKeys(
            new Key(GLFW_KEY_A, () -> cam.move(hSpeed, 0, 0)),
            new Key(GLFW_KEY_D, () -> cam.move(-hSpeed, 0, 0)),
            new Key(GLFW_KEY_W, () -> cam.move(0, 0, fSpeed)),
            new Key(GLFW_KEY_S, () -> cam.move(0, 0, -fSpeed))
        );
    }

    private static void fillCubeArray(RotatingCube[] arr, int width, int height) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new RotatingCube(
                NumUtil.randomInt(width*0.2-width*0.5, width*0.8-width*0.5), 
                NumUtil.randomInt(height*0.2-height*0.5, height*0.8-height*0.5), 
                NumUtil.randomInt(50, 100), 
                50, 
                NumUtil.randomFloat(0.4, 2));
        }
    }
}
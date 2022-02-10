package com.galimi.lwjgl;

import com.galimi.lwjgl.manager.Camera;
import com.galimi.lwjgl.manager.Graphics;
import com.galimi.lwjgl.manager.input.Mouse;
import com.galimi.lwjgl.math.Vec;
import com.galimi.lwjgl.manager.input.Controller;
import com.galimi.lwjgl.manager.input.Key;
import com.galimi.lwjgl.shapes.*;
import com.galimi.lwjgl.util.NumUtil;

import static org.lwjgl.glfw.GLFW.*;

public class App {
    private static Camera cam;
    private static Graphics g;
    private static Controller c;
    private static Mouse m;

    public static void main(String[] args) {
        int width = 1920; // 800
        int height = 1080; // 600

        RotatingCube[] rtCubes = new RotatingCube[40];
        fillCubeArray(rtCubes, width, height);
        
        c = new Controller();
        m = new Mouse() {
            public void callback(Camera cam) {
                cam.getRot().rotateX(getdx()*getSensitivity()).rotateY(getdy()*getSensitivity());
                cam.lookAt();
            }
        };
        cam = new Camera(0, 0, 0, 45);
        g = new Graphics(cam, c, m);
        setController(c);
        
        g.add(rtCubes);
        g.run(width, height, 45.0f);
    }

    private static void setController(Controller c) {
        Vec speed = new Vec(1.1f, 12);

        c.addKeys(
            new Key(GLFW_KEY_A, (window) -> cam.move(speed.getY(), 0, 0)),
            new Key(GLFW_KEY_D, (window) -> cam.move(-speed.getY(), 0, 0)),
            new Key(GLFW_KEY_W, (window) -> cam.move(0, 0, speed.getX())),
            new Key(GLFW_KEY_S, (window) -> cam.move(0, 0, -speed.getX())),
            new Key(GLFW_KEY_ESCAPE, (window) -> glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_NORMAL))
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
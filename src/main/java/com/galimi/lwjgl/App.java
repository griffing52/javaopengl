package com.galimi.lwjgl;

import com.galimi.lwjgl.game.Player;
import com.galimi.lwjgl.manager.Camera;
import com.galimi.lwjgl.manager.Graphics;
import com.galimi.lwjgl.manager.input.Mouse;
import com.galimi.lwjgl.manager.input.Controller;
import com.galimi.lwjgl.manager.input.Key;
import com.galimi.lwjgl.shapes.*;
import com.galimi.lwjgl.util.Vec;

import static org.lwjgl.glfw.GLFW.*;

public class App {
    private static Camera cam;
    private static Player player;
    private static Graphics g;
    private static Controller c;
    private static Mouse m;

    public static void main(String[] args) {
        int width = 1920; // 800
        int height = 1080; // 600

        
        c = new Controller();
        m = new Mouse() {
            public void callback(Camera cam) {
                cam.getRot().rotateX(getdx()*getSensitivity()).rotateY(getdy()*getSensitivity());
            }
        };
        cam = new Camera(0, 0, 0, 45);
        g = new Graphics(cam, c, m);
        setController(c);

        // Game Objects
        player = new Player(0, -height*0.3f, -40);
        
        g.add(new Box(0, -height*0.3f, -25, 4000, 20, 100));
        // player.applyForce();
        g.add(player);
        g.run(width, height, 45.0f);
    }

    /**
     * `setController` sets up the keys that will be used to control the camera
     * 
     * @param c The controller that will be used to control the camera.
     */
    private static void setController(Controller c) {
        Vec speed = new Vec(1.1f, 12);

        c.addKeys(
            new Key(GLFW_KEY_A, (window) -> cam.move(speed.getY(), 0, 0)),
            new Key(GLFW_KEY_D, (window) -> cam.move(-speed.getY(), 0, 0)),
            new Key(GLFW_KEY_W, (window) -> cam.move(0, 0, speed.getX())),
            new Key(GLFW_KEY_S, (window) -> cam.move(0, 0, -speed.getX())),
            new Key(GLFW_KEY_ESCAPE, (window) -> glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_NORMAL)),
            new Key(GLFW_KEY_E, (window) -> cam.addRot(1)), // TODO remove temp
            new Key(GLFW_KEY_Q, (window) -> cam.addRot(-1)), // TODO remove temp
            // new Key(GLFW_Up, (window) -> cam.move(0, 0, speed.getX())), // TODO remove temp
            new Key(GLFW_KEY_Q, (window) -> cam.addRot(-1)) // TODO remove temp
            );
    }
}
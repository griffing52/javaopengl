package com.galimi.lwjgl;

import com.galimi.lwjgl.game.Player;
import com.galimi.lwjgl.manager.Camera;
import com.galimi.lwjgl.manager.Graphics;
import com.galimi.lwjgl.manager.input.Mouse;
import com.galimi.lwjgl.manager.input.Controller;
import com.galimi.lwjgl.manager.input.Key;
import com.galimi.lwjgl.shapes.*;
import com.galimi.lwjgl.util.Vec;
import com.galimi.lwjgl.util.Vec3;

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
        setController(c);
        g = new Graphics(cam, c, m);
        
        // Game Objects
        player = new Player(0, -height*0.1f, -40) {
        // player = new Player(0, -height*0.3f, -40) {
            @Override
            public void update() {
                Vec3 camDist = Vec3.add(player, cam);
                // Vec3 camDist = Vec3.sub(cam, player);
                // System.out.println((Math.abs(camDist.getX()) > width*0.3));
                // if (Math.abs(camDist.getX()) > width*0.3) cam.getAcc().set(-acc.getX(),0,0);
                
                super.update();
                if (camDist.getX() < -width*0.3 && vel.getX() < 0) cam.add(-vel.getX(), 0, 0);
                if (camDist.getX() > width*0.3 && vel.getX() > 0) cam.add(-vel.getX(), 0, 0);
                if (camDist.getZ() > -40  && vel.getZ() > 0) cam.add(0, 0, -vel.getZ());
                if (camDist.getZ() < -60  && vel.getZ() < 0) cam.add(0, 0, -vel.getZ());

                vel.mult(0.88f); // friction!
            }
        }; 
        // Game Loop
        g.setUpdate((camera, controller, mouse, objs) -> {
            // TODO
            for (Drawable d: objs) {
                boolean collides = false;
                if (d instanceof Collidable && !(d instanceof Player)) {
                    for (Vec3 point: player.boundingBox())
                        if (((Collidable)d).intersects(point)) collides = true;
                }        
                if (collides) player.repell();
            }
        });
        
        g.add(new Box(0, -height*0.3f, -25, 4000, 20, 100));
        // player.applyForce(new Vec3(2, 2, 0));
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
        Vec3 horizontalSpeed = new Vec3(1f, 0, 0);
        Vec3 forwardSpeed = new Vec3(0, 0, -0.1f);
        

        c.addKeys(
            new Key(GLFW_KEY_A, (window) -> player.applyForce(Vec3.mult(horizontalSpeed, -1))),
            new Key(GLFW_KEY_D, (window) -> player.applyForce(horizontalSpeed)),
            new Key(GLFW_KEY_W, (window) -> player.applyForce(forwardSpeed)),
            new Key(GLFW_KEY_S, (window) -> player.applyForce(Vec3.mult(forwardSpeed, -1))),
            new Key(GLFW_KEY_ESCAPE, (window) -> glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_NORMAL)),
            new Key(GLFW_KEY_E, (window) -> cam.addRot(1)), // TODO remove temp
            new Key(GLFW_KEY_Q, (window) -> cam.addRot(-1)), // TODO remove temp
            // new Key(GLFW_Up, (window) -> cam.move(0, 0, speed.getX())), // TODO remove temp
            new Key(GLFW_KEY_Q, (window) -> cam.addRot(-1)) // TODO remove temp
            );
    }
}
package com.galimi.lwjgl.manager;

import java.util.ArrayList;

import com.galimi.lwjgl.manager.input.Controller;
import com.galimi.lwjgl.manager.input.Mouse;
import com.galimi.lwjgl.shapes.Drawable;

import org.lwjgl.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Graphics {
    private final Controller controller;
    private final Mouse mouse;
    private final Camera camera;
    private ArrayList<Drawable> objects;
    private boolean dbug = false;

    public Graphics(Camera camera, Controller controller, Mouse mouse) {
        objects = new ArrayList<Drawable>(20); // increase if adding a lot of values
        this.camera = camera;
        this.controller = controller;
        this.mouse = mouse;
    }

    public void run(int width, int height, float fov) {
        Display window = new Display(width, height, "Test");
		System.out.println("LWJGL version: " + Version.getVersion());

        init(width, height, window.getWindow());
        
        // Cube testCube = new Cube(width/3, height/3, 100, 50) {
        //     @Override
        //     public void draw() {
        //         super.draw(() -> );
        //     }
        // };

        while (window.alive()) {

			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            // glClearDepth(1.0f);

            glColor3f(0.25f, 0.75f, 0.25f);

            controller.update();

            for (Drawable d: objects) {
                camera.lookAt();
                camera.update();
                d.draw();                
                glLoadIdentity();
            }    

            glFlush();
			glfwSwapBuffers(window.getWindow()); // swap the color buffers
			glfwPollEvents();
		}

        window.close();
	}

    private void init(int width, int height, long window) {
        GL.createCapabilities();
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        // glOrtho(0, width, 0, height, -200, 500);

        camera.init(width, height);

        glfwSetKeyCallback(window, controller::callback);

        // Cursor
        // glfwSetCursor(window, glfwCreateStandardCursor(GLFW_IBEAM_CURSOR));
        glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_DISABLED);
        glfwSetCursorPos(window, 0, 0);
        glfwSetCursorPosCallback(window, (w, x, y) -> {
            mouse.update(x, y);
        });

        // glViewport(0, 0, 100, 200); // TODO important
        // glEnable(GL_CULL_FACE);
    }

    public void debug() {
        dbug = !dbug;
    }

    @SafeVarargs
    public final <T extends Drawable> void add(T... values) {
        for (T d: values) {
            objects.add(d);
        }
    }
}

package com.galimi.lwjgl;

import org.lwjgl.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import com.galimi.lwjgl.shapes.*;
import com.galimi.lwjgl.util.NumUtil;

public class Graphics {
    Camera camera;

    public void run(int width, int height, float fov) {
        Display window = new Display(width, height, "Test");
		System.out.println("LWJGL version: " + Version.getVersion());

        camera = new Camera(0, 0, 1, fov);
        init(width, height);
        
        // Square square = new Square(width/2, height/2, 50);
        // RotatingSquare rtSquare = new RotatingSquare(width/2, height/2, 50, 0.5f);
        // Cube cube = new Cube(width/2, height/2, 50);
        // RotatingCube rtCube = new RotatingCube(width/2, height/2, 250, 250, 1f);
        // RotatingCube rtCube = new RotatingCube(width/2, height/2, 50, 50, 1f);
        RotatingCube[] rtCubes = new RotatingCube[20];
        fillCubeArray(rtCubes, width, height);
        // RotatingCube rt2Cube = new RotatingCube(width/3, height/3, 100, 50, 0.4f);
        // Cube testCube = new Cube(width/3, height/3, 100, 50) {
        //     @Override
        //     public void draw() {
        //         super.draw(() -> );
        //     }
        // };
        // RotatingCube rtCube = new RotatingCube(50, 50, 50, 50, 1f);

        while (window.alive()) {

			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            // glClearDepth(1.0f);

            glColor3f(0.25f, 0.75f, 0.25f);
            for (RotatingCube r: rtCubes) { r.draw(); }
            // square.draw();
            // rtSquare.draw();
            // cube.draw();
            // rtCube.draw();
            // rt2Cube.draw();

            glFlush();
			glfwSwapBuffers(window.getWindow()); // swap the color buffers
			glfwPollEvents();
		}

        window.close();
	}

    private void perspective(float fov) {
        // glMultMatrixf(new float[0] {
            
        // });
    }

    private void init(int width, int height) {
        GL.createCapabilities();
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();

        glOrtho(0, width, 0, height, -200, 500);

        glEnable(GL_DEPTH_TEST);
        glDepthFunc(GL_LESS);    

        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);

        camera.init(width, height);

        // glViewport(0, 0, width, height);
        
        glLoadIdentity();
        // glEnable(GL_CULL_FACE);
    }

    private void fillCubeArray(RotatingCube[] arr, int width, int height) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new RotatingCube(
                NumUtil.randomInt(width*0.2, width*0.8), 
                NumUtil.randomInt(height*0.2, height*0.8), 
                NumUtil.randomInt(50, 100), 
                50, 
                NumUtil.randomFloat(0.01, 2));
        }
    }
}

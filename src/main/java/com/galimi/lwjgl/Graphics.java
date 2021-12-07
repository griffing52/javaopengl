package com.galimi.lwjgl;

import org.lwjgl.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import com.galimi.lwjgl.shapes.*;

public class Graphics {
    public void run(int width, int height) {
        Display window = new Display(width, height, "Test");
		System.out.println("LWJGL version: " + Version.getVersion());

        GL.createCapabilities();
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, 0, height, -500, 500);
        glMatrixMode(GL_MODELVIEW);
        
        // Square square = new Square(width/2, height/2, 50);
        // RotatingSquare rtSquare = new RotatingSquare(width/2, height/2, 50, 0.5f);
        // Cube cube = new Cube(width/2, height/2, 50);
        RotatingCube rtCube = new RotatingCube(width/2, height/2, 50, 50, 1f);
        // RotatingCube rtCube = new RotatingCube(50, 50, 50, 1f);

        while (window.alive()) {
            glEnable(GL_DEPTH_TEST);
            glDepthFunc(GL_LESS);    
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            glClearDepth(1.0f);
            
            glColor3f(0.25f, 0.75f, 0.25f);
            // square.draw();
            // rtSquare.draw();
            // cube.draw();
            rtCube.draw();

            glFlush();
			glfwSwapBuffers(window.getWindow()); // swap the color buffers
			glfwPollEvents();
		}

        window.close();
	}
}

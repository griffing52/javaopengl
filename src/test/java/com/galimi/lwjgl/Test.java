// package com.galimi.lwjgl;

// import com.galimi.lwjgl.*;

// import org.lwjgl.*;
// import org.lwjgl.opengl.*;

// import static org.lwjgl.glfw.GLFW.*;
// import static org.lwjgl.opengl.GL11.*;


// public class Test {
//     private static double lat = 4;

//     public static void main(String[] args) {
//         run(1920, 1080);
//     }
    
//     public static void run(int width, int height) {
//         Display window = new Display(width, height, "Test");
//         init();
//         // while (window.alive()) {

// 		// 	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
//         //     // glClearDepth(1.0f);

//         //     glColor3f(0.25f, 0.75f, 0.25f);

//         //     glFlush();
// 		// 	glfwSwapBuffers(window.getWindow()); // swap the color buffers
// 		// 	glfwPollEvents();
// 		}

//         // window.close();
//     }

//     public static void init() {
//         glClearColor(1, 1, 1, 1);

//         glEnable(GL_DEPTH_TEST);

//         glMatrixMode(GL_MODELVIEW);
//         glLoadIdentity();

//         glMatrixMode(GL_PROJECTION);
//         glLoadIdentity();

//         glFrustum(-10, 10, -10, 10, 4,6);

//         glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
//         glMatrixMode(GL_MODELVIEW);
//         glLoadIdentity();
//         glTranslated(0,0,-lat);//it doesn't show in the window without this.
//         DisplayObject();
//         break;
//     }

//     public static void InitObject() {
//         glNewList(k, GL_COMPILE);
    
//         glColor3f(1, 0, 0); 
//         glBegin(GL_QUADS);
//         glVertex3d(0, lat, lat);
//         glVertex3d(lat, lat, lat);
//         glVertex3d(lat, 0, lat);
//         glVertex3d(0, 0, lat);
//         glEnd();
    
//         glColor3f(1, 1, 0); 
//         glBegin(GL_QUADS);
//         glVertex3d(lat, 0, 0);
//         glVertex3d(lat, 0, lat);
//         glVertex3d(lat, lat, lat);
//         glVertex3d(lat, lat, 0);
//         glEnd();
    
//         glColor3f(0, 1, 0); 
//         glBegin(GL_QUADS);
//         glVertex3d(0, lat, lat);
//         glVertex3d(lat, lat, lat);
//         glVertex3d(lat, lat, 0);
//         glVertex3d(0, lat, 0);
//         glEnd();
    
//         glColor3f(0, 0, 1); 
//         glBegin(GL_QUADS);
//         glVertex3d(0, 0, 0);
//         glVertex3d(lat, 0, 0);
//         glVertex3d(lat, 0, lat);
//         glVertex3d(0, 0, lat);
//         glEnd();
    
//         glColor3f(1, 0, 1);  
//         glBegin(GL_QUADS);
//         glVertex3d(0, 0, lat);
//         glVertex3d(0, 0, 0);
//         glVertex3d(0, lat, 0);
//         glVertex3d(0, lat, lat);
//         glEnd();
    
//         glColor3f(0, 1, 1); 
//         glBegin(GL_QUADS);
//         glVertex3d(0, lat, 0);
//         glVertex3d(lat, lat, 0);
//         glVertex3d(lat, 0, 0);
//         glVertex3d(0, 0, 0);
//         glEnd();
//         glEndList();
//     }
    
// }

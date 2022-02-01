package com.galimi.lwjgl;

import static org.lwjgl.opengl.GL11.*;
// import java.nio.FloatBuffer;
// import org.lwjgl.BufferUtils;

public class Camera {
    private float x, y, z, fov;

    public Camera(float x, float y, float z, float fov) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.fov = fov;
    }
    
    public void init(int width, int height) {
        glEnable(GL_DEPTH_TEST);

        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();

        double aspect = (double) width/height;
        
        double zNear = 0.1;
        double zFar = 400;
        
        // double fH = 1/Math.tan(fov*Math.PI/360) * Math.abs(zNear) * 2;
        // double fW = fH * aspect;
        // glFrustum(-fW, fW, -fH, fH, zNear, zFar); 

        double fH = 1;
        double fW = fH * aspect;

        glFrustum(-fW, fW, -fH, fH, zNear, zFar);

        glDepthFunc(GL_LESS);

        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);

        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        // System.out.println(String.format("l: %f, r: %f, b: %f, t: %f, n: %f, f: %f", -fW, fW, -fH, fH, zNear, zFar));
        // glFrustum(0, width, 0, height, zNear, zFar);

    }
}

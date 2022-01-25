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
        double aspect = (double) width/height;
        
        double zNear = -0.1;
        double zFar = 200;
        
        double fH = 1/Math.tan(fov*Math.PI/360) * Math.abs(zNear);
        double fW = fH * aspect;
        // glPushMatrix();
        // glFrustum(-fW, fW, -fH, fH, zNear, zFar); 
        // glFrustum(-fW, fW, -fH, fH, zNear, zFar); 

        glMatrixMode(GL_MODELVIEW);
        // glTranslatef(0, 0, 2);
        // glPopMatrix();     
        // glFrustum(-40, 40, -30, 30, zNear, zFar);
        /*l the left frustum plane
        r the right frustum plane
        b the bottom frustum plane
        t the top frustum plane
        n the near frustum plane
        f*/
        System.out.println(String.format("l: %f, r: %f, b: %f, t: %f, n: %f, f: %f", -fW, fW, -fH, fH, zNear, zFar));
        // glFrustum(0, width, 0, height, zNear, zFar);

    }
}

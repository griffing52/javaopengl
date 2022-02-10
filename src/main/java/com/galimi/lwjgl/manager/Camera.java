package com.galimi.lwjgl.manager;

import static org.lwjgl.opengl.GL11.*;

import com.galimi.lwjgl.math.Vec;
import com.galimi.lwjgl.math.Vec3;

public class Camera {
    private Vec3 pos;
    private Vec3 rot;
    private float fov;
    private float rotation = 0;
    private int width = 1, height = 1;

    public Camera(float x, float y, float z, float fov) {
        pos = new Vec3(x, y, z);
        rot = new Vec3(0, 0, 1);
        this.fov = fov;
    }
    
    public void init(int width, int height) {
        this.width = width;
        this.height = height;

        glEnable(GL_DEPTH_TEST);


        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();

        // glOrtho(0, width, 0, height, 0.1, 1000);
        perspective();

        glDepthFunc(GL_LESS);

        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);

        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        // System.out.println(String.format("l: %f, r: %f, b: %f, t: %f, n: %f, f: %f", -fW, fW, -fH, fH, zNear, zFar));
        // glFrustum(0, width, 0, height, zNear, zFar);

    }

    public void perspective() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();

        double aspect = (double) width/height;
        
        double zNear = 0.1;
        double zFar = 1000;
        
        // double fH = 1/Math.tan(fov*Math.PI/360) * Math.abs(zNear) * 2;
        // double fW = fH * aspect;
        // glFrustum(-fW, fW, -fH, fH, zNear, zFar); 

        double fH = 1;
        double fW = fH * aspect;
        
        glFrustum(-fW, fW, -fH, fH, zNear, zFar);

        // glViewport(0, 0, width, height);
        
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
    }
    
    public void move(float x, float y, float z) {
        pos.add(x, y, z);
    }
    
    public float getX() {
        return pos.getX();
    }
    public float getZ() {
        return pos.getZ();
    }
    
    public void update() {
        glTranslatef(pos.getX(), pos.getY(), pos.getZ());
    }

    public void update(Vec3 dist) {
        update();
        dist.sub(pos).rotateY(rotation);
        glTranslatef(dist.getX(), dist.getY(), dist.getZ());
        rotation+=0.0001f;
    }
    
    public Vec3 getRot() {
        return rot;
    }
    
    public Vec3 getPos() {
        return pos;
    }
    
    
    public Vec getMoveVec() {
        return new Vec(rot.getX(), rot.getZ());
    }
}

package com.galimi.lwjgl.shapes;

import static org.lwjgl.opengl.GL11.*;

import com.galimi.lwjgl.util.Vec3;

public class Cube extends Vec3 implements Drawable {
    Vec3 pos;
    float s;
    /**
     * 
     * @param x x-value
     * @param y y-value
     * @param s side length
     */
    public Cube(float x, float y, float z, float s) {
        super(x, y, z);
        this.s = s;
    }

    public void drawVertices() {
        glBegin(GL_QUADS);
        {
            glColor3f(0,1,0);          // Set The Color To Green
            glVertex3f(-1.0f, 1.0f, -1.0f); // top
            glVertex3f(1.0f, 1.0f, -1.0f);
            glVertex3f(1.0f, 1.0f, 1.0f);
            glVertex3f(-1.0f, 1.0f, 1.0f);
            
            glColor3f(0,0,1);          // Set The Color To Red
            glVertex3f(-1.0f, 1.0f, 1.0f); // back
            glVertex3f(-1.0f, -1.0f, 1.0f);
            glVertex3f(1.0f, -1.0f, 1.0f);
            glVertex3f(1.0f, 1.0f, 1.0f);
            
            glColor3f(1,0.4f,0);          // Set The Color To Orange
            glVertex3f(1.0f, 1.0f, 1.0f); // right
            glVertex3f(1.0f, 1.0f, -1.0f);
            glVertex3f(1.0f, -1.0f, -1.0f);
            glVertex3f(1.0f, -1.0f, 1.0f);
            
            glColor3f(1,1,0);          // Set The Color To Yellow
            glVertex3f(1.0f, -1.0f, 1.0f); // bottom
            glVertex3f(1.0f, -1.0f, -1.0f);
            glVertex3f(-1.0f, -1.0f, -1.0f);
            glVertex3f(-1.0f, -1.0f, 1.0f);
            
            glColor3f(1,0,1);          // Set The Color To Violet
            glVertex3f(-1.0f, -1.0f, 1.0f); // left
            glVertex3f(-1.0f, -1.0f, -1.0f);
            glVertex3f(-1.0f, 1.0f, -1.0f);
            glVertex3f(-1.0f, 1.0f, 1.0f);
            
            glColor3f(1,1,1);          // Set The Color To Blue
            glVertex3f(-1.0f, 1.0f, -1.0f); // front
            glVertex3f(-1.0f, -1.0f, -1.0f);
            glVertex3f(1.0f, -1.0f, -1.0f);
            glVertex3f(1.0f, 1.0f, -1.0f);
        }
        glEnd();
        glPopMatrix();
    }

    public void init() {
        // glLoadIdentity();
        glTranslatef(getX(),getY(),-getZ());
        // TODO temp to show problem of scaling from x and y to z
        // glScalef(s, s, s);
        glScalef(s, s, 1);
    }

    public void draw() {
        init();

        drawVertices();
    }
    public void draw(Runnable r) {
        init();

        r.run();
        drawVertices();
    }
}

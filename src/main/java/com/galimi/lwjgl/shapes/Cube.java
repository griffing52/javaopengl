package com.galimi.lwjgl.shapes;

import static org.lwjgl.opengl.GL11.*;

public class Cube {
    float x, y, z, s;
    /**
     * 
     * @param x x-value
     * @param y y-value
     * @param s side length
     */
    public Cube(float x, float y, float z, float s) {
        this.x = x;
        this.y = y;
        this.z = z;
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

            glColor3f(1,0,0);          // Set The Color To Red
            glVertex3f(-1.0f, 1.0f, 1.0f); // front
            glVertex3f(-1.0f, -1.0f, 1.0f);
            glVertex3f(1.0f, -1.0f, 1.0f);
            glVertex3f(1.0f, 1.0f, 1.0f);

            glColor3f(1,0,0);          // Set The Color To Orange
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

            glColor3f(0,0,1);          // Set The Color To Blue
            glVertex3f(-1.0f, 1.0f, -1.0f); // back
            glVertex3f(-1.0f, -1.0f, -1.0f);
            glVertex3f(1.0f, -1.0f, -1.0f);
            glVertex3f(1.0f, 1.0f, -1.0f);
        }
        glEnd();
    }

    public void init() {
        glLoadIdentity();
        glTranslatef(x,y,z);
        glScalef(s, s, s);
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

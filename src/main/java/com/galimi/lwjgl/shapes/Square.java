package com.galimi.lwjgl.shapes;

import static org.lwjgl.opengl.GL11.*;

public class Square implements Drawable {
    float x, y, s;
    /**
     * 
     * @param x x-value
     * @param y y-value
     * @param s side length
     */
    public Square(float x, float y, float s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }

    public void drawVertices() {
        glScalef(s, s, 1);
        glBegin(GL_QUADS);
        {
           glVertex2f(-1.0f, -1.0f);
           glVertex2f(1.0f, -1.0f);
           glVertex2f(1.0f, 1.0f);
           glVertex2f(-1.0f, 1.0f);
        }
        glEnd();
    }

    private void init() {
        glLoadIdentity();
        glTranslatef(x,y,1);
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
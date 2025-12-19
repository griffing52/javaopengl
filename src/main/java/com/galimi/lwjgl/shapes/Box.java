package com.galimi.lwjgl.shapes;

import static org.lwjgl.opengl.GL11.*;

import com.galimi.lwjgl.util.Vec3;

public class Box extends Vec3 implements Drawable, Collidable {
    float w,h,d;
    float[][] colors;
    
    /**
     * Creates Box object
     * @param x x-coord
     * @param y y-coord
     * @param z z-coord
     * @param w width
     * @param h height
     * @param d depth
     */
    public Box(float x, float y, float z, float w, float h, float d) {
        super(x, y, z);
        this.w = w;
        this.h = h;
        this.d = d;
        colors = new float[][] {{0.06f,0.41f,0.15f}, 
                                {0.3f, 0.2f, 0}, 
                                {0.3f, 0.2f, 0}, 
                                {0.3f, 0.2f, 0}, 
                                {0.3f, 0.2f, 0}, 
                                {0.3f, 0.2f, 0}};
    }

    /**
     * Set the colors of the vertices
     * 
     * @param colors A 2D array of colors. Each row is a color, and each column is a color component.
     */
    public void setColors(float[][] colors) {
        this.colors = colors;
    }

    public void drawVertices() {
        glBegin(GL_QUADS);
        {
            glColor3fv(colors[0]);          // Set The Color To Green
            glVertex3f(-0.5f, 0.5f, -0.5f); // top
            glVertex3f(0.5f, 0.5f, -0.5f);
            glVertex3f(0.5f, 0.5f, 0.5f);
            glVertex3f(-0.5f, 0.5f, 0.5f);
            
            glColor3fv(colors[1]);
            // glColor3f(0,0,1);          // Set The Color To Red
            glVertex3f(-0.5f, 0.5f, 0.5f); // back
            glVertex3f(-0.5f, -0.5f, 0.5f);
            glVertex3f(0.5f, -0.5f, 0.5f);
            glVertex3f(0.5f, 0.5f, 0.5f);
            
            glColor3fv(colors[2]);
            // glColor3f(1,0.4f,0);          // Set The Color To Orange
            glVertex3f(0.5f, 0.5f, 0.5f); // right
            glVertex3f(0.5f, 0.5f, -0.5f);
            glVertex3f(0.5f, -0.5f, -0.5f);
            glVertex3f(0.5f, -0.5f, 0.5f);
            
            glColor3fv(colors[3]);
            // glColor3f(1,1,0);          // Set The Color To Yellow
            glVertex3f(0.5f, -0.5f, 0.5f); // bottom
            glVertex3f(0.5f, -0.5f, -0.5f);
            glVertex3f(-0.5f, -0.5f, -0.5f);
            glVertex3f(-0.5f, -0.5f, 0.5f);
            
            glColor3fv(colors[4]);
            // glColor3f(1,0,1);          // Set The Color To Violet
            glVertex3f(-0.5f, -0.5f, 0.5f); // left
            glVertex3f(-0.5f, -0.5f, -0.5f);
            glVertex3f(-0.5f, 0.5f, -0.5f);
            glVertex3f(-0.5f, 0.5f, 0.5f);
            
            glColor3fv(colors[5]);
            // glColor3f(1,1,1);          // Set The Color To Blue
            glVertex3f(-0.5f, 0.5f, -0.5f); // front
            glVertex3f(-0.5f, -0.5f, -0.5f);
            glVertex3f(0.5f, -0.5f, -0.5f);
            glVertex3f(0.5f, 0.5f, -0.5f);
        }
        glEnd();
        glPopMatrix();
    }

    public boolean intersects(Vec3 point) {
        Vec3[] bounds = boundingBox();
        return (bounds[1].getX() <= point.getX() && bounds[0].getX() >= point.getX()) &&
        (bounds[1].getY() <= point.getY() && bounds[0].getY() >= point.getY()) &&
        (bounds[1].getZ() <= point.getZ() && bounds[0].getZ() >= point.getZ());
    }

    public Vec3[] boundingBox() {
        return new Vec3[] {
            new Vec3(x+0.5f*w,
            y+0.5f*h,
            z+0.5f*d),
            new Vec3(x-0.5f*w,
            y-0.5f*h,
            z-0.5f*d)
        };
    }

    public void init() {
        // glLoadIdentity();
        glTranslatef(getX(),getY(),getZ());
        // TODO temp to show problem of scaling from x and y to z
        glScalef(w, h, d);
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

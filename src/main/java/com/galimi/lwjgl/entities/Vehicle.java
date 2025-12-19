package com.galimi.lwjgl.entities;

import com.galimi.lwjgl.util.Vec3;

public class Vehicle extends Vec3 {
    protected Vec3 acc, vel;

    public Vehicle(float x, float y, float z) {
        super(x, y, z);
        acc = new Vec3(0, 0, 0);
        vel = new Vec3(0, 0, 0);
    }

    /**
     * Add the force to the acceleration
     * 
     * @param force The force that is applied to the body.
     */
    public void applyForce(Vec3 force) {
        acc.add(force);
    }

    /**
     * Add the acceleration to the velocity, then add the velocity to the position
     */
    public void update() {
        vel.add(acc);
        add(vel);
        acc.mult(0);
    }

    public void debug() {
        System.out.print("Acc: ");
        System.out.println(acc);
        System.out.print("Vel: ");
        System.out.println(vel);
        System.out.print("Pos: ");
        System.out.println(this);
    }
}

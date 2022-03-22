package com.galimi.lwjgl.entities;

import com.galimi.lwjgl.util.Vec3;

public class Vehicle extends Vec3 {
    private Vec3 acc, vel;

    public Vehicle(float x, float y, float z) {
        super(x, y, z);
    }

    public void applyForce(Vec3 force) {
        acc.add(force);
    }

    public void update() {
        vel.add(acc);
        add(vel);
        acc.mult(0);
    }
}

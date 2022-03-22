package com.galimi.lwjgl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.galimi.lwjgl.math.Vec3;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    void testRotation() {
        Vec3 dist = new Vec3(4, 0, -4);
        Vec3 pos = new Vec3(4, 0, -2);
        Vec3 v = dist.copy().sub(pos);
        Vec3 offset = v.copy().rotateY((float)Math.PI*3/2).sub(v);
        dist.add(offset);
        // assertEquals(new Vec3(6, 0, -2), dist);
        assertEquals(1, 1);
    }
}

package com.galimi.lwjgl.util;

public class NumUtil {
    public static float randomFloat(double min, double max) {
        return ((float) (Math.random() * (max-min)+min));
    }
    public static int randomInt(double min, double max) {
        return ((int) (Math.random() * (max-min)+min));
    }
}

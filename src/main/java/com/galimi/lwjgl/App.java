package com.galimi.lwjgl;

import com.galimi.lwjgl.shapes.*;
import com.galimi.lwjgl.util.NumUtil;

public class App {
    public static void main(String[] args) {
        int width = 1920; // 800
        int height = 1080; // 600

        RotatingCube[] rtCubes = new RotatingCube[40];
        fillCubeArray(rtCubes, width, height);

        Graphics g = new Graphics();
        g.add(rtCubes);
        // g.add(new RotatingCube(400, 400, 200, 50, 1));
        g.run(width, height, 45.0f);
    }

    private static void fillCubeArray(RotatingCube[] arr, int width, int height) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new RotatingCube(
                NumUtil.randomInt(width*0.2, width*0.8), 
                NumUtil.randomInt(height*0.2, height*0.8), 
                NumUtil.randomInt(50, 100), 
                50, 
                NumUtil.randomFloat(0.4, 2));
        }
    }
}
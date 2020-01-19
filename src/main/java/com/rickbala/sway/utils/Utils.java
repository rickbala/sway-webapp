package com.rickbala.sway.utils;

import java.util.Random;

public class Utils {

    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

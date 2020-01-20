package com.rickbala.sway.utils;

import java.util.ArrayList;
import java.util.Random;

public class Utils {

    private Utils() { throw new IllegalStateException("Utility class"); }

    private static Random r = new Random();

    private static int getRandomNumberInRange(int min, int max) {
        return r.nextInt((max - min) + 1) + min;
    }

    private static ArrayList<String> defineMotos() {
        ArrayList<String> motos = new ArrayList<>();
        String beggining = "Sway it what ";
        String end = ":";
        motos.add(beggining + "hurts" + end);
        motos.add(beggining + "matters" + end);
        motos.add(beggining + "is the problem" + end);
        motos.add(beggining + "you think" + end);
        return motos;
    }

    public static String createRandomMoto() {
        ArrayList<String> motos = defineMotos();
        int randomMotoIndex = getRandomNumberInRange(0, motos.size() - 1);
        return motos.get(randomMotoIndex);
    }

    public static String createRandomChannel(){
        int numberOfChars = 8;
        StringBuilder builder = new StringBuilder();
        for (int i=0; i< numberOfChars; i++){
            builder.append((char)getRandomNumberInRange(65,90));
        }
        return builder.toString();
    }

}

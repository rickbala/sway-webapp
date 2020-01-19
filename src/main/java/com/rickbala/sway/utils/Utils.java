package com.rickbala.sway.utils;

import java.util.ArrayList;
import java.util.Random;

public class Utils {

    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static ArrayList<String> createMotos(ArrayList<String> motos) {
        String beggining = "Sway it what ";
        String end = ":";
        motos.add(beggining + "hurts" + end);
        motos.add(beggining + "matters" + end);
        motos.add(beggining + "is the problem" + end);
        motos.add(beggining + "you think" + end);
        return motos;
    }

    public static String createRandomMoto() {
        ArrayList<String> motos = new ArrayList<>();
        motos = createMotos(motos);
        int randomMotoIndex = getRandomNumberInRange(0, motos.size() - 1);
        return motos.get(randomMotoIndex);
    }
}

package com.rickbala.sway.main;

import com.rickbala.sway.main.characteristics.Direct;
import com.rickbala.sway.main.characteristics.Funny;
import com.rickbala.sway.main.characteristics.Laughable;
import com.rickbala.sway.main.characteristics.Postable;
import com.rickbala.sway.model.Sway;
import com.rickbala.sway.utils.Utils;

import java.util.ArrayList;

public class SwayApp implements Laughable, Funny, Direct, Postable {

    //@Autowired
    //SwayDAOImpl swayDAO;

    public SwayApp() {
        System.out.println("Hello Swayer!\n");
    }

    public static void main( String[] args ) {
        SwayApp app = new SwayApp();
        app.createRandomMoto();

        //test saving first Sway
        //app.post("I'm swaying!");
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

    @Override
    public String createRandomMoto() {
        ArrayList<String> motos = new ArrayList<>();
        motos = createMotos(motos);
        int randomMotoIndex = Utils.getRandomNumberInRange(0, motos.size() - 1);
        return motos.get(randomMotoIndex);
    }

    @Override
    public void post(String text) {
        Sway sway = new Sway(text);
        //swayDAO.save(sway);
        //System.out.println("Sway salvo! " + sway.getId());
    }
}

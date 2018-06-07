package model;

import java.util.ArrayList;
import java.util.List;

public class Player1 extends Player {

    private static Player1 instance = null;


    private Player1() {
        this.setxAxis(300);
    }

    public static Player1 getInstance() {
        if (instance == null) {
            instance = new Player1();
        }
        return instance;
    }

   



}

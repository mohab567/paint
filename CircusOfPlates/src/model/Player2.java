package model;

import java.util.ArrayList;
import java.util.List;

public class Player2 extends Player {

    private static Player2 instance = null;
    private Player2() {
    	this.setxAxis(600);
    }

    public static Player2 getInstance() {
        if (instance == null) {
            instance = new Player2();
        }
        return instance;
    }


}

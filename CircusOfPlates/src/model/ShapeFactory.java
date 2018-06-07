package model;

import java.awt.Point;
import java.util.ArrayList;

import view.GUI;

public class ShapeFactory {

    private Shape shape;
    private ArrayList<Class<?>> shapesList = new ArrayList<Class<?>>();
    private int x_Axis;
    private int y_Axis;
    private int randomNum;

    public ShapeFactory() {
        shapesList.add(Plate.class);
        shapesList.add(Hat.class);
    }

    // generate new Shape with randomly chosen colors,
    // x-axis position and shape class
    public Shape ShapePropertiesChooser() {

        randomNum = randomNumber(shapesList.size());
        int randomNum1 = randomNumber(5);
        shape = new Shape();
        try {
            shape = (Shape) shapesList.get(randomNum).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        shape.chooseImageColor(randomNum1);
        x_Axis = randomNumber(1200);
        y_Axis = 0;
        shape.setPosition(new Point(x_Axis, y_Axis));
        return shape;
    }

    public int randomNumber(int length) {
        // generate random number from 0 to length-1
        return (int) (Math.floor(Math.random() * (length)));
    }

}

package model;

import java.awt.Point;
import java.awt.font.NumericShaper.Range;
import java.awt.image.BufferedImage;
import java.time.temporal.ValueRange;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Shape implements IShape {

    private Point position;
    private BufferedImage img;
    private int color;
 
    // 0 for red, 1 for cyan, 2 yellow, 3 brown, 4 green;
    // private ShapePool manufacturedShape;

    public Shape() {
        // TODO Auto-generated constructor stub
        position = new Point();
        
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;


    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void chooseImageColor(int colorNumber) {
    };

}

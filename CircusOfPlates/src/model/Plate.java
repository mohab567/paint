package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plate extends Shape {

    // int colorNumber;
    BufferedImage picRed;
    BufferedImage picCyan;
    BufferedImage picYellow;
    BufferedImage picBrown;
    BufferedImage picGreen;

    public Plate() throws IOException {
        picRed = ImageIO.read(new File("img/redPlate.png"));
        picCyan = ImageIO.read(new File("img/cyanPlate.png"));
        picYellow = ImageIO.read(new File("img/yellowPlate.png"));
        picBrown = ImageIO.read(new File("img/brownPlate.png"));
        picGreen = ImageIO.read(new File("img/greenPlate.png"));
        // TODO Auto-generated constructor stub
        // colorNumber = n;
    }

    @Override
    public void chooseImageColor(int colorNumber) {
        // its supposed to be void .
        try {
            switch (colorNumber) {
                case 0:

                    this.setImg(picRed);
                    this.setColor(0);
                    break;
                case 1:

                    this.setImg(picCyan);
                    this.setColor(1);
                    break;
                case 2:

                    this.setImg(picYellow);
                    this.setColor(2);
                    break;
                case 3:

                    this.setImg(picBrown);
                    this.setColor(3);
                    break;
                case 4:

                    this.setImg(picGreen);
                    this.setColor(4);
                    break;
            }
        } catch (Exception e) {}

    }

}

package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hat extends Shape {

    // int colorNumber;
    BufferedImage picRed;
    BufferedImage picCyan;
    BufferedImage picYellow;
    BufferedImage picBrown;
    BufferedImage picGreen;

    public Hat() throws IOException {
        picRed = ImageIO.read(new File("img/redHat.png"));
        picCyan = ImageIO.read(new File("img/cyanHat.png"));
        picYellow = ImageIO.read(new File("img/yellowHat.png"));
        picBrown = ImageIO.read(new File("img/brownHat.png"));
        picGreen = ImageIO.read(new File("img/greenHat.png"));
    }

    @Override
    public void chooseImageColor(int colorNumber) {
        // its supposed to be void .
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

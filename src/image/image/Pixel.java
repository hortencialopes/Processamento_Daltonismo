package image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel {
    int width;
    int height;

    public Pixel(BufferedImage image){
        try {
            width = image.getWidth();
            height = image.getHeight();
            int count = 0;
            for(int i=0; i< height; i++) {
                for(int j=0; j< width; j++) {
                    count++;
                    /*Pega RGB da imagem */
                    Color c = new Color(image.getRGB(j, i));
                    System.out.println("Pixel.No: " + count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
                }
            }

        } catch (Exception e) {}
    }
}

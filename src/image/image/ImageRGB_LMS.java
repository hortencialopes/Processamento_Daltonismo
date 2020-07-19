package image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageRGB_LMS {


    public static Color getRGB (BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();

        int[] dataBuffInt = image.getRGB(0, 0, w, h, null, 0, w);

        Color c = new Color(dataBuffInt[100]);

        System.out.println(c.getRed());   // = (dataBuffInt[100] >> 16) & 0xFF
        System.out.println(c.getGreen()); // = (dataBuffInt[100] >> 8)  & 0xFF
        System.out.println(c.getBlue());  // = (dataBuffInt[100] >> 0)  & 0xFF
        System.out.println(c.getAlpha()); // = (dataBuffInt[100] >> 24) & 0xFF
        //double[] rgb =
        double[] lms = ImageLMS(c.getRed(), c.getGreen(), c.getBlue());

        for (int i = 0; i < lms.length; i++) {
            System.out.println(lms[i]);
        }

        return c;
    }

    public static double[] ImageLMS(double r, double g, double b){

        /*O LMS representa a cor no nível da retina */

        double L = (17.8824 * r) + (43.5161 * g) + (4.11935 * b);
        double M = (3.45565 * r) + (27.1554 * g) + (3.86714 * b);
        double S = (0.0299566 * r) + (0.184309 * g) + (1.46709 * b);

        return new double[] { L, M, S };
    }


}


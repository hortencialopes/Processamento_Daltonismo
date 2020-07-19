package image;

import java.awt.image.BufferedImage;

public class ImageRGB_LMS {

    public static int[] pixelRGB(BufferedImage image, int x, int y){
        int color = image.getRGB(x,y);

        int blue = color & 0xff;
        int green = (color & 0xff00) >> 8;
        int red = (color & 0xff0000) >> 16;
        /*opacidade*/
        int alpha = (color & 0xff000000) >>> 24;

        return new int[]{blue, green, red, alpha};
    }

    public static double[] pixelRGBParaLMS(double r, double g, double b){

        /*O LMS representa a cor no nível da retina */

        double L =  ((17.8824 * r) + (43.5161 * g) + (4.11935 * b));
        double M = ((3.45565 * r) + (27.1554 * g) + (3.86714 * b));
        double S = ((0.0299566 * r) + (0.184309 * g) + (1.46709 * b));

        return new double[] { L, M, S };
    }

    public static double[] pixelLMSParaRGB(double l, double m, double s) {
        /*Multiplica pelo inverso */
        double R = ((0.080944 * l) + (-0.130504 * m) + (0.116721 * s));
        double G = ((-0.0102485 * l) + (0.0540194 * m) + (-0.113615 * s));
        double B = ((-0.000365294 * l) + (-0.00412163 * m) + (0.6935113 * s));
        System.out.println((float)R+ " / "+ (float)G + " / "+ (float)B+ " / ");
        return new double[] { R, G, B };
    }

}



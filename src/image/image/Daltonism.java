package image;

public class Daltonism {


    public static double[][] Pronatopia(){

        double[][] matrizProtanopia = new double[][] {
                {0.0, 2.02344, -2.52581},
                {0.0, 1.0, 0.0},
                {0.0, 0.0, 1.0}
        };
        return matrizProtanopia;
    }

    public static double[][] Deuteranopia() {
        double[][] matrizDeuteranopia = new double[][]{
                {1.0, 0.0, 0.0},
                {0.494207, 0.0, 1.24827},
                {0.0, 0.0, 1.0}
        };
        return matrizDeuteranopia;

    }

    public static double[][] Tritanopia() {
        /* Tritanopia */
        double[][] matrizTritanopia = new double[][] {
                {1.0, 0.0, 0.0},
                {0.0, 1.0, 0.0},
                {-0.395913, 0.801109, 0.0}
        };
        return matrizTritanopia;
    }
}

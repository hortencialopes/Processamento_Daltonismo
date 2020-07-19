package image;

public class ImageTransformation {
    /* Tipos de daltonismo */

    /* Pronatopia */
    private static double[][] matrizProtanopia = new double[][] {
            {0.0, 2.02344, -2.52581},
            {0.0, 1.0, 0.0},
            {0.0, 0.0, 1.0}
    };

    /* Deuteranopia */
    private static double[][] matrizDeuteranopia = new double[][] {
            {1.0, 0.0, 0.0},
            {0.494207, 0.0, 1.24827},
            {0.0, 0.0, 1.0}
    };

    /* Tritanopia */
    private static double[][] matrizTritanopia = new double[][] {
            {1.0, 0.0, 0.0},
            {0.0, 1.0, 0.0},
            {-0.395913, 0.801109, 0.0}
    };

    public static double[] TransformacaoEspectroDaltonico (double[] lms, double[][] tipoDaltonismo){

        double l = (tipoDaltonismo[0][0] * lms[0]) + (tipoDaltonismo[0][1] * lms[1]) + (tipoDaltonismo[0][2] * lms[2]);
        double m = (tipoDaltonismo[1][0] * lms[0]) + (tipoDaltonismo[1][1] * lms[1]) + (tipoDaltonismo[1][2] * lms[2]);
        double s =(tipoDaltonismo[2][0] * lms[0]) + (tipoDaltonismo[2][1] * lms[1]) + (tipoDaltonismo[2][2] * lms[2]);

        return new double[] { l, m, s };
    }

    public static double[] LMSDaltonicoToRGB(double[] daltonismoLMS){

        double R = (0.0809444479 * daltonismoLMS[0]) + (-0.130504409 * daltonismoLMS[1]) + (0.116721066 * daltonismoLMS[2]);
        double G = (-0.0102485335 * daltonismoLMS[0]) + (0.0540193266 * daltonismoLMS[1]) + (-0.113614708 * daltonismoLMS[2]);
        double B = (-0.000365296938 * daltonismoLMS[0]) + (-0.00412161469 * daltonismoLMS[1]) + (0.693511405 * daltonismoLMS[2]);

        return new double[] { R, G, B };
    }

    public static double[] MatrizErro (double[] daltonicoRGB, double[] originalRGB ){
       /*  R = r -R;
        G = g -G;
        B = b -B; */

        double R = originalRGB[0] - daltonicoRGB[0];
        double G = originalRGB[0] - daltonicoRGB[0];
        double B = originalRGB[0] - daltonicoRGB[0];

        return new double[] { R, G, B};
    }

    //public static double[] CorFinal ()

}

package image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageTransformation {

    static BufferedImage imgSaida = null;
    static Daltonism pronatopia, deuteranopia, tritanopia;

    public static BufferedImage ImagemFinal(BufferedImage imgOriginal, String tipo){
        Color c;
        int r, g, b;
        int red, green, blue;

        try {

            int width = imgOriginal.getWidth();
            int height = imgOriginal.getHeight();

            /* criamos a imagem de saida de acordo com as especificacoes da entrada */
            imgSaida = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            System.out.println("Width "+imgSaida.getWidth());
            System.out.println("Height "+imgSaida.getHeight());

            for(int i = 0; i < height ; i++) {
                for(int j = 0; j < width; j++) {
                    /* Pega RGB do pixel */
                    c = new Color(imgOriginal.getRGB(j, i));
                    r = c.getRed();
                    g = c.getGreen();
                    b = c.getBlue();

                    /*Converte RGB para LMS */
                    double[] lms = ImageRGB_LMS.pixelRGBParaLMS(r, g, b);

                    double[] pixelDaltonico;

                    /*Transforma tipo daltonismo */

                    if(tipo.equals("pronatopia")){
                        pixelDaltonico = TransformacaoEspectroDaltonico(lms, Daltonism.Pronatopia());
                        //System.out.println("j = "+j +" i = "+i+"\nPixel : "+pixelDaltonico[0] +", "+pixelDaltonico[1]+", "+pixelDaltonico[2]);
                    }
                    else if(tipo.equals("deuteranopia")){
                        pixelDaltonico = TransformacaoEspectroDaltonico(lms, Daltonism.Deuteranopia());
                    }
                    else if (tipo.equals("tritanopia")){
                        pixelDaltonico = TransformacaoEspectroDaltonico(lms, Daltonism.Tritanopia());
                    }
                    else{
                        System.out.println("Tipo inválido!");
                        break;
                    }

                    /*Converte o pixel para RGB */
                    double[] rgb = ImageRGB_LMS.pixelLMSParaRGB(pixelDaltonico[0],pixelDaltonico[1],pixelDaltonico[2]);
                    double[] corFinal = CorFinal(rgb, r, g, b);
                    red = (int) Math.abs(Math.floor(corFinal[0]));
                    green = (int) Math.abs(Math.floor(corFinal[1]));
                    blue = (int) Math.abs(Math.floor(corFinal[2]));

                    if(red < 0) {
                        red = 0;
                    }
                    if(red > 255) {
                        red = 255;
                    }
                    if(blue < 0) {
                        blue = 0;
                    }
                    if(blue > 255) {
                        blue = 255;
                    }
                    if(green < 0) {
                        green = 0;
                    }
                    if(green > 255) {
                        green = 255;
                    }
                    //System.out.println(" x: "+ i + " y: "+j+ " RGB: "+red+", "+green+", "+blue);

                    Color rgbC = new Color(red, green, blue);

                    imgSaida.setRGB(j, i, rgbC.getRGB());
                }
            }

        } catch (Exception e) {
            System.out.println("Algo deu errado");
        }
        return imgSaida;
    }

    public static double[] TransformacaoEspectroDaltonico (double[] lms, double[][] tipoDaltonismo){
        double L = lms[0];
        double M = lms[1];
        double S = lms[2];

        double l = (tipoDaltonismo[0][0] * L) + (tipoDaltonismo[0][1] * M) + (tipoDaltonismo[0][2] * S);
        double m = (tipoDaltonismo[1][0] * L) + (tipoDaltonismo[1][1] * M) + (tipoDaltonismo[1][2] * S);
        double s =(tipoDaltonismo[2][0] * L) + (tipoDaltonismo[2][1] * M) + (tipoDaltonismo[2][2] * S);

        return new double[] { l, m, s };
    }

    public static double[] CorFinal (double[] daltonicoRGB, int r, int g, int b ){
       /*  R = r -R;
        G = g -G;
        B = b -B; */

        double R = r - daltonicoRGB[0];
        double G = g - daltonicoRGB[1];
        double B = b - daltonicoRGB[2];

        double RR =(0.0 * R) + (0.0 * G) + (0.0 * B);
        double GG =(0.7 * R) + (1.0 * G) + (0.0 * B);
        double BB =(0.7 * R) + (0.0 * G) + (1.0 * B);

        R = RR + r;
        G = GG + g;
        B = BB + b;

        return new double[] { R, G, B};
    }

    public static BufferedImage ImagemDaltonica(BufferedImage imgOriginal, String tipo){
        Color c;
        int r, g, b;
        int red, green, blue;

        try {

            int width = imgOriginal.getWidth();
            int height = imgOriginal.getHeight();

            /* criamos a imagem de saida de acordo com as especificacoes da entrada */
            imgSaida = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            System.out.println("Width "+imgSaida.getWidth());
            System.out.println("Height "+imgSaida.getHeight());

            for(int i = 0; i < height ; i++) {
                for(int j = 0; j < width; j++) {
                    /* Pega RGB do pixel */
                    c = new Color(imgOriginal.getRGB(j, i));
                    r = c.getRed();
                    g = c.getGreen();
                    b = c.getBlue();

                    /*Converte RGB para LMS */
                    double[] lms = ImageRGB_LMS.pixelRGBParaLMS(r, g, b);

                    double[] pixelDaltonico;

                    /*Transforma tipo daltonismo */

                    if(tipo.equals("pronatopia")){
                        pixelDaltonico = TransformacaoEspectroDaltonico(lms, Daltonism.Pronatopia());
                        //System.out.println("j = "+j +" i = "+i+"\nPixel : "+pixelDaltonico[0] +", "+pixelDaltonico[1]+", "+pixelDaltonico[2]);
                    }
                    else if(tipo.equals("deuteranopia")){
                        pixelDaltonico = TransformacaoEspectroDaltonico(lms, Daltonism.Deuteranopia());
                    }
                    else if (tipo.equals("tritanopia")){
                        pixelDaltonico = TransformacaoEspectroDaltonico(lms, Daltonism.Tritanopia());
                    }
                    else{
                        System.out.println("Tipo inválido!");
                        break;
                    }

                    /*Converte o pixel para RGB */
                    double[] rgb = ImageRGB_LMS.pixelLMSParaRGB(pixelDaltonico[0],pixelDaltonico[1],pixelDaltonico[2]);
                    //double[] corFinal = CorFinal(rgb, r, g, b);
                    red = (int) Math.abs(Math.floor(rgb[0]));
                    green = (int) Math.abs(Math.floor(rgb[1]));
                    blue = (int) Math.abs(Math.floor(rgb[2]));

                    if(red < 0) {
                        red = 0;
                    }
                    if(red > 255) {
                        red = 255;
                    }
                    if(blue < 0) {
                        blue = 0;
                    }
                    if(blue > 255) {
                        blue = 255;
                    }
                    if(green < 0) {
                        green = 0;
                    }
                    if(green > 255) {
                        green = 255;
                    }
                    //System.out.println(" x: "+ i + " y: "+j+ " RGB: "+red+", "+green+", "+blue);

                    Color rgbC = new Color(red, green, blue);

                    imgSaida.setRGB(j, i, rgbC.getRGB());
                }
            }

        } catch (Exception e) {
            System.out.println("Algo deu errado");
        }
        return imgSaida;
    }



}

package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedImage img;
        try {
            //img = ImageManipulation.leImagem(new File("C:\\Users\\horte\\OneDrive\\Imagens\\Capturar.PNG"));
            img = ImageManipulation.leImagem(new URL("https://super.abril.com.br/wp-content/uploads/2018/07/531e320b9827682eba000202cubo-magico-13.jpeg"));
            if(img == null){
                System.out.println("eita");
            }

            BufferedImage imgSaida1 = ImageTransformation.ImagemFinal(img, "pronatopia");
            BufferedImage imgSaida2 = ImageTransformation.ImagemFinal(img, "deuteranopia");
            BufferedImage imgSaida3 = ImageTransformation.ImagemFinal(img, "tritanopia");

            ImageManipulation.exibeImagem(img,imgSaida1, imgSaida2, imgSaida3);

        } catch (Exception e){
            System.out.println("Algo deu errado :(");
        }

        System.out.println("Ola Mundo!");
    }
}
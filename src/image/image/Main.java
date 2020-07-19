package image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class Main{
    public static void main(String[] args) throws Exception{
        //Daltonism pronatopia = new Daltonism(), deuteranopia = new Daltonism(), tritanopia = new Daltonism();
        try {
            BufferedImage img = ImageManipulation.leImagem(new URL("https://www.daltonicos.com.br/daltonico/img/ishihara12.jpg"));
            if(img == null){
                System.out.println("eita");
            }
            BufferedImage imgSaida = ImageTransformation.imagemDaltonica(img, "pronatopia");

            ImageManipulation.exibeImagem(img,imgSaida,"Pronatopia");
        } catch (Exception e){
            System.out.println("Algo deu errado :(");
        }

        System.out.println("Ola Mundo!");
    }
}
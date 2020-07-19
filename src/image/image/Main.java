package image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedImage img = ImageManipulation.leImagem(new URL("https://raw.githubusercontent.com/lemire/kodakimagecollection/master/kodim03.png"));
        ImageManipulation.exibeImagem(img);

        //Pixel pxl = new Pixel(ImageIO.read(new URL("https://raw.githubusercontent.com/lemire/kodakimagecollection/master/kodim03.png")));
        System.out.println("Ola Mundo!");
    }
}
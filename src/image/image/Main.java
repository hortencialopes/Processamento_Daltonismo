package image;

import javax.imageio.ImageIO;
import java.io.File;

public class Main{
    public static void main(String[] args) throws Exception{
        Pixel pxl = new Pixel(ImageIO.read(new File("C:\\Users\\horte\\OneDrive\\Imagens\\olhandopcima.jpg")));
        System.out.println("Ola Mundo!");
    }
}
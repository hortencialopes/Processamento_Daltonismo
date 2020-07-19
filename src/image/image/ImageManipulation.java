package image;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.*;
import javax.swing.*;

/* Nesta classe, lemos uma entrada de imagem
 */

public class ImageManipulation {
    /*Cria o buffer de leitura da imagem*/
    static BufferedImage img = null;
    /*Cria o jFrame para exibir a imagem*/
    static JFrame frame = null;

    public static BufferedImage leImagem(URL url){
        /*Metodos static que retorna uma imagem dado um caminho*/
        /*TO DO: Alterar para receber imagem como parametro*/
        try {
            img = ImageIO.read(url);
            /*Tenta ler a imagem, se conseguir, retorna */
            return img;
        } catch (IOException e) {
            System.out.println("Nao foi possível ler a imagem!");
        }
        /*retorna null se nao conseguir ler*/
        return null;
        }

        public static void exibeImagem(BufferedImage imagem){
        if(imagem == null) {
            System.out.println("A imagem é nula. Verifique o parâmetro e tente novamente.");
        }
            /*Cria jFrame */
            frame = new JFrame("Imagem");

            frame.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

            /*Cria o jLabel para exibir a imagem de entrada */
            /*TO DO: redimensionar o jLabel para ficar menor e centralizado */
            JLabel picLabel = new JLabel(new ImageIcon(imagem));

            Color color = ImageRGB_LMS.getRGB(imagem);

            frame.add(picLabel);
            frame.pack();
            frame.setVisible(true);
        }

}

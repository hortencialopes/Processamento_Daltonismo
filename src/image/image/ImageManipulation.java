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

    public static BufferedImage leImagem(File file){
        /*Metodos static que retorna uma imagem dado um caminho*/
        /*TO DO: Alterar para receber imagem como parametro*/
        try {
            img = ImageIO.read(file);
            /*Tenta ler a imagem, se conseguir, retorna */
            return img;
        } catch (IOException e) {
            System.out.println("Nao foi possível ler a imagem!");
        }
        /*retorna null se nao conseguir ler*/
        return null;
    }

        public static void exibeImagem(BufferedImage imagemOriginal, BufferedImage imagemResultado1,
                                       BufferedImage imagemResultado2, BufferedImage imagemResultado3){
        if(imagemOriginal == null || imagemResultado1 == null || imagemResultado2 == null || imagemResultado3 == null) {
            System.out.println("A imagem é nula. Verifique o parâmetro e tente novamente.");
        }
            /*Cria jFrame */
            frame = new JFrame("Imagens adaptadas para visão daltônica");

            frame.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

            /*Cria o jLabel para exibir a imagem de entrada */
            /*TO DO: redimensionar o jLabel para ficar menor e centralizado */

            JLabel picLabel1 = new JLabel(new ImageIcon(imagemOriginal));
            JLabel picLabel2 = new JLabel(new ImageIcon(imagemResultado1));
            JLabel picLabel3 = new JLabel(new ImageIcon(imagemResultado2));
            JLabel picLabel4 = new JLabel(new ImageIcon(imagemResultado3));

            //frame.add(picLabel1);
            //frame.add(picLabel2);
            JTabbedPane tabbed = new JTabbedPane();
            frame.setContentPane(tabbed);

            tabbed.addTab("Original", picLabel1);
            tabbed.addTab("Pronatopia", picLabel2);
            tabbed.addTab("Deuteranopia", picLabel3);
            tabbed.addTab("Tritanopia", picLabel4);

            frame.pack();
            frame.setVisible(true);
        }

}

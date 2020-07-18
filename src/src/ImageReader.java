import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ImageReader {
    /*Cria o buffer de leitura da imagem*/
    static BufferedImage img = null;
    /*Cria o jFrame para exibir a imagem*/
    static JFrame frame = null;

    public static BufferedImage LeImagem(){
        /*Metodos static que retorna uma imagem dado um caminho*/
        /*TO DO: Alterar para receber imagem como parametro*/
        try {
            img = ImageIO.read(new File("C:\\Users\\horte\\OneDrive\\Imagens\\olhandopcima.jpg"));
            /*Tenta ler a imagem, se conseguir, retorna */
            return img;
        } catch (IOException e) {
            System.out.println("Nao foi possível ler a imagem!");
        }
        /*retorna null se nao conseguir ler*/
        return null;
        }

    public static void main(String[] args) {
        /*Cria jFrame */
        frame = new JFrame("Imagem");

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        /*Cria o jLabel para exibir a imagem de entrada */
        /*TO DO: redimensionar o jLabel para ficar menor e centralizado */
        JLabel picLabel = new JLabel(new ImageIcon(LeImagem()));
        frame.add(picLabel);
        frame.pack();
        frame.setVisible(true);
    }
}

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                try {
                    Achtergrond background = new Achtergrond();
                    URL url = new URL("https://imgur.com/cFn08Ra.jpg");
                    BufferedImage image = ImageIO.read(url);
                    background.setBackground( image);
                    Algoritme algoritme = new Algoritme(background);
                } catch(IOException e){
                    e.printStackTrace();
                }

                }
        });
    }
}
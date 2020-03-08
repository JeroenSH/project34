import javax.swing.SwingUtilities;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
public class App{

    public static void main(String[] args) {
      GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice device = graphics.getDefaultScreenDevice();
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Algoritme algoritme = new Algoritme();           
             device.setFullScreenWindow(algoritme);
            }
        });
    }
}
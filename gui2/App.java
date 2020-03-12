import java.util.Date;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Algoritme algoritme = new Algoritme();

            }
        });
    }
}
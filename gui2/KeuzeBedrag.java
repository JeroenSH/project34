import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
public class KeuzeBedrag extends JFrame{
    private JButton btn;
public KeuzeBedrag(){
    GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();
    setLayout(new BorderLayout());

    btn = new JButton("click me");
    add(btn,BorderLayout.SOUTH);

    btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0){
            Startscherm start = new Startscherm();
            device.setFullScreenWindow(start);    
         }
    });

    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
}
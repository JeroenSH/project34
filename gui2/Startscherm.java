import javax.swing.*;
import java.awt.*; 
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.*; 
public class Startscherm extends JFrame{
    private JButton btn;
    
public Startscherm(){
    GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice device = graphics.getDefaultScreenDevice();
    setLayout(new BorderLayout());

    btn = new JButton("click me");


    btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0){
            KeuzeBedrag keuze = new KeuzeBedrag();
            device.setFullScreenWindow(keuze);        
         }
    });
    
    add(btn,BorderLayout.CENTER);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
}


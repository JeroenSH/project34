import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.io.*;

public class Startscherm extends JPanel implements ActionListener{
    private JButton login;
    private JButton taal;

    private Dimension preferredSize;
    private Font font;
    private Color color;
    private Color bgcolor;
    private StringListener textListener;

public Startscherm() {
    setOpaque(false);
    setLayout(new GridBagLayout());
    preferredSize = new Dimension(400,100);
    font = new Font("Arial", Font.PLAIN, 40);
    color = new Color(0,255,0);


  //  bgcolor = new Color(255,0,0);
  //  setBackground(bgcolor);

    login = new JButton("Start");
    login.addActionListener(this);
    login.setPreferredSize(preferredSize);
    login.setFont(font);
    login.setBackground(color);

    taal = new JButton("Taal");
    taal.addActionListener(this);
    taal.setPreferredSize(preferredSize);
   taal.setFont(font);
    taal.setBackground(color);
    
    GridBagConstraints gc = new GridBagConstraints();
    gc.weightx = 1;
    gc.weighty = 1;
    gc.fill = GridBagConstraints.NONE;
///////////////first row////////////////////////////
    gc.gridx = 0;
    gc.gridy = 0;
    add(login,gc);
    
    ///////////////second row//////////////////
    gc.gridx = 0;
    gc.gridy = 1;
   // add(taal,gc);

   // add(new JLabel(new ImageIcon("Achtergrond.jpg")));
}

public void setStringListener(StringListener textlistener){
    this.textListener = textlistener;
}

public void actionPerformed(ActionEvent e){
    JButton clicked = (JButton)e.getSource();
    if(clicked == login){
            textListener.textEmitted("login");
    } else if(clicked == taal){
        textListener.textEmitted("taal");
}


}

}


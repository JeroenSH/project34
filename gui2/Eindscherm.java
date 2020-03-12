import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class Eindscherm extends JPanel implements ActionListener{
    
    private JLabel eindtekst;

    private Dimension preferredSize;
    private Font font;
    private Color color;
    private Color bgcolor;

    private StringListener textListener;
public Eindscherm(){
    setLayout(new GridBagLayout());
    preferredSize = new Dimension(400,100);
    font = new Font("Arial", Font.PLAIN, 40);
    color = new Color(0,255,0);
    bgcolor = new Color(255,0,0);
    setBackground(bgcolor);

    eindtekst = new JLabel("Bedankt voor het pinnen bij DeMuur");
    eindtekst.setFont(font);
    
    GridBagConstraints gc = new GridBagConstraints();
    gc.weightx = 1;
    gc.weighty = 1;
    gc.fill = GridBagConstraints.NONE;
///////////////first row////////////////////////////
    gc.gridx = 0;
    gc.gridy = 0;
    add(eindtekst,gc);
    
}

public void setStringListener(StringListener textlistener){
    this.textListener = textlistener;
}


public void actionPerformed(ActionEvent e){
    JButton clicked = (JButton)e.getSource();
}
}


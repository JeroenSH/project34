import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class Taal extends JPanel implements ActionListener{
    private JButton engels;
    private JButton afbreken;

    private Dimension preferredSize;
    private Font font;
    private Color color;
    private Color bgcolor;

    private StringListener textListener;

public Taal(){
    setLayout(new GridBagLayout());

    preferredSize = new Dimension(400,100);
    font = new Font("Arial", Font.PLAIN, 40);
    color = new Color(0,255,0);
    bgcolor = new Color(255,0,0);
    setBackground(bgcolor);

    engels = new JButton("Engels");
    engels.addActionListener(this);
    engels.setPreferredSize(preferredSize);
    engels.setFont(font);
    engels.setBackground(color);

    afbreken = new JButton("Afbreken");
    afbreken.addActionListener(this);
    afbreken.setPreferredSize(preferredSize);
    afbreken.setFont(font);
    afbreken.setBackground(color);
    
    GridBagConstraints gc = new GridBagConstraints();
    gc.weightx = 1;
    gc.weighty = 1;
    gc.fill = GridBagConstraints.NONE;
///////////////first row////////////////////////////
    gc.gridx = 0;
    gc.gridy = 0;
    add(engels,gc);
    
    ///////////////second row//////////////////
    gc.gridx = 0;
    gc.gridy = 1;
    add(afbreken,gc);

}

public void setStringListener(StringListener textlistener){
    this.textListener = textlistener;
}

public void actionPerformed(ActionEvent e){
    JButton clicked = (JButton)e.getSource();
    if(clicked == engels){
            textListener.textEmitted("engels");
    } else if(clicked == afbreken){
        textListener.textEmitted("afbreken");
    }


}

}


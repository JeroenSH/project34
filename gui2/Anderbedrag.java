import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class Anderbedrag extends JPanel implements ActionListener{
    private JButton afbreken;
    private JButton menu;

    private JLabel tekst;

    private Dimension preferredSize;
    private Font font;
    private Color color;
    private Color bgcolor;

    private StringListener textListener;
public Anderbedrag(){
    setLayout(new GridBagLayout());
    preferredSize = new Dimension(200, 100);
        font = new Font("Arial", Font.PLAIN, 40);
        color = new Color(0, 255, 0);
        bgcolor = new Color(255, 0, 0);
        setBackground(bgcolor);


    tekst = new JLabel("Vul hier uw bedrag in");
    tekst.setFont(font);
    
    //buttons aanmaken
    afbreken = new JButton("Afbreken");
    afbreken.setPreferredSize(preferredSize);
    afbreken.setFont(font);
    afbreken.setBackground(color);
    afbreken.addActionListener(this);

    menu = new JButton("Menu");
    menu.setPreferredSize(preferredSize);
    menu.setFont(font);
    menu.setBackground(color);
    menu.addActionListener(this);

    GridBagConstraints gc = new GridBagConstraints();
    gc.weightx = 1;
    gc.weighty = 1;
    gc.gridx = 0;
    gc.gridy = 0;
    gc.gridwidth = 2;
    add(tekst,gc);

    gc.gridwidth = 1;
    gc.gridx = 0;
    gc.gridy = 1;
    add(afbreken,gc);
    
    gc.gridx = 1;
    add(menu,gc);
}

public void setStringListener(StringListener textlistener){
    this.textListener = textlistener;
}

public void actionPerformed(ActionEvent e){
    JButton clicked = (JButton)e.getSource();
    if(clicked == afbreken){
            textListener.textEmitted("afbreken");
    } else if(clicked == menu){
        textListener.textEmitted("menu");
}


}

}


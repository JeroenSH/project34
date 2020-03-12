import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class Saldo extends JPanel implements ActionListener{
    private JButton afbreken;
    private JButton menu;

    private JLabel saldo;
    private JLabel bedrag;
    private Dimension preferredSize;
    private Font font;
    private Color color;
    private Color bgcolor;

    private String x;

    private StringListener textListener;
public Saldo(){
    setLayout(new GridBagLayout());
    preferredSize = new Dimension(400,100);
    font = new Font("Arial", Font.PLAIN, 40);
    color = new Color(0,255,0);
    bgcolor = new Color(255,0,0);
    setBackground(bgcolor);

    
    //buttons aanmaken
    afbreken = new JButton("afbreken");
    afbreken.addActionListener(this);
    afbreken.setPreferredSize(preferredSize);
    afbreken.setFont(font);
    afbreken.setBackground(color);

    menu = new JButton("menu");
    menu.addActionListener(this);
    menu.setPreferredSize(preferredSize);
    menu.setFont(font);
    menu.setBackground(color);

    //labels aanmaken
    saldo = new JLabel("saldo", SwingConstants.CENTER);
    saldo.setPreferredSize(preferredSize);
    saldo.setFont(font);
    x = "100";
    bedrag = new JLabel(x, SwingConstants.CENTER);
    bedrag.setPreferredSize(preferredSize);
    bedrag.setFont(font);


    GridBagConstraints gc = new GridBagConstraints();
    gc.weightx = 1;
    gc.weighty = 1;
    
//////////////////////first row///////////////////
    gc.gridx = 0;
    gc.gridy = 0;
    gc.gridwidth = 2;
    gc.fill = GridBagConstraints.NONE;
    add(saldo,gc);

    ////////////////////second row //////////////////
    gc.gridy = 1;
    add(bedrag,gc);


    /////////////////////third row///////////////////
    gc.gridy = 2;
    gc.gridwidth = 1;
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


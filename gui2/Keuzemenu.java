import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class Keuzemenu extends JPanel implements ActionListener{
    private final JButton saldo;
    private final JButton bedrag;
    private final JButton afbreken;
    private final JButton snelKeuze;
    private JLabel tekst;

    private Dimension preferredSize;
    private Font font;
    private Color color;
    private Color bgcolor;
    
    private StringListener textListener;
    
    public Keuzemenu() {
        setLayout(new GridBagLayout());
        preferredSize = new Dimension(400,100);
        font = new Font("Arial", Font.PLAIN, 40);
        color = new Color(0,255,0);
        bgcolor = new Color(255,0,0);
        setBackground(bgcolor);

        
        // maak buttons aan
        saldo = new JButton("Saldo");                       //saldo
        saldo.addActionListener(this);
        saldo.setPreferredSize(preferredSize);
        saldo.setFont(font);
        saldo.setBackground(color);

        bedrag = new JButton("Bedrag opnemen");                 //bedrag opnemen
        bedrag.addActionListener(this);
        bedrag.setPreferredSize(preferredSize);
        bedrag.setFont(font);
        bedrag.setBackground(color);

        afbreken = new JButton("Afbreken");                     //afbreken
        afbreken.addActionListener(this);
        afbreken.setPreferredSize(preferredSize);
        afbreken.setFont(font);
        afbreken.setBackground(color);

        snelKeuze = new JButton("snel 70,-");                       //snelkeuze
        snelKeuze.addActionListener(this);
        snelKeuze.setPreferredSize(preferredSize);
        snelKeuze.setFont(font);
        snelKeuze.setBackground(color);
        //   maak tekst aan
        tekst = new JLabel("Maak uw keuze");                            //aanpassen voor verschillende talen
        tekst.setFont(font);
       
        final GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        /////////////// first row/////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(tekst,gc);
        /////////////// second row ///////////////////////////////////////////
        gc.gridwidth = 1;
        gc.gridx = 0;
        gc.gridy = 1;
        add(saldo, gc);

        gc.gridx = 1;
        add(bedrag, gc);

        ///////////////// third row /////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 2;
        add(afbreken, gc);

        gc.gridx = 1;
        add(snelKeuze,gc);

    }

    public void setStringListener(final StringListener textlistener) {
        this.textListener = textlistener;
    }

    public void actionPerformed(final ActionEvent e) {
        final JButton clicked = (JButton) e.getSource();
    if(clicked == saldo){
            textListener.textEmitted("saldo");
    } else if (clicked == bedrag){
        textListener.textEmitted("keuzebedrag");
    }else if (clicked == afbreken){
        textListener.textEmitted("afbreken");
    } else if (clicked == snelKeuze){
        textListener.textEmitted("70");
    }


}

}


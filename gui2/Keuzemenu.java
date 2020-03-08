import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class Keuzemenu extends JPanel implements ActionListener{
    private final JButton saldo;
    private final JButton bedrag;
    private final JButton afbreken;

    private JLabel tekst;

    private Dimension preferredSize;
    
    private StringListener textListener;

    public Keuzemenu() {
        setLayout(new GridBagLayout());
        Dimension preferredSize = new Dimension(200,100);

        // maak buttons aan
        saldo = new JButton("saldo");                       //saldo
        saldo.addActionListener(this);
        saldo.setPreferredSize(preferredSize);

        bedrag = new JButton("bedrag opnemen");                 //bedrag opnemen
        bedrag.addActionListener(this);
        bedrag.setPreferredSize(preferredSize);

        afbreken = new JButton("afbreken");                     //afbreken
        afbreken.addActionListener(this);
        afbreken.setPreferredSize(preferredSize);

        //   maak tekst aan
        tekst = new JLabel("maak uw keuze");                            //aanpassen voor verschillende talen

       
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
    }


}

}


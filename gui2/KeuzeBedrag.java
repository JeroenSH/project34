import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeuzeBedrag extends JPanel implements ActionListener {
    private JButton afbreken;
    private JButton twintig;
    private JButton vijftig;
    private JButton zeventig;
    private JButton honderd;
    private JButton anders;

    private JLabel tekst;
    private Dimension preferredSize;
    private StringListener textListener;

    public KeuzeBedrag() {
        setLayout(new GridBagLayout());
        Dimension preferredSize = new Dimension(200, 100);

        // buttons aanmaken
        afbreken = new JButton("afbreken"); // afbreken
        afbreken.addActionListener(this);
        afbreken.setPreferredSize(preferredSize);

        twintig = new JButton("20"); // 20
        twintig.addActionListener(this);
        twintig.setPreferredSize(preferredSize);

        vijftig = new JButton("50"); // 50
        vijftig.addActionListener(this);
        vijftig.setPreferredSize(preferredSize);

        zeventig = new JButton("70"); // 70
        zeventig.addActionListener(this);
        zeventig.setPreferredSize(preferredSize);

        honderd = new JButton("100"); // 100
        honderd.addActionListener(this);
        honderd.setPreferredSize(preferredSize);

        anders = new JButton("anders"); // anders
        anders.addActionListener(this);
        anders.setPreferredSize(preferredSize);


        //tekst aan maken
        tekst = new JLabel("kies Bedrag");                                    //veranderen voor taalkeuze


        final GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;

        ///////////// first row///////////////////
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(tekst,gc);
        ///////////// second row////////////////////////////
        gc.gridwidth = 1;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        add(twintig, gc);

        gc.gridx = 1;
        add(zeventig,gc);
        
        ////////////// third row//////////////////////
        gc.gridx = 0;
        gc.gridy = 2;
        add(vijftig,gc);

        gc.gridx = 1;
        add(honderd,gc);

        //////////////fourth row/////////////////
        gc.gridx = 0;
        gc.gridy = 3;
        add(afbreken, gc);

        gc.gridx = 1;
        add(anders,gc);
    }

    public void setStringListener(StringListener textlistener) {
        this.textListener = textlistener;
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == afbreken) {
            textListener.textEmitted("afbreken");
        } else if (clicked == anders) {
            textListener.textEmitted("anderbedrag");
        } else{
            textListener.textEmitted("vastbedrag");
        }
    }
}
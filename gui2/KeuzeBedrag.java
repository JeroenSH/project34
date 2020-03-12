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
    private JButton menu;

    private Dimension preferredSize;
    private Font font;
    private Color color;
    private Color bgcolor;

    private JLabel tekst;

    private StringListener textListener;

    public KeuzeBedrag() {
        setLayout(new GridBagLayout());
        preferredSize = new Dimension(200, 100);
        font = new Font("Arial", Font.PLAIN, 40);
        color = new Color(0, 255, 0);
        bgcolor = new Color(255, 0, 0);
        setBackground(bgcolor);

        // buttons aanmaken
        afbreken = new JButton("afbreken"); // afbreken
        afbreken.addActionListener(this);
        afbreken.setPreferredSize(preferredSize);
        afbreken.setFont(font);
        afbreken.setBackground(color);

        menu = new JButton("menu"); // afbreken
        menu.addActionListener(this);
        menu.setPreferredSize(preferredSize);
        menu.setFont(font);
        menu.setBackground(color);

        twintig = new JButton("20"); // 20
        twintig.addActionListener(this);
        twintig.setPreferredSize(preferredSize);
        twintig.setFont(font);
        twintig.setBackground(color);

        vijftig = new JButton("50"); // 50
        vijftig.addActionListener(this);
        vijftig.setPreferredSize(preferredSize);
        vijftig.setFont(font);
        vijftig.setBackground(color);

        zeventig = new JButton("70"); // 70
        zeventig.addActionListener(this);
        zeventig.setPreferredSize(preferredSize);
        zeventig.setFont(font);
        zeventig.setBackground(color);

        honderd = new JButton("100"); // 100
        honderd.addActionListener(this);
        honderd.setPreferredSize(preferredSize);
        honderd.setFont(font);
        honderd.setBackground(color);

        anders = new JButton("anders"); // anders
        anders.addActionListener(this);
        anders.setPreferredSize(preferredSize);
        anders.setFont(font);
        anders.setBackground(color);

        // tekst aan maken
        tekst = new JLabel("kies Bedrag"); // veranderen voor taalkeuze
        tekst.setFont(font);
        tekst.setBackground(color);

        final GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        ///////////// first row///////////////////
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(tekst, gc);
        ///////////// second row////////////////////////////
        gc.gridwidth = 1;
        gc.gridx = 0;
        gc.gridy = 1;
        add(twintig, gc);

        gc.gridx = 1;
        add(zeventig, gc);

        ////////////// third row//////////////////////
        gc.gridx = 0;
        gc.gridy = 2;
        add(vijftig, gc);

        gc.gridx = 1;
        add(honderd, gc);

        ////////////// fourth row/////////////////
       
        gc.gridy = 3;
        gc.gridx = 1;
        add(anders, gc);
        
        gc.gridx = 0;
        gc.gridy = 4;
        add(afbreken, gc);


        gc.gridy = 4;
        gc.gridx = 1;
        add(menu,gc);
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
        } else if (clicked == menu) {
            textListener.textEmitted("menu");
        } else {
            textListener.textEmitted("vastbedrag");
        }
    }
}
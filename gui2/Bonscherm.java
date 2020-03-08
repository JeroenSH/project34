import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bonscherm extends JPanel implements ActionListener {
    private JButton wel;
    private JButton niet;

    private JLabel tekst;

    private StringListener textListener;
    private Dimension preferredSize;

    public Bonscherm() {
        setLayout(new GridBagLayout());
        Dimension preferredSize = new Dimension(200, 100);

        // maak de buttons aan
        wel = new JButton("ja");                                                            //wel bon button
        wel.addActionListener(this);
        wel.setPreferredSize(preferredSize);

        niet = new JButton("nee");                                                          //geen bon button
        niet.addActionListener(this);
        niet.setPreferredSize(preferredSize);

        //maak tekst aan
        tekst = new JLabel("wilt u de bon");

        final GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        //////////// first row /////////////
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(tekst,gc);
        /////////// second row//////////////
        gc.gridwidth = 1;
        gc.gridy = 1;
        gc.gridx = 0;
        add(wel, gc);
        gc.gridx = 1;
        add(niet, gc);

    }

    public void setStringListener(StringListener textlistener) {
        this.textListener = textlistener;
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == wel) {
            textListener.textEmitted("wel");
        }
        if (clicked == niet) {
            textListener.textEmitted("niet");
        }

    }

}

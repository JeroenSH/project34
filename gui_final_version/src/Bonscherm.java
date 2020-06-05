import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bonscherm extends JPanel implements ActionListener {
    private JButton wel;
    private JButton niet;

    private JLabel tekst;

    private Dimension preferredSize;
    private Font font;
    private Color color;
    private Color bgcolor;

    private StringListener textListener;

    public Bonscherm() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        preferredSize = new Dimension(200, 100);
        font = new Font("Arial", Font.PLAIN, 40);
        color = new Color(0, 255, 0);
        bgcolor = new Color(255, 0, 0);
        setBackground(bgcolor);

        // maak de buttons aan
        wel = new JButton("ja"); // wel bon button
        wel.addActionListener(this);
        wel.setPreferredSize(preferredSize);
        wel.setFont(font);
        wel.setBackground(color);

        niet = new JButton("nee"); // geen bon button
        niet.addActionListener(this);
        niet.setPreferredSize(preferredSize);
        niet.setFont(font);
        niet.setBackground(color);

        // maak tekst aan
        tekst = new JLabel("wilt u de bon");
        tekst.setFont(font);

        final GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        //////////// first row /////////////
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(tekst, gc);
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
        try{
        JButton clicked = (JButton) e.getSource();
        if (clicked == wel) {
            textListener.textEmitted("wel");
        }
        if (clicked == niet) {
            textListener.textEmitted("niet");
        }
    }catch(Exception ex){
        ex.printStackTrace();
    }
    }
}

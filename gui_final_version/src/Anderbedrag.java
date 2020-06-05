import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class Anderbedrag extends JPanel implements ActionListener {
    private JButton afbreken;
    private JButton menu;
    private JTextField bedrag;
    private JLabel tekst;
    private JLabel tekst2;
    private Dimension preferredSize;
    private Font font;
    private Font font2;
    private Color color;
    private Color bgcolor;

    private StringListener textListener;

    public Anderbedrag() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        preferredSize = new Dimension(200, 100);
        font = new Font("Arial", Font.PLAIN, 40);
        font2 = new Font("Arial", Font.ITALIC, 20);
        color = new Color(0, 255, 0);
        bgcolor = new Color(255, 0, 0);
        setBackground(bgcolor);


        tekst = new JLabel("Vul hier uw bedrag in");
        tekst.setFont(font);


        tekst2 = new JLabel("alleen tientallen tussen de 10 en 250 euro");
        tekst2.setFont(font2);
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


        bedrag = new JTextField(4);
        bedrag.setFont(font);
        bedrag.addActionListener(this);

        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        add(tekst, gc);

        gc.gridy = 1;
        add(tekst2, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        add(bedrag, gc);


        gc.gridwidth = 1;
        gc.gridx = 0;
        gc.gridy = 3;
        add(afbreken, gc);

        gc.gridx = 1;
        add(menu, gc);
    }

    public void setStringListener(StringListener textlistener) {
        this.textListener = textlistener;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            System.out.println(e.getActionCommand());
            if (e.getActionCommand().equalsIgnoreCase("menu") || e.getActionCommand().equalsIgnoreCase("afbreken")) {
                JButton clicked = (JButton) e.getSource();
                if (clicked == afbreken) {
                    textListener.textEmitted("afbreken");
                } else if (clicked == menu) {
                    textListener.textEmitted("menu");
                }
            } else {
                JTextField input = (JTextField) e.getSource();
                String bedraginput = input.getText();
                if (Integer.parseInt(bedraginput) <= 250 && Integer.parseInt(bedraginput) >= 10 && Integer.parseInt(bedraginput) % 10 == 0) {
                    textListener.textEmitted(bedraginput);
                    bedrag.setText(null);
                } else {
                    //maak bedrag leeg
                    bedrag.setText(null);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

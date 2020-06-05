import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Blokkeerscherm extends JPanel implements ActionListener{
        private JButton afbreken;
        private JButton menu;

        private JLabel tekst;

        private Dimension preferredSize;
        private Font font;
        private Color color;
        private Color bgcolor;

        private StringListener textListener;

        public Blokkeerscherm() {
            setOpaque(false);
            setLayout(new GridBagLayout());
            preferredSize = new Dimension(200, 100);
            font = new Font("Arial", Font.PLAIN, 40);
            color = new Color(0, 255, 0);
            bgcolor = new Color(255, 0, 0);
            setBackground(bgcolor);

            // maak de buttons aan
            afbreken = new JButton("afbreken"); // wel bon button
            afbreken.addActionListener(this);
            afbreken.setPreferredSize(preferredSize);
            afbreken.setFont(font);
            afbreken.setBackground(color);

            // maak tekst aan
            tekst = new JLabel("Uw pas is geblokkeerd");
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
            add(afbreken, gc);
        }

        public void setStringListener(StringListener textlistener) {
            this.textListener = textlistener;
        }

        public void actionPerformed(ActionEvent e) {
            try{
            JButton clicked = (JButton) e.getSource();
            if (clicked == afbreken) {
                textListener.textEmitted("afbreken");
            }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }



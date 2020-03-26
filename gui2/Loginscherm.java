import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class Loginscherm extends JPanel implements ActionListener {

    private JLabel tekst;
    private JPasswordField login;
    private JLabel label;

    private int count;
    private boolean geblokkeerd = false;
    private String password = "1111";
    private Color bgcolor;
    private Color color;
    private Font font;
    private Border border;

    private StringListener textListener;

    public Loginscherm() {
        setLayout(new GridBagLayout());
        bgcolor = new Color(255, 0, 0);
        color = new Color(0, 255, 0);
        font = new Font("Arial", Font.PLAIN, 100);
        border = BorderFactory.createLineBorder(color, 1);

        setBackground(bgcolor);

        tekst = new JLabel("Voer uw pin in");
        tekst.setFont(font);

        label = new JLabel("");
        label.setFont(font);
        label.setOpaque(true);
        label.setBorder(border);
        label.setBackground(color);

        String x = "";

        // password field
        login = new JPasswordField(4);
        login.setFont(font);
        login.setEchoChar('*');
        login.addActionListener(this);

        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        add(tekst, gc);

        gc.gridy = 1;
        add(login, gc);

    }

    public void setStringListener(StringListener textlistener) {
        this.textListener = textlistener;
    }

    public void actionPerformed(ActionEvent e) {
        JPasswordField input = (JPasswordField) e.getSource();
        char[] passchar = input.getPassword();
        String pass = new String(passchar);

        if (!geblokkeerd) {
            if (pass.equals(password)) {
                textListener.textEmitted("keuzemenu");
                login.setText("");
            } else {
                if (count == 2) {
                    tekst.setText("u heeft uw pascode te vaak verkeerd ingevoerd");
                    count = 0;
                    geblokkeerd = true;
                } else
                    tekst.setText("password incorrect voer uw pas opnieuw in");
                login.setText("");
                count += 1;
            }
        } else {
            System.out.println("pas geblokkeerd");
        }
    }

}

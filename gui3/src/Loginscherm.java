import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.border.Border;
public class Loginscherm extends JPanel implements ActionListener {

    private JLabel tekst;
    private CustomTextField username;
    private JPasswordField login;
    private JLabel label;

    private int count;
    private boolean geblokkeerd = false;
    private String password = "1234";
    private String rekeningnmr;
    private Color bgcolor;
    private Color color;
    private Font font;
    private Border border;
    private StringListener textListener;



    public Loginscherm() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        //  bgcolor = new Color(255, 0, 0);
        color = new Color(0, 255, 0);
        font = new Font("Arial", Font.PLAIN, 100);
        border = BorderFactory.createLineBorder(color, 1);

        //setBackground(bgcolor);

        tekst = new JLabel("Voer uw pin in");
        tekst.setFont(font);

        label = new JLabel("");
        label.setFont(font);
        String x = "";

        // username field
        username = new CustomTextField(10);
        username.setFont(font);
        username.setPlaceholder("rekeningnummer");
        username.addActionListener(this);

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
        add(label, gc);
        gc.gridy = 2;
        add(username, gc);

        gc.gridy = 3;
        add(login, gc);

    }

    public void setStringListener(StringListener textlistener) {
        this.textListener = textlistener;
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JPasswordField) {
            JPasswordField input = (JPasswordField) e.getSource();
            char[] passchar = input.getPassword();
            password = new String(passchar);
            textListener.textEmitted("password");
        } else if (obj instanceof CustomTextField) {
            System.out.println("textfield");
            JTextField input = (JTextField) e.getSource();
            rekeningnmr = input.getText();
            textListener.textEmitted("rekeningnmr");
        }
    }

    public String getRekeningnmr() {
        return rekeningnmr;
    }

    public String getPassword() {
        return password;
    }

    public void emptyFields() {
        username.setText("");
        login.setText("");
        label.setText("");
    }

    public void fout() {
        label.setText("pin verkeerd ingevoerd");
    }


}


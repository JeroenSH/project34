import javafx.scene.text.Text;

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
    private JButton confirm;
    private int count;
    private boolean geblokkeerd = false;
    private String password = null;
    private String rekeningnmr;
    private Color bgcolor;
    private Dimension preferredSize;
    private Color color;
    private Font font;
    private Font font2;
    private Border border;
    private StringListener textListener;



    public Loginscherm() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        //  bgcolor = new Color(255, 0, 0);
        color = new Color(0, 255, 0);
        font = new Font("Arial", Font.PLAIN, 100);
        font2 = new Font("Arial", Font.PLAIN, 40);
        border = BorderFactory.createLineBorder(color, 1);
        preferredSize = new Dimension(300, 150);

        //setBackground(bgcolor);

        tekst = new JLabel("Voer uw pin in");
        tekst.setFont(font);

        label = new JLabel("");
        label.setFont(font);
        String x = "";

        // username field
        username = new CustomTextField(12);
        username.setFont(font);
        username.setPlaceholder("rekeningnummer");
        username.addActionListener(this);

        // password field
        login = new JPasswordField(4);
        login.setFont(font);
        login.setEchoChar('*');
        login.addActionListener(this);

        confirm = new JButton("Bevestigen"); // afbreken
        confirm.addActionListener(this);
        confirm.setPreferredSize(preferredSize);
        confirm.setFont(font2);
        confirm.setBackground(color);

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

        gc.gridy = 4;
        add(confirm,gc);

    }

    public void setStringListener(StringListener textlistener) {
        this.textListener = textlistener;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            JButton clicked = (JButton) e.getSource();
            if(clicked == confirm){
                rekeningnmr = username.getText();
                char[] passchar = login.getPassword();
                password = new String(passchar);
                  textListener.textEmitted("confirm");

//                System.out.println("textfield");
//                JTextField inputtext = (JTextField) e.getSource();
//                rekeningnmr = inputtext.getText();
//                textListener.textEmitted("rekeningnmr");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public String getRekeningnmr() {
        return rekeningnmr;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(){
        password = null;
    }

    public void emptyFields() {
        username.setText("");
        login.setText("");
        label.setText("");
    }

    public void fout() {
        label.setText("pin of rekening verkeerd");
    }



}


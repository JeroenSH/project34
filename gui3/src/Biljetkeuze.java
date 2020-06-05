import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Biljetkeuze extends JPanel implements ActionListener {
    private JButton optie1;
    private JButton optie2;
    private JButton optie3;
    private JButton invButton;

    private JLabel text1;

    private JLabel keuze;
    private Dimension preferredSize;
    private Font font;
    private Color color;
    private Color bgcolor;

    private StringListener textListener;

    private int bedrag;
    private int bedrag2;
    private int vijftig;
    private int twintig;
    private int tien;
    private String optie;
    public Biljetkeuze() {
    }

    public void settings() {
        setOpaque(false);
        vijftig = 0;
        twintig = 0;
        tien = 0;
        removeAll();
        setLayout(new GridBagLayout());
        preferredSize = new Dimension(400, 200);
        font = new Font("Arial", Font.PLAIN, 40);
        color = new Color(0, 255, 0);
        bgcolor = new Color(255, 0, 0);
        setBackground(bgcolor);


        //buttons aanmaken
        bedrag2 = bedrag;
        int a = setVijftig();
        int b = setTwintig();
        int c = setTien();
        if(a != 0 ) {
            optie1 = new JButton("<html><center>Vijftig: " + a + "<br>Twintig: " + b + "<br>Tien: " + c + "<center></html>");
        } else if(b != 0) {
            optie1 = new JButton("<html><center><br>Twintig: " + b + "<br>Tien: " + c + "<center></html>");
        } else{
            optie1 = new JButton("<html><center><br><br>Tien: " + c + "<center></html>");

        }
        optie1.addActionListener(this);
        optie1.setPreferredSize(preferredSize);
        optie1.setFont(font);
        optie1.setBackground(color);
        bedrag2 = bedrag;

        b = setTwintig();
        c = setTien();
        if(b != 0){
            optie2 = new JButton("<html><center><br>Twintig: " + b +  "<br>Tien: " + c + "<center></html>");

        } else {
            optie2 = new JButton("<html><center><br><br>Tien: " + c + "<center></html>");
        }
        optie2.addActionListener(this);
        optie2.setPreferredSize(preferredSize);
        optie2.setFont(font);
        optie2.setBackground(color);

        bedrag2 = bedrag;
        optie3 = new JButton("<html><center><br><br>Tien: " + setTien() + "<center></html>");
        optie3.addActionListener(this);
        optie3.setPreferredSize(preferredSize);
        optie3.setFont(font);
        optie3.setBackground(color);

        //labels aanmaken
        keuze = new JLabel("maak uw keuze", SwingConstants.CENTER);
        keuze.setPreferredSize(preferredSize);
        keuze.setFont(font);

        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;

//////////////////////first row///////////////////
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 4;
        gc.fill = GridBagConstraints.NONE;
        add(keuze, gc);

        ////////////////////second row //////////////////
        gc.gridwidth =1;
        gc.gridy = 1;
        gc.gridx = 1;
        add(optie1, gc);

        gc.gridx = 2;
        add(optie2, gc);

        gc.gridx = 3;
        add(optie3,gc);
    }

    public void setStringListener(StringListener textlistener) {
        this.textListener = textlistener;
    }

    public int setVijftig(){

        int x = 0;
        while (bedrag2 >= 50) {
            x++;
            bedrag2 -= 50;
        }
        vijftig = x;
        return x;
    }


    public int setTwintig(){
        int x = 0;
        while (bedrag2 >= 20) {
            x++;
            bedrag2 -= 20;
        }
        twintig = x;
        return x;
    }


    public int setTien(){
        int x = 0;
        while (bedrag2 >= 10){
            x++;
            bedrag2-=10;
        }
        tien = x;
        return x;
    }

    public void setBedrag(int bedrag){
        this.bedrag = bedrag;
    }

    public void setbedrag2(){
        this.bedrag2 = bedrag;
    }
    public int getVijftig(){
    return vijftig;
    }

    public int getTwintig(){
    return twintig;
    }

    public int getTien(){
    return tien;
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if(clicked == optie1) {
            textListener.textEmitted("optie1");
        } else if(clicked == optie2){
            textListener.textEmitted("optie2");
        }else if(clicked == optie3){
            textListener.textEmitted("optie3");
        }
    }

}



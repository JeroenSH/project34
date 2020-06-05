import javafx.geometry.VerticalDirection;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bon extends JPanel {
    private JLabel text;
    private JLabel bedrag;
    private JLabel labeladres;
    private JLabel labeldatum;
    private JLabel rekeningNmr;

    private Font font;
    private Font font2;
    private Dimension preferredSize;
    private Color color;
    private String[] rekeningNummer;
    private String bonBedrag = "";
    private String adres = "wijnhaven 107 Rotterdam";
    private String datum;

    public Bon() {
    }
    public void settings(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        datum = dtf.format(now);
        setOpaque(true);
        removeAll();
        setLayout(new GridBagLayout());
        color = new Color(255, 255, 255);
        this.setBackground(color);
        preferredSize = new Dimension(400, 50);
        font = new Font("Arial", Font.PLAIN, 40);
        font2 = new Font("Arial", Font.PLAIN, 20);

        text = new JLabel("Bon", SwingConstants.CENTER);
        text.setFont(font);
        rekeningNmr = new JLabel("Rekeningnummer: " + rekeningNummer[0] + "-" + rekeningNummer[1] + "-" + rekeningNummer[2], SwingConstants.CENTER);
        rekeningNmr.setFont(font2);

        labeladres = new JLabel("<HTML><CENTER>Adres: " + adres + "<br>Land: Oud Zeeland<CENTER></HTML>", SwingConstants.CENTER);
        labeladres.setFont(font2);

        labeldatum = new JLabel("Datum: " + dtf.format(now) , SwingConstants.CENTER);
        labeldatum.setFont(font2);

        bedrag = new JLabel("Bedrag: "+ bonBedrag, SwingConstants.CENTER);
        bedrag.setFont(font2);


        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty = 1;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 0;
        gc.gridy = 0;
        add(text,gc);
        gc.gridy = 1;
        add(labeladres,gc);
        gc.gridy = 2;
        add(labeldatum,gc);
        gc.gridy = 3;
        add(rekeningNmr,gc);
        gc.gridy = 4;
        add(bedrag,gc);

    }


    public void setBon(int bedrag, String rekeningnummer) {
        bonBedrag = Integer.toString(bedrag);
        rekeningNummer = rekeningnummer.split("-");
        rekeningNummer[2] = "****"+ rekeningNummer[2].substring(rekeningNummer[2].length() - 4);
        //rekeningNummer = "rekeningnummer: ************" + rekeningnummer.substring(rekeningnummer.length() -4);
    }
}
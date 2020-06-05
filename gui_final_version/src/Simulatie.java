import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Simulatie extends JPanel implements ActionListener{
    private JButton volgende;

    private JLabel brieftien;
    private JLabel brieftwintig;
    private JLabel briefvijftig;
    private JLabel tienimage;
    private JLabel twintigimage;
    private JLabel vijftigimage;

    private Dimension preferredSize;
    private Dimension imagepreferredSize;
    private Font font;
    private Font font2;
    private Color color;
    private Color bgcolor;

    private String tien = "0 X";
    private String twintig = "0 X";
    private String vijftig = "0 X";

    private boolean bonkeuze;
    private StringListener textListener;
    public Simulatie(){}

    public void settings(Bon bon) {
        setOpaque(false);
        removeAll();
        setLayout(new GridBagLayout());
        preferredSize = new Dimension(400, 100);
        imagepreferredSize = new Dimension(400, 200);
        font = new Font("Arial", Font.PLAIN, 40);
        font2 = new Font("Arial", Font.PLAIN, 10);
        color = new Color(0, 255, 0);
        bgcolor = new Color(255, 0, 0);
        setBackground(bgcolor);

        //buttons aanmaken
        volgende = new JButton("volgende");
        volgende.addActionListener(this);
        volgende.setPreferredSize(preferredSize);
        volgende.setFont(font);
        volgende.setBackground(color);

        //labels aanmaken
        brieftien = new JLabel(tien, SwingConstants.CENTER);
        brieftien.setPreferredSize(imagepreferredSize);
        brieftien.setFont(font);

        brieftwintig = new JLabel(twintig, SwingConstants.CENTER);
        brieftwintig.setPreferredSize(imagepreferredSize);
        brieftwintig.setFont(font);

        briefvijftig = new JLabel(vijftig, SwingConstants.CENTER);
        briefvijftig.setPreferredSize(imagepreferredSize);
        briefvijftig.setFont(font);
        try {
            URL url = new URL("https://imgur.com/sDMIimI.jpg");
            URL url2 = new URL("https://imgur.com/10IiaWe.jpg");
            URL url3 = new URL("https://imgur.com/VrhubVS.jpg");


            ImageIcon icon10 = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));
        tienimage = new JLabel(icon10, JLabel.CENTER);
        tienimage.setPreferredSize(imagepreferredSize);

        ImageIcon icon20 = new ImageIcon(new ImageIcon(url2).getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));;
        twintigimage = new JLabel(icon20, JLabel.CENTER);
        twintigimage.setPreferredSize(imagepreferredSize);

        ImageIcon icon50 = new ImageIcon(new ImageIcon(url3).getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));;
        vijftigimage = new JLabel(icon50, JLabel.CENTER);
        vijftigimage.setPreferredSize(imagepreferredSize);

        } catch(Exception e){
            e.printStackTrace();
        }
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        bon.setBorder(border);
        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty =1;
        gc.weightx = 1;
        gc.gridheight = 5;
        gc.fill = GridBagConstraints.BOTH;
        if(bonkeuze){
            gc.gridx = 0;
            gc.gridy = 0;
            add(bon,gc);
        }


        gc.gridheight = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.EAST;
        gc.gridx = 1;
        gc.gridy = 0;
        add(brieftien, gc);
        gc.gridy = 2;
        add(brieftwintig, gc);
        gc.gridy = 4;
        add(briefvijftig, gc);

        gc.anchor = GridBagConstraints.WEST;

        gc.gridx = 2;
        gc.gridy = 0;
        add(tienimage,gc);
        gc.gridy = 2;
        add(twintigimage,gc);
        gc.gridy = 4;
        add(vijftigimage,gc);

        gc.anchor = GridBagConstraints.CENTER;
        gc.gridwidth = 3;
        gc.gridx = 0;
        gc.gridy = 6;
        add(volgende, gc);


    }

    public void setStringListener(StringListener textlistener){
        this.textListener = textlistener;
    }

    public void actionPerformed(ActionEvent e){
        try{
        JButton clicked = (JButton)e.getSource();
        if(clicked == volgende){
            textListener.textEmitted("volgende");
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void setTien(int tien) {
        this.tien = Integer.toString(tien) + " X";
    }
    public void setTwintig(int twintig) {
        this.twintig = Integer.toString(twintig) + " X";
    }
    public void setVijftig(int vijftig) {
        this.vijftig = Integer.toString(vijftig) + " X";
    }

    public void setBonkeuze(boolean bonkeuze){
        this.bonkeuze = bonkeuze;
    }
}



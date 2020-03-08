import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class Anderbedrag extends JPanel implements ActionListener{
    private JButton afbreken;
    private StringListener textListener;
public Anderbedrag(){
    setLayout(new BorderLayout());

    afbreken = new JButton("ander bedrag ingevuld");
    afbreken.addActionListener(this);
    add(afbreken,BorderLayout.CENTER);
}

public void setStringListener(StringListener textlistener){
    this.textListener = textlistener;
}

public void actionPerformed(ActionEvent e){
    JButton clicked = (JButton)e.getSource();
    if(clicked == afbreken){
            textListener.textEmitted("afbreken");
    }


}

}


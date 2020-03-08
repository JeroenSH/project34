import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class Startscherm extends JPanel implements ActionListener{
    private JButton login;
    private StringListener textListener;
public Startscherm(){
    setLayout(new BorderLayout());

    login = new JButton("klik ergens op het scherm op door te gaan");
    login.addActionListener(this);
    add(login,BorderLayout.CENTER);
}

public void setStringListener(StringListener textlistener){
    this.textListener = textlistener;
}

public void actionPerformed(ActionEvent e){
    JButton clicked = (JButton)e.getSource();
    if(clicked == login){
            textListener.textEmitted("login");
    }


}

}


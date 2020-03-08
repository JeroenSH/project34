import java.awt.*;
import javax.swing.*;

public class Algoritme extends JFrame{
    private Startscherm startScherm;
    private KeuzeBedrag keuzeBedrag;
    private Loginscherm login;
    private Keuzemenu keuzeMenu;
    private Saldo saldo;
    private Anderbedrag anderBedrag;
    private Bonscherm bon;

    public Algoritme(){
        super("gui voor DeMuur");
        setLayout(new BorderLayout());
        startScherm = new Startscherm();
        keuzeBedrag = new KeuzeBedrag();
        login = new Loginscherm();
        keuzeMenu = new Keuzemenu();
        saldo = new Saldo();
        anderBedrag = new Anderbedrag();
        bon = new Bonscherm();
        
        startScherm.setStringListener(new StringListener(){
            public void textEmitted(String text){
                getContentPane().removeAll();                   //maak de JFrame leeg
                if(text.toLowerCase().trim().equals("login")){
                add(login,BorderLayout.CENTER);
                }

                revalidate();                               //teken hem opnieuw
                repaint();
            
            }
        });

        login.setStringListener(new StringListener(){
            public void textEmitted(String text){
                getContentPane().removeAll();                   //maak de JFrame leeg
                if(text.toLowerCase().trim().equals("login")){
                add(keuzeMenu,BorderLayout.CENTER);
                }

                revalidate();                               //teken hem opnieuw
                repaint();
            
            }
        });
        keuzeMenu.setStringListener(new StringListener(){
            public void textEmitted(String text){
                getContentPane().removeAll();                   //maak de JFrame leeg
                if(text.toLowerCase().trim().equals("keuzebedrag")){
                add(keuzeBedrag,BorderLayout.CENTER);
                } else if(text.toLowerCase().trim().equals("saldo")){
                    add(saldo,BorderLayout.CENTER);
                    }if(text.toLowerCase().trim().equals("afbreken")){
                        add(startScherm,BorderLayout.CENTER);
                        }
                
                revalidate();                               //teken hem opnieuw
                repaint();
            
            }
        });
        keuzeBedrag.setStringListener(new StringListener(){
            public void textEmitted(String text){
                getContentPane().removeAll();                   //maak de JFrame leeg

                if(text.toLowerCase().trim().equals("afbreken")){
                add(startScherm,BorderLayout.CENTER);
                } else if(text.toLowerCase().trim().equals("anderbedrag")){
                    add(anderBedrag,BorderLayout.CENTER);
                    } else if(text.toLowerCase().trim().equals("vastbedrag")){
                        add(bon,BorderLayout.CENTER);
                    }
                
                revalidate();                                   //teken hem opnieuw
                repaint();
               
            }
        });
        bon.setStringListener(new StringListener(){
            public void textEmitted(String text){
                getContentPane().removeAll();                   //maak de JFrame leeg

                if(text.toLowerCase().trim().equals("wel")){
                System.out.println("print bon");
                add(startScherm,BorderLayout.CENTER);

                } else if(text.toLowerCase().trim().equals("niet")){
                    add(startScherm,BorderLayout.CENTER);
                    }
                
                revalidate();                                   //teken hem opnieuw
                repaint();
               
            }

        });
        saldo.setStringListener(new StringListener(){
            public void textEmitted(String text){
                getContentPane().removeAll();                   //maak de JFrame leeg

                if(text.toLowerCase().trim().equals("afbreken")){
                add(startScherm,BorderLayout.CENTER);
                }
                
                revalidate();                                   //teken hem opnieuw
                repaint();
               
            }
        });
       
        add(startScherm, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
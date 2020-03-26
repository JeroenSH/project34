import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class Algoritme extends JFrame {
    private Startscherm startScherm;
    private KeuzeBedrag keuzeBedrag;
    private Loginscherm login;
    private Keuzemenu keuzeMenu;
    private Saldo saldo;
    private Anderbedrag anderBedrag;
    private Bonscherm bon;
    private Eindscherm eindScherm;
    private Taal taal;
    private Mysqlverbinding sql;
    private Timer timer;

    private int counter;
    private int delay;

    public Algoritme() {
        super("gui voor DeMuur");
        setLayout(new BorderLayout());
        startScherm = new Startscherm();
        keuzeBedrag = new KeuzeBedrag();
        login = new Loginscherm();
        keuzeMenu = new Keuzemenu();
        saldo = new Saldo();
        anderBedrag = new Anderbedrag();
        bon = new Bonscherm();
        eindScherm = new Eindscherm();
        taal = new Taal();
        Mysqlverbinding sql = new Mysqlverbinding();

        startScherm.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg
                if (text.toLowerCase().trim().equals("login")) {
                    add(login, BorderLayout.CENTER);
                } else if (text.toLowerCase().trim().equals("taal")) {
                    add(taal, BorderLayout.CENTER);
                }

                revalidate(); // teken hem opnieuw
                repaint();

            }
        });
        taal.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg
                if (text.toLowerCase().trim().equals("afbreken")) {
                    add(startScherm, BorderLayout.CENTER);
                } else if (text.toLowerCase().trim().equals("engels")) {
                    // add(taal, BorderLayout.CENTER);
                }

                revalidate(); // teken hem opnieuw
                repaint();

            }
        });

        login.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg
                if (text.toLowerCase().trim().equals("keuzemenu")) {
                    add(keuzeMenu, BorderLayout.CENTER);
                }

                revalidate(); // teken hem opnieuw
                repaint();

            }
        });
        keuzeMenu.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg
                if (text.toLowerCase().trim().equals("keuzebedrag")) {
                    add(keuzeBedrag, BorderLayout.CENTER);
                } else if (text.toLowerCase().trim().equals("saldo")) {
                    add(saldo, BorderLayout.CENTER);
                } else if (text.toLowerCase().trim().equals("afbreken")) {
                    add(startScherm, BorderLayout.CENTER);
                } else if (text.toLowerCase().trim().equals("70")) {
                    add(bon, BorderLayout.CENTER);
                }
                revalidate(); // teken hem opnieuw
                repaint();

            }
        });
        keuzeBedrag.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg

                if (text.toLowerCase().trim().equals("afbreken")) {
                    add(startScherm, BorderLayout.CENTER);
                } else if (text.toLowerCase().trim().equals("anderbedrag")) {
                    add(anderBedrag, BorderLayout.CENTER);
                } else if (text.toLowerCase().trim().equals("vastbedrag")) {
                    add(bon, BorderLayout.CENTER);
                }
                if (text.toLowerCase().trim().equals("menu")) {
                    add(keuzeMenu, BorderLayout.CENTER);
                }

                revalidate(); // teken hem opnieuw
                repaint();

            }
        });

        anderBedrag.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg

                if (text.toLowerCase().trim().equals("afbreken")) {
                    add(startScherm, BorderLayout.CENTER);
                } else if (text.toLowerCase().trim().equals("menu")) {
                    add(keuzeMenu, BorderLayout.CENTER);
                }

                revalidate(); // teken hem opnieuw
                repaint();

            }
        });
        bon.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg

                if (text.toLowerCase().trim().equals("wel")) {
                    System.out.println("print bon");
                    einde();

                } else if (text.toLowerCase().trim().equals("niet")) {
                    einde();
                }

                revalidate(); // teken hem opnieuw
                repaint();

            }

        });
        saldo.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg

                if (text.toLowerCase().trim().equals("afbreken")) {
                    add(startScherm, BorderLayout.CENTER);
                } else if (text.toLowerCase().trim().equals("menu")) {
                    add(keuzeMenu, BorderLayout.CENTER);
                }

                revalidate(); // teken hem opnieuw
                repaint();

            }
        });

        add(startScherm, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);

    }

    public void einde() {
        getContentPane().removeAll();
        add(eindScherm, BorderLayout.CENTER);
        revalidate();
        repaint();
        delay(5);
    }

    public void delay(int tijd) {
        counter = tijd;
        delay = 1000;

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (counter == 0) {
                    getContentPane().removeAll();
                    add(startScherm, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                    timer.stop();
                } else {
                    counter--;
                }
            }
        };

        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();
    }
}
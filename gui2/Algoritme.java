import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Algoritme extends JFrame {
    private Startscherm startScherm;
    private KeuzeBedrag keuzeBedrag;
    private Loginscherm login;
    private Keuzemenu keuzeMenu;
    private Saldo saldo;
    private Anderbedrag anderBedrag;
    private Bonscherm bonScherm;
    private Eindscherm eindScherm;
    private Taal taal;
    private Mysqlverbinding sql;
    private Timer timer;
    private Geensaldo geenSaldo;
    private Biljetkeuze biljetKeuze;
    private Simulatie simulatie;
    private Blokkeerscherm blokkeerScherm;
    private Bon bon;

    private int counter;
    private int delay;
    private String sqlKrijgSaldo;
    private String sqlveranderSaldo;
    private String sqlKrijgPassword;
    private String sqlKrijgBlocked;
    private String sqlveranderBlocked;
    private int balance;
    private int bedrag;
    private int daglimiet =250;
    private String RFIDnmr;
    private String password;
    private String optie;
    private boolean bonkeuze;
    private int poging =1;
    private boolean blocked = false;
    private GridBagConstraints gc;


    public Algoritme(Achtergrond background) {
        super("gui voor DeMuur");

        setContentPane(background);
        setLayout(new GridBagLayout());

        startScherm = new Startscherm();
        startScherm.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        keuzeBedrag = new KeuzeBedrag();
        keuzeBedrag.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        login = new Loginscherm();
        login.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        keuzeMenu = new Keuzemenu();
        keuzeMenu.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        saldo = new Saldo();
        saldo.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        anderBedrag = new Anderbedrag();
        anderBedrag.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        bonScherm = new Bonscherm();
        bonScherm.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        eindScherm = new Eindscherm();
        eindScherm.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        taal = new Taal();
        taal.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        geenSaldo = new Geensaldo();
        geenSaldo.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        biljetKeuze = new Biljetkeuze();
        biljetKeuze.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        simulatie = new Simulatie();
        simulatie.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        blokkeerScherm = new Blokkeerscherm();
        blokkeerScherm.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        bon = new Bon();

        sql = new Mysqlverbinding();
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.BOTH;
            startScherm.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg
                if (text.toLowerCase().trim().equals("login")) {
                    add(login, gc);

                } else if (text.toLowerCase().trim().equals("taal")) {
                    add(taal, gc);

                }

                revalidate(); // teken hem opnieuw
                repaint();
            }

        });

//        taal.setStringListener(new StringListener() {
//            public void textEmitted(String text) {
//                getContentPane().removeAll(); // maak de JFrame leeg
//                if (text.toLowerCase().trim().equals("afbreken")) {
//                einde();
//                } else if (text.toLowerCase().trim().equals("engels")) {
//                    // add(taal, BorderLayout.CENTER);
//                }
//
//                revalidate(); // teken hem opnieuw
//                repaint();
//            }
//        });

        login.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                    if (text.toLowerCase().trim().equals("rekeningnmr")) {
                        System.out.println("in rekeningnmr if stat");
                        RFIDnmr = login.getRekeningnmr();
                        getPassword();
                        getBlocked();
                        System.out.println(RFIDnmr);
                        revalidate();
                        repaint();
                    }
                if (!blocked) {
                    if (text.toLowerCase().trim().equals("password")) {
                        if (password.trim().toLowerCase().equals(login.getPassword())) {
                            System.out.println("test");
                            getContentPane().removeAll(); // maak de JFrame leeg
                            poging = 1;
                            add(keuzeMenu, gc);
                            balance = getBalance();
                            revalidate(); // teken hem opnieuw
                            repaint();
                        } else {
                                login.fout();
                            if (poging < 3) {
                                System.out.println(poging);
                                poging++;
                            } else {
                                blocked = true;
                                setBlocked();
                                getContentPane().removeAll(); // maak de JFrame leeg
                                add(blokkeerScherm,gc);
                                login.emptyFields();
                            }
                            revalidate(); // teken hem opnieuw
                            repaint();
                        }
                    }

                } else {
                    getContentPane().removeAll(); // maak de JFrame leeg
                    add(blokkeerScherm,gc);
                    login.emptyFields();
                    revalidate(); // teken hem opnieuw
                    repaint();
                }
            }
        });

        keuzeMenu.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                login.emptyFields();
                getContentPane().removeAll(); // maak de JFrame leeg
                if (text.toLowerCase().trim().equals("keuzebedrag")) {
                    add(keuzeBedrag, gc);
                } else if (text.toLowerCase().trim().equals("saldo")) {
                    saldo.setSaldo(getBalance());
                    saldo.settings();
                   add(saldo, gc);
                } else if (text.toLowerCase().trim().equals("afbreken")) {
                    einde();
                } else if (text.toLowerCase().trim().equals("70")) {
                    if(balance >= 70 && daglimiet >= 70) {
                        add(biljetKeuze,gc);
                        biljetKeuze.setBedrag(70);
                        bedrag = 70;
                        biljetKeuze.settings();
                        balance -= 70;
                        daglimiet -= 70;
                    } else{
                       add(geenSaldo,gc);
                    }
                    changeBalance();
                    }

                revalidate(); // teken hem opnieuw
                repaint();
            }

        });

        keuzeBedrag.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg

                if (text.toLowerCase().trim().equals("afbreken")) {
                    einde();
                } else if (text.toLowerCase().trim().equals("anderbedrag")) {
                    add(anderBedrag, gc);
                } else if (text.toLowerCase().trim().equals("menu")) {
                    add(keuzeMenu, gc);
                }  else if (Integer.parseInt(text) <= balance && daglimiet >= Integer.parseInt(text)) {
                    if (text.toLowerCase().trim().equals("20")) {
                        balance -= 20;
                        daglimiet -= 20;
                        add(biljetKeuze, gc);
                        biljetKeuze.setBedrag(20);
                        bedrag = 20;
                        biljetKeuze.settings();
                    } else if (text.toLowerCase().trim().equals("50")) {
                        add(biljetKeuze, gc);
                        biljetKeuze.setBedrag(50);
                        bedrag = 50;
                        balance -= 50;
                        daglimiet -= 50;
                        biljetKeuze.settings();
                    } else if (text.toLowerCase().trim().equals("70")) {
                        add(biljetKeuze, gc);
                        biljetKeuze.setBedrag(70);
                        bedrag = 70;
                        balance -= 70;
                        daglimiet -= 70;
                        biljetKeuze.settings();
                    } else if (text.toLowerCase().trim().equals("100")) {
                        add(biljetKeuze, gc);
                        biljetKeuze.setBedrag(100);
                        bedrag = 100;
                        balance -= 100;
                        daglimiet -= 100;
                        biljetKeuze.settings();
                    }
                } else{
                    add(geenSaldo, gc);
                }
                changeBalance();

                revalidate(); // teken hem opnieuw
                repaint();

            }

        });

        anderBedrag.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg

                if (text.toLowerCase().trim().equals("afbreken")) {
                    einde();

                } else if (text.toLowerCase().trim().equals("menu")) {
                    add(keuzeMenu, gc );
                } else{
                    if(balance >= Integer.parseInt(text) && daglimiet >= Integer.parseInt(text)) {
                        balance -= Integer.parseInt(text);
                        daglimiet -= Integer.parseInt(text);
                        add(biljetKeuze, gc);
                        biljetKeuze.setBedrag(Integer.parseInt(text));
                        bedrag = Integer.parseInt(text);
                        biljetKeuze.settings();
                    } else{
                        add(geenSaldo, gc);
                    }
                }
                changeBalance();
                revalidate(); // teken hem opnieuw
                repaint();
            }

        });

        geenSaldo.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg

                if (text.toLowerCase().trim().equals("afbreken")) {
                    einde();

                } else if (text.toLowerCase().trim().equals("menu")) {
                    add(keuzeMenu, gc);
                }

                revalidate(); // teken hem opnieuw
                repaint();

            }
        });

        blokkeerScherm.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg

                if (text.toLowerCase().trim().equals("afbreken")) {
                    einde();
                }
                revalidate(); // teken hem opnieuw
                repaint();

            }
        });

        bonScherm.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg

                if (text.toLowerCase().trim().equals("wel")) {
                    bonkeuze = true;
                    simulatie();

                } else if (text.toLowerCase().trim().equals("niet")) {
                    bonkeuze = false;
                    simulatie();
                }

                revalidate(); // teken hem opnieuw
                repaint();

            }


        });

        biljetKeuze.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg

                if (text.toLowerCase().trim().equals("optie1")) {
                    optie = "optie1";
                    add(bonScherm, gc);
                }else if (text.toLowerCase().trim().equals("optie2")) {
                    optie = "optie2";
                    add(bonScherm, gc);
                }else if (text.toLowerCase().trim().equals("optie3")) {
                    optie = "optie3";
                    add(bonScherm, gc);
                }

                revalidate(); // teken hem opnieuw
                repaint();
            }
        });

        saldo.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg

                if (text.toLowerCase().trim().equals("afbreken")) {
                    einde();
                }else if (text.toLowerCase().trim().equals("menu")) {
                    add(keuzeMenu, gc);
                }

                revalidate(); // teken hem opnieuw
                repaint();
            }
        });

        simulatie.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                getContentPane().removeAll(); // maak de JFrame leeg

                if (text.toLowerCase().trim().equals("volgende")) {
                    einde();
                }

                revalidate(); // teken hem opnieuw
                repaint();
            }
        });

        add(startScherm, gc);
        startScherm.setSize(JFrame.WIDTH, JFrame.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 720);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }
    public void einde() {
        getContentPane().removeAll();
        add(eindScherm, gc);
        revalidate();
        repaint();
        delay(5);
    }
    public void simulatie(){
        getContentPane().removeAll();
        bon.setBon(bedrag, RFIDnmr);
        bon.settings();
        add(simulatie, gc);
        biljetKeuze.setbedrag2();
        simulatie.setBonkeuze(bonkeuze);
        if (optie.toLowerCase().trim().equals("optie1")){
            biljetKeuze.setVijftig();
            biljetKeuze.setTwintig();
            biljetKeuze.setTien();
            simulatie.setVijftig(biljetKeuze.getVijftig());
            simulatie.setTwintig(biljetKeuze.getTwintig());
            simulatie.setTien(biljetKeuze.getTien());
        } else if (optie.toLowerCase().trim().equals("optie2")){
                biljetKeuze.setTwintig();
                biljetKeuze.setTien();
                simulatie.setTwintig(biljetKeuze.getTwintig());
                simulatie.setTien(biljetKeuze.getTien());
        } else if (optie.toLowerCase().trim().equals("optie3")){
            biljetKeuze.setTien();
            simulatie.setTien(biljetKeuze.getTien());
        }

        simulatie.settings(bon);
        revalidate();
        repaint();
    }
    public void delay(int tijd) {
        counter = tijd;
        delay = 1000;
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (counter == 0) {
                    getContentPane().removeAll();
                    add(startScherm, gc);
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
    public int getBalance(){
        sqlKrijgSaldo = "select saldo from bank where RFIDnumber = " + RFIDnmr + ";";
        System.out.println(sqlKrijgSaldo);
        sql.setQuery(sqlKrijgSaldo);
        balance = sql.getSqlData();
        System.out.println("balance: " + balance);
        return sql.getSqlData();
    }

    public void changeBalance() {
        sqlveranderSaldo = "UPDATE bank SET saldo = " + balance + " WHERE RFIDNUMBER = " + RFIDnmr + ";";
        System.out.println(sqlveranderSaldo);
        sql.setQuery(sqlveranderSaldo);
        sql.changeSqlData();
    }

    public void getPassword(){
        sqlKrijgPassword = "select PIN from bank where RFIDnumber = " + RFIDnmr + ";";
        System.out.println(sqlKrijgPassword);
        sql.setQuery(sqlKrijgPassword);
        password = Integer.toString(sql.getSqlData());
        System.out.println("password: " + password);
    }
    
    public void getBlocked(){
        sqlKrijgBlocked = "select blocked from bank where RFIDnumber = " + RFIDnmr + ";";
        System.out.println(sqlKrijgBlocked);
        sql.setQuery(sqlKrijgBlocked);
        if(sql.getSqlData() >=1){
            blocked = true;
        } else{
            blocked = false;
        }
        System.out.println(blocked);
    }

    public void setBlocked() {
        sqlveranderBlocked = "UPDATE bank SET blocked = " + blocked + " WHERE RFIDNUMBER = " + RFIDnmr + ";";
        System.out.println(sqlveranderBlocked);
        sql.setQuery(sqlveranderBlocked);
        sql.changeSqlData();
    }
}
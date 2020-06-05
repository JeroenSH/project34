import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
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
    private int beginbedrag;
    private int balance;
    private int bedrag;
    private int daglimiet =250;
    private String RFIDnmr;
    private String password;
    private String optie;
    private boolean bonkeuze;
    private int poging =1;
    private boolean blocked = false;
    private boolean lokaal;
    private String loginrequest = null;
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

                }
                revalidate(); // teken hem opnieuw
                repaint();
            }

        });

        login.setStringListener(new StringListener() {
            public void textEmitted(String text) throws IOException {
                if(text.toLowerCase().trim().equals("confirm")){
                    if (login.getRekeningnmr().contains("MUUR")) {
                        lokaal = true;
                        RFIDnmr = login.getRekeningnmr();
                        getPassword();
                        getBlocked();
                        System.out.println(RFIDnmr);
                        revalidate();
                        repaint();
                    } else {
                        lokaal = false;
                        RFIDnmr = login.getRekeningnmr();                           //haalt op welk rekeningnummer is ingetoets
                    }

                if (lokaal) {
                    if (!blocked) {

                            if (password.trim().toLowerCase().equals(login.getPassword())) {
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
                                    add(blokkeerScherm, gc);
                                    login.emptyFields();
                                }
                                revalidate(); // teken hem opnieuw
                                repaint();
                            }


                    } else {
                        getContentPane().removeAll(); // maak de JFrame leeg
                        add(blokkeerScherm, gc);
                        login.emptyFields();
                        revalidate(); // teken hem opnieuw
                        repaint();
                    }
                } else {
                        password = login.getPassword();                               //haalt op welk password is ingevult
                        try {
                            String x = phpverbinding("pincode|" + RFIDnmr + "|" + password, "inloggen.php");
                            System.out.println("pincode|" + RFIDnmr + "|" + password);
                            if (x.equals("200")) {    //succes
                                getContentPane().removeAll();
                                add(keuzeMenu, gc);
                            } else if (x.equals("404") || x.equals("401")) {
                                if (poging < 3) {
                                    System.out.println(poging);
                                    poging++;
                                } else{
                                    getContentPane().removeAll();
                                    login.fout();
                                    blocked = true;
                                    add(blokkeerScherm, gc);
                                    login.emptyFields();
                                }
                            } else if (x.equals("403")) {
                                getContentPane().removeAll();
                                add(blokkeerScherm, gc);
                            }
                            revalidate(); // teken hem opnieuw
                            repaint();
                        } catch(NullPointerException ex){
                            System.out.println("null pointer exception");
                        }
                        }

            }
            }
        });

        keuzeMenu.setStringListener(new StringListener() {
            public void textEmitted(String text) throws IOException {
                login.emptyFields();
                getContentPane().removeAll(); // maak de JFrame leeg
                if (text.toLowerCase().trim().equals("keuzebedrag")) {
                    if(!lokaal) {
                        try {
                            String x = phpverbinding("info|" + RFIDnmr + "|" + password, "saldo.php");
                            balance = Integer.parseInt(x);
                            beginbedrag = balance;
                        } catch (ProtocolException ex) {
                            balance = 0;
                            beginbedrag = balance;
                        }
                    }
                    add(keuzeBedrag, gc);
                    System.out.println(balance);
                } else if (text.toLowerCase().trim().equals("saldo")) {
                    if(lokaal) {
                        saldo.setSaldo(getBalance());
                    } else{

                        try {
                        String x = phpverbinding("info|" + RFIDnmr + "|" + password, "saldo.php");
                        System.out.println("saldo: " + x);
                        saldo.setSaldo(Integer.parseInt(x));
                        balance = Integer.parseInt(x);
                        beginbedrag = balance;
                        System.out.println("balance keuzemenu " + balance);
                        } catch(ProtocolException ex) {
                            balance = 0;
                            beginbedrag = balance;
                            saldo.setSaldo(balance);
                        }
                        // haal saldo op van de server
                    }
                    saldo.settings();
                   add(saldo, gc);
                } else if (text.toLowerCase().trim().equals("afbreken")) {
                    einde();
                } else if (text.toLowerCase().trim().equals("70")) {
                    if(!lokaal) {
                        try {
                            String x = phpverbinding("info|" + RFIDnmr + "|" + password, "saldo.php");
                            balance = Integer.parseInt(x);
                            beginbedrag = balance;
                        } catch (ProtocolException ex) {
                            balance = 0;
                            beginbedrag = balance;
                            saldo.setSaldo(balance);
                        }
                    }
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
            public void textEmitted(String text) throws IOException {
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
                        System.out.println("balance: " + balance);
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
            public void textEmitted(String text) throws IOException {
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
        sqlKrijgSaldo = "SELECT Saldo from BankUsers where Rekeningnummer = '" + RFIDnmr + "';";
        System.out.println(sqlKrijgSaldo);
        sql.setQuery(sqlKrijgSaldo);
        balance = sql.getSqlData();
        System.out.println("balance: " + balance);
        return sql.getSqlData();
    }

    public void changeBalance() throws IOException {
        if(lokaal) {
            sqlveranderSaldo = "UPDATE BankUsers SET Saldo = " + balance + " WHERE Rekeningnummer = '" + RFIDnmr + "';";
            System.out.println(sqlveranderSaldo);
            sql.setQuery(sqlveranderSaldo);
            sql.changeSqlData();
        } else{
            try {
                System.out.println("change balance: " + (beginbedrag - balance));
                String x = phpverbinding("updatesaldo|" + RFIDnmr + "|" + (beginbedrag-balance), "updatesaldo.php");
                System.out.println(x);
            } catch(Exception ex){
                System.out.println("exception");
            }
        }
    }

    public void getPassword(){
        sqlKrijgPassword = "select Pincode from BankUsers where Rekeningnummer = '" + RFIDnmr + "';";
        System.out.println(sqlKrijgPassword);
        sql.setQuery(sqlKrijgPassword);
        password = Integer.toString(sql.getSqlData());
        System.out.println("password: " + password);
    }
    
    public void getBlocked(){
        sqlKrijgBlocked = "select Geblokkeerd from BankUsers where Rekeningnummer = '" + RFIDnmr + "';";
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
        sqlveranderBlocked = "UPDATE BankUsers SET Geblokkeerd = " + blocked + " WHERE Rekeningnummer = '" + RFIDnmr + "';";
        System.out.println(sqlveranderBlocked);
        sql.setQuery(sqlveranderBlocked);
        sql.changeSqlData();
    }

    public String phpverbinding(String rekeningnmr, String file) throws IOException {
    String returnstring = null;
    try {
        FileWriter myWriter = new FileWriter("test.txt");
        myWriter.write(rekeningnmr);
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
        try {
        // open a connection to the site
        URL url = new URL("http://77.173.174.44/gui4/src/" + file);
        URLConnection con = url.openConnection();
        // activate the output
        con.setDoOutput(true);
        // we have to get the input stream in order to actually send the request
        con.getInputStream();
        // close the print stream
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.println("code: " + line);
            returnstring = line;
        }
        //con.getInputStream().close();
    } catch (MalformedURLException e) {

    }
        return returnstring;

    }
}



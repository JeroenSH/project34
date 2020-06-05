import java.sql.*;
import com.jcraft.jsch.*;

public class MysqlDatabase{
    static int lport;
    static String rhost;
    static int rport;
    public Connection connection; 
    private String name;

    public MysqlDatabase(){
        lport = 8306;
        rhost = "localhost";
        String url = "mysql://" + rhost +":" + lport + "/";
        String db = "DeMuur";
       // String options = "?useLegacyDateTimeCode=false&serverTimezone=Europe/Amsterdam";
        String dbUser = "ubuntu-0982632"; //Username mysql (beveiligd)
        String dbPasswd = "SetNewP@ssW0rd";   //Password mysql (beveiligd)
        try{

            //connection = DriverManager.getConnection(url+db+options, dbUser, dbPasswd);
            connection = DriverManager.getConnection(url+db, dbUser, dbPasswd);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void go(){
        String user = "ubuntu-0982632";   //Username server (beveiligd)
        String password = "ExtraVeilig";   //wachtwoord server (beveiligd)
        String host = "145.24.222.47";   //host ip adres server (beveiligd)
        int port=22;
        //opzetten verbinding
        try
            {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            lport = 8306;
            rhost = "localhost";
            rport = 3306;
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            int assinged_port=session.setPortForwardingL(lport, rhost, rport);
            System.out.println("assinged_port: " + assinged_port);
            System.out.println("localhost:"+assinged_port+" -> "+rhost+":"+rport);
            }
        catch(Exception e){System.err.print(e);}
    }

    public static void startUp() {
        try{
            go();
        } catch(Exception ex){
            ex.printStackTrace();
        }
          lport = 3306;
          rhost = "localhost";
          Connection con = null;
          System.out.println("An example for updating a Row from Mysql Database!");
          String url = "jdbc:mysql://" + rhost +":" + lport + "/";
          String db = "DeMuur"; //naam database (beveiligd)
          String options = "?useLegacyDateTimeCode=false&serverTimezone=Europe/Amsterdam";
          String dbUser = "root";   //username mysql (beveiligd)
          String dbPasswd = "SetNewP@ssW0rd";     //wachtwoord mysql (beveiligd)
          try{
          con = DriverManager.getConnection(url+db+options, dbUser, dbPasswd);
          try{
          Statement st = con.createStatement();
          String sql = "SELECT * FROM gegevens";
          ResultSet rset = st.executeQuery(sql);
          //System.out.println("Total number of records = " + rowCount);
          }
          catch (SQLException s){
          System.out.println("SQL statement is not executed!");
          }
          }
          catch (Exception e){
          e.printStackTrace();
          }
          }

          public String readName(String ID){
            try{
                Statement st= connection.createStatement();
                String sql = "SELECT NAAM FROM gegeves WHERE ID = '" + ID + "'";
                ResultSet rset = st.executeQuery(sql);

                while(rset.next()) {
                    name = rset.getString("NAAM");
                }
            }


            catch (SQLException s){
                System.out.println("SQL statement is not executed!");
            }

              return name;
          }

}
import java.sql.*;

public class Mysqlverbinding {
    private int a;
    private String query;
    private Connection con;
    public Mysqlverbinding() {                              //maak de verbinding aan
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String options = "?useLegacyDateTimeCode=false&serverTimezone=Europe/Amsterdam";
            con = DriverManager.getConnection("jdbc:mysql://145.24.222.25/BankData" + options, "java", "SetNewP@ssW0rd");
            } catch (Exception e){
            System.out.println(e);
        }

    }

    public void changeSqlData(){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);

        } catch(Exception e) {
            System.out.println(e);
        }

        }
    public int getSqlData(){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            //saldo : select saldo from bank where rekeningnummer = '1'
            while (rs.next())
                //   System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                a = rs.getInt(1);
          //  System.out.println(a);
        } catch (Exception e) {
            System.out.println(e);
        }

        return a;
    }

    public void setQuery(String query){
        this.query = query;
    }

}

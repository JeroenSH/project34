import java.sql.*;

public class Mysqlverbinding {
    private int a;
    private String query;
    public Mysqlverbinding() {

    }

    public int getSqlData(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String options = "?useLegacyDateTimeCode=false&serverTimezone=Europe/Amsterdam";

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/DeMuur" + options, "root", "");
//here sonoo is the database name, root is the username and root is the password
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            //saldo : select saldo from bank where rekeningnummer = '1'
            while (rs.next())
                //   System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                a = rs.getInt(1);
            System.out.println(a);
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return a;
    }

    public void setQuery(String query){
        this.query = query;
    }

}

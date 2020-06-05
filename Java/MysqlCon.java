import java.sql.*;

class MysqlCon{

    public static void main(String args[]){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            String options = "?useLegacyDateTimeCode=false&serverTimezone=Europe/Amsterdam";

            Connection con=DriverManager.getConnection("jdbc:mysql://145.24.222.47:3306/DeMuur"+options,"Java","SetNewP@ssW0rd");
//here sonoo is the database name, root is the username and root is the password
            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery("select * from gegevens ");

            while(rs.next())
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3) + rs.getString(4));
                System.out.println(rs.getInt(1));
            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
}
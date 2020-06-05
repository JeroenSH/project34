
public class App{


    public static void main(String[] args) {
     MysqlDatabase connect = new MysqlDatabase();
     connect.startUp();

     System.out.println(connect.readName("2"));
    }

    
}
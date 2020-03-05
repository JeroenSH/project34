public class App{


    public static void main(String[] args) {
        MysqlDatabase connect = new MysqlDatabase();
        Connect.startUp();  //start connection server



        System.out.println(connect.readName("2"));
    }

    
}
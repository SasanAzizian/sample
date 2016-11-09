package database;
import java.sql.*;


public class DBConnection {
    public static Connection getConnection(){
        String username="root";
        String pass="root";
        String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1/uno";

        Connection con=null;
        try{

            Class.forName(driver);
            con=DriverManager.getConnection(url,username,pass);

        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}

package configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getDBconnection() {
        String url = "jdbc:mysql://localhost:3306/practise";
        String username = "root";
        String password = "root";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException e) {
            disconnect(conn);
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean disconnect(Connection conn) {
        try{
            if (conn != null) {
                conn.close();
                System.out.println("Connection closed");
                return true;
            }
        }catch(SQLException e){
            return false;
        }
        return false;
    }
}

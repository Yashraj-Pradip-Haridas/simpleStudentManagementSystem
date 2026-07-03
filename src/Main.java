import configs.DBConnection;
import models.User;
import services.UserService;

import java.sql.Connection;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Connection conn = DBConnection.getDBconnection();

        if(conn == null){
            System.out.println("Database connection failed");
            return;
        }
        UserService userService = new UserService();
        if(userService.createUser()){
            System.out.println("User created successfully");
        }


        DBConnection.disconnect(conn);


    }
}
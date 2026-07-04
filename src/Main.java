import configs.DBConnection;
import services.UserService;

import java.sql.Connection;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Connection conn = DBConnection.getDBconnection();

        if (conn == null) {
            System.out.println("Database connection failed");
            return;
        }
        UserService userService = new UserService();
        int choice = 2;
        Scanner sc = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Enter your choice:");
            System.out.println("1. Add User");
            System.out.println("2. Fetch User");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    if (userService.createUser()) {
                        System.out.println("User created successfully");
                    }
                    break;
                case 2:
                    userService.getUser();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        DBConnection.disconnect(conn);
    }
}
package services;

import dao.UserDao;
import models.User;

import java.util.Scanner;

public class UserService {

    public  boolean createUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Student name");
        String sname = sc.nextLine();
        System.out.println("Enter Student age");
        int sage = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Student City");
        String scity = sc.nextLine();

        User u = new User(scity, sage, sname, id);
        UserDao userDao = new UserDao();
        sc.close();
        if(userDao.saveUser(u)){
            return true;
        }
        return false;
    }
}

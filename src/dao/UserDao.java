package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.User;

import static configs.DBConnection.getDBconnection;

public class UserDao {

    public boolean saveUser(User newUser){
        Connection conn = getDBconnection();
        if(conn == null) return false;
        String query = "INSERT INTO studentInfo(id, sname, sage, scity) values (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, newUser.getId());
            pstmt.setString(2, newUser.getSname());
            pstmt.setInt(3, newUser.getSage());
            pstmt.setString(4, newUser.getScity());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error in saving user");
        }
        return false;
    }

    public User getUser(int id){
        Connection conn = getDBconnection();
        User user = null;
        if(conn == null) return null;
        String query = "SELECT * FROM studentInfo WHERE id = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println(rs.getInt("id")+ rs.getString("sname"));
            }
        }catch(SQLException e){
            System.out.println("Error in getting user");
        }
        return user;
    }
}

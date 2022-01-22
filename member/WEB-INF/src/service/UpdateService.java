package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateService {
    public  void updateCustomer (String email, String password, String name, String gender, String blood, String old, String memo,String id) {
        String dbName = "system_user";
        String dbPropaties = "?characterEncoding=UTF-8&serverTimezone=JST";
        String dbUrl ="jdbc:mySQL://localhost:3306/" + dbName +dbPropaties;
        String dbUser =  "root";
        String dbPassword = "admin";
        String sql ="update customer set email=?, password=?, name=?, gender=?, blood=?, old=?, memo=? where id=?;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection coon = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            PreparedStatement ps = coon.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, gender);
            ps.setString(5, blood);
            ps.setString(6, old);
            	ps.setString(7, memo);
            ps.setString(8, id);
            ps.executeUpdate();
            ps.close();
            coon.commit();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
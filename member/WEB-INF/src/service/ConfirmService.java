package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Customer;

public class ConfirmService {
    public List<Customer>  confirmCustomer (String email, String password, String name, String gender, String blood, String old, String memo) {
        String dbName = "system_user";
        String dbPropaties = "?cvharacterEncoding=UTF-8&serverTimezone=JST";
        String dbUrl ="jdbc:mySQL://localhost:3306/" + dbName +dbPropaties;
        String dbUser =  "root";
        String dbPassword = "admin";
        String sql ="insert into customer (email,password,name,gender,blood,old,memo) VALUES (?,?,?,?,?,?,?);";
        List<Customer> customerList = new ArrayList<Customer>();
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
            ps.executeUpdate();
            ps.close();
            coon.commit();



        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
return customerList;
    }
}
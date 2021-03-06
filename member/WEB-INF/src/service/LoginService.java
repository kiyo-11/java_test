package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

	public String login (String email, String password) {
		String dbName = "system_user";
		String dbPropaties ="?characterEncoding=UTF-8&severTimezone=JST";
		String dbUrl ="jdbc:mySQL://localhost:3306/" + dbName + dbPropaties;
		String dbUser ="root";
		String dbPassword = "admin";
		String sql = "select name from login where email =? and password=?;";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				return name;
			}
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		return "";
		}
}

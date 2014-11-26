package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao2 {
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "INSERT INTO users(id, name, password) VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		
		String sql = "SELECT * FROM users WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		conn.close();
		
		return user;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		String sqlURL = "jdbc:mysql://localhost/springbook";
		String sqlId = "root";
		String sqlPw = "wind7622";
		Connection conn = DriverManager.getConnection(sqlURL, sqlId, sqlPw);
		
		return conn;
	}
}

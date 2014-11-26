package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao3 {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		String sqlURL = "jdbc:mysql://localhost/springbook";
		String sqlId = "root";
		String sqlPw = "wind7622";
		Connection conn = DriverManager.getConnection(sqlURL, sqlId, sqlPw);
		
		return conn;
	}
}

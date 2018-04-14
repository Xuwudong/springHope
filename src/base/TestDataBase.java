package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDataBase {
	public static User select(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement stat = conn.createStatement();
		String sql = "select * from USER where id = " + id;
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			String name = rs.getString(2);
			return new User(id, name);
		}
		return null;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(select(1));
	}
}

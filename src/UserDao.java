

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	protected Connection getConnection() {
	 String driver = "com.mysql.jdbc.Driver";
	 String url = "jdbc:mysql://localhost/java?user=java&password=java&zeroDateTimeBehavior=convertToNull";
	  try {
	   DriverManager.registerDriver((Driver) Class.forName(driver).newInstance());
	   Connection connection = DriverManager.getConnection(url);
	   return connection;
	  } catch (SQLException | ReflectiveOperationException ex) {
	   throw new RuntimeException(ex);
	  }
	}
	
	public String getUserName() {
	 try (Connection connection = getConnection()) {
	  String query = "SELECT user FROM user WHERE user LIKE 'e%'";
	  try (PreparedStatement ps = connection.prepareStatement(query)) {
	   // ps.setLong(1, id);
	   try (ResultSet row = ps.executeQuery()) {
	    if (row.next()) {
	     return row.getString("user");
	    } else {
		     throw new java.util.NoSuchElementException();
		}
	   }
	  }
	 } catch (SQLException ex) { throw new RuntimeException(ex); }
	}
	
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		String name = dao.getUserName();
		System.out.println(name);
	}
}

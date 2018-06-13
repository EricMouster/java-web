package person;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

	private String insert = "INSERT INTO person ( firstname , lastname, email ) VALUES (?,?,?)" ;
	private String update = "UPDATE      person SET firstname = ? , lastname = ?, email = ? WHERE ID = ?" ;
	private String delete = "DELETE FROM person WHERE id = ?" ;
	private String findAll  = "SELECT id, firstname, lastname, email FROM person " ;
	private String findById = "SELECT id, firstname, lastname, email FROM person WHERE id = ?" ;

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

	public void insert(Person person) {
		try (Connection connection = getConnection()) {
			String query = insert;
			try (PreparedStatement ps = connection.prepareStatement(query)) {
				int xx = 1;
				ps.setString(xx++, person.getFirstName());
				ps.setString(xx++, person.getLastName());
				ps.setString(xx++, person.getEmail());
				ps.execute();
			}} catch (SQLException ex) { throw new RuntimeException(ex); }}

	public void update(Person person) {
		try (Connection connection = getConnection()) {
			String query = update;
			try (PreparedStatement ps = connection.prepareStatement(query)) {
				int xx = 1;
				ps.setString(xx++, person.getFirstName());
				ps.setString(xx++, person.getLastName());
				ps.setString(xx++, person.getEmail());
				ps.setLong(xx++, person.getId());
				ps.execute();
			}} catch (SQLException ex) { throw new RuntimeException(ex); }}

	public void delete(Person person) {
		try (Connection connection = getConnection()) {
			String query = delete;
			try (PreparedStatement ps = connection.prepareStatement(query)) {
				ps.setLong(1, person.getId());
				ps.execute();
			}} catch (SQLException ex) { throw new RuntimeException(ex); }}

	public void deleteById(long id) {
		try (Connection connection = getConnection()) {
			String query = delete;
			try (PreparedStatement ps = connection.prepareStatement(query)) {
				ps.setLong(1, id);
				ps.execute();
			}} catch (SQLException ex) { throw new RuntimeException(ex); }}

	public List<Person> findAll() {
		try (Connection connection = getConnection()) {
			String query = findAll;
			try (PreparedStatement ps = connection.prepareStatement(query)) {
				try (ResultSet row = ps.executeQuery()) {
					List<Person> list = new ArrayList<>();
					while (row.next()) {
						Person person = new Person();
						person.setId(row.getLong("id"));
						person.setFirstName(row.getString("firstname"));
						person.setLastName(row.getString("lastname"));
						person.setEmail(row.getString("email"));
						list.add(person);
					}
					return list;
				}}} catch (SQLException ex) { throw new RuntimeException(ex); }}

	public Person findById(long id) {
		try (Connection connection = getConnection()) {
			String query = findById;
			try (PreparedStatement ps = connection.prepareStatement(query)) {
				ps.setLong(1, id);
				try (ResultSet row = ps.executeQuery()) {
					if (row.next()) {
						Person person = new Person();
						person.setId(row.getLong("id"));
						person.setFirstName(row.getString("firstname"));
						person.setLastName(row.getString("lastname"));
						person.setEmail(row.getString("email"));
						return person;
					} else {
						throw new java.util.NoSuchElementException();
					}}}} catch (SQLException ex) { throw new RuntimeException(ex); }}

}

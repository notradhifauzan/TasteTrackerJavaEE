package inventor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import admin.model.AdminBean;
import connection.ConnectionManager;
import inventor.model.userBean;

public class inventorDAO {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static String sql;
	
	private String firstName;
	private String lastName;
	private String password;
	private int id_inventor;
	private String username;
	
	public static userBean getInventor(String username) {
		userBean bean = new userBean();
		try {
			con = ConnectionManager.getConnection();
			sql = "select * from inventor where username=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);

			rs = ps.executeQuery();

			if (rs.next()) {
				bean.setFirstName(rs.getString("firstname"));
				bean.setLastName(rs.getString("lastname"));
				bean.setId_inventor(rs.getInt("id_inventor"));
				bean.setUsername(rs.getString("username"));
				
				return bean;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("couldnt established connection to the database");
		}
		
		return null;
	}
	
	public static boolean inventorLogin(String username, String password) {
		try {
			con = ConnectionManager.getConnection();
			sql = "select * from inventor where username=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);

			rs = ps.executeQuery();

			if (rs.next()) {
				if (rs.getString("password").equals(password)) {
					return true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("couldnt established connection to the database");
		}

		return false;
	}
	
	public static List <userBean> getAllInventor(){
		List<userBean> users = new ArrayList<userBean>();
		
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// create statement
			String sql ="SELECT * FROM inventor ORDER BY id_inventor";
			stmt = con.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				userBean b = new userBean(); 
				b.setFirstName(rs.getString("firstName"));
				b.setLastName(rs.getString("lastName"));
				b.setPassword(rs.getString("password"));
				b.setUsername(rs.getString("username"));
				users.add(b);
			}

			// close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void addUser(userBean bean) {

		// get values
		firstName = bean.getFirstName();
		lastName = bean.getLastName();
		username = bean.getUsername();
		password = bean.getPassword();

		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// create statement
			String sql = "INSERT INTO `inventor`( `firstname`, `lastname`, `username`, `password`) "
					+ "VALUES (?,?,?,?)";
			
					
			ps = con.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, username);
			ps.setString(4, password);
			
			// execute query
			ps.executeUpdate();

			// close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.model.AdminBean;
import connection.ConnectionManager;

public class adminDAO {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static String sql;

	public static boolean adminLogin(String username, String password) {
		try {
			con = ConnectionManager.getConnection();
			sql = "select * from admin where username=?";
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

	public static AdminBean getAdminById(int adminId) {
		AdminBean admin = new AdminBean();

		try {
			con = ConnectionManager.getConnection();
			sql = "select * from admin where adminID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, adminId);

			rs = ps.executeQuery();

			if (rs.next()) {
				admin.setAdminId(rs.getInt("adminID"));
				admin.setUsername(rs.getString("username"));
			}

			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("couldnt established connection to the database");
			return null;
		}
	}

	public static List<AdminBean> getAllAdmin() {
		List<AdminBean> admins = new ArrayList<AdminBean>();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// create statement
			String sql = "SELECT * FROM admin ORDER BY adminID";
			stmt = con.createStatement();

			// execute query
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				AdminBean b = new AdminBean();
				b.setAdminId(rs.getInt("adminID"));
				b.setPassword(rs.getString("password"));
				b.setUsername(rs.getString("username"));
				admins.add(b);
			}

			// close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}

}

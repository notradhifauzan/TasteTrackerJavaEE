package recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;
import recipe.recipeBean;

public class recipeDAO {

	public recipeBean getRecipeById(int recipeId) {

		recipeBean item = new recipeBean();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConnectionManager.getConnection();

			String sql = "select * from recipe where id_recipe = ?;";

			ps = con.prepareStatement(sql);
			ps.setInt(1, recipeId);

			rs = ps.executeQuery();

			if (rs.next()) {
				item.setName(rs.getString("name"));
				item.setRecipeID(rs.getInt("id_recipe"));
				item.setDescription(rs.getString("description"));
				item.setSubject(rs.getString("subject"));
				item.setImgAddress(rs.getString("img_address"));
				item.setCalories(rs.getString("calories"));
				item.setSteps(rs.getString("steps"));
				item.setCategory(rs.getString("category"));
				item.setInventorID(rs.getInt("inventor_id"));
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("log :: database error");
		}

		return item;
	}

	public List<recipeBean> getAllRecipes() {
		List<recipeBean> recipeList = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConnectionManager.getConnection();

			String sql = "select * from recipe where status=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, "public");
			rs = ps.executeQuery();

			while (rs.next()) {
				recipeBean item = new recipeBean();

				item.setName(rs.getString("name"));
				item.setRecipeID(rs.getInt("id_recipe"));
				item.setDescription(rs.getString("description"));
				item.setSubject(rs.getString("subject"));
				item.setImgAddress(rs.getString("img_address"));
				item.setCalories(rs.getString("calories"));
				item.setSteps(rs.getString("steps"));
				item.setCategory(rs.getString("category"));
				item.setInventorID(rs.getInt("inventor_id"));
				item.setStatus(rs.getString("status"));

				recipeList.add(item);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("log :: database error");
		}

		return recipeList;
	}

	public void addRecipe(recipeBean bean, int inventorId) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// create statement
			String sql = "INSERT INTO recipe(name,subject,description,img_address,inventor_id,calories,steps,category)"
					+ " VALUES (?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getSubject());
			ps.setString(3, bean.getDescription());
			ps.setString(4, bean.getImgAddress());
			ps.setInt(5, inventorId);
			ps.setString(6, bean.getCalories());
			ps.setString(7, bean.getSteps());
			ps.setString(8, bean.getCategory());

			// execute query
			ps.executeUpdate();

			// close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources in the reverse order of their creation
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<recipeBean> getRecipeByInventorId(int id_inventor) {
		List<recipeBean> recipeList = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConnectionManager.getConnection();

			String sql = "select * from recipe where inventor_id=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, id_inventor);

			rs = ps.executeQuery();

			while (rs.next()) {
				recipeBean item = new recipeBean();

				item.setName(rs.getString("name"));
				item.setRecipeID(rs.getInt("id_recipe"));
				item.setDescription(rs.getString("description"));
				item.setSubject(rs.getString("subject"));
				item.setImgAddress(rs.getString("img_address"));
				item.setCalories(rs.getString("calories"));
				item.setSteps(rs.getString("steps"));
				item.setCategory(rs.getString("category"));
				item.setStatus(rs.getString("status"));

				recipeList.add(item);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("log :: database error");
		}

		return recipeList;
	}

	public void deleteRecipeById(Integer recipeId) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConnectionManager.getConnection();

			String sql = "delete from recipe where id_recipe=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, recipeId);

			ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("log :: database error");
		}
	}

	

	public void approveRecipe(int recipeId) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConnectionManager.getConnection();

			String sql = "update recipe set status=? where id_recipe=?;";

			ps = con.prepareStatement(sql);
			ps.setString(1, "public");
			ps.setInt(2, recipeId);

			ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("log :: database error");
		}
	}

	public List<recipeBean> getPendingRecipes() {
		List<recipeBean> recipeList = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = ConnectionManager.getConnection();

			String sql = "select * from recipe where status=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, "pending");
			rs = ps.executeQuery();

			while (rs.next()) {
				recipeBean item = new recipeBean();

				item.setName(rs.getString("name"));
				item.setRecipeID(rs.getInt("id_recipe"));
				item.setDescription(rs.getString("description"));
				item.setSubject(rs.getString("subject"));
				item.setImgAddress(rs.getString("img_address"));
				item.setCalories(rs.getString("calories"));
				item.setSteps(rs.getString("steps"));
				item.setCategory(rs.getString("category"));
				item.setInventorID(rs.getInt("inventor_id"));

				recipeList.add(item);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("log :: database error");
		}

		return recipeList;
	}

}

package comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comment.CommentBean;
import connection.ConnectionManager;

public class commentDAO {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static String sql;

	public void deleteCommentByRecipeId(Integer recipeId) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// create statement
			String sql = "delete from comment where recipeID=?;";

			ps = con.prepareStatement(sql);

			ps.setInt(1, recipeId);

			// execute query
			ps.executeUpdate();

			// close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addComment(CommentBean bean) {

		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// create statement
			String sql = "insert into comment(commentText,commenterID,recipeID) values(?,?,?);";

			ps = con.prepareStatement(sql);

			ps.setString(1, bean.getCommentText());
			ps.setInt(2, bean.getCommenterID());
			ps.setInt(3, bean.getRecipeID());

			// execute query
			ps.executeUpdate();

			// close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<CommentBean> getCommentsByRecipeID(int recipeID) {
		List<CommentBean> comments = new ArrayList<>();

		try {
			con = ConnectionManager.getConnection();
			String sql = "SELECT\r\n" + "    comment.id_comment,\r\n" + "    comment.commentText,\r\n"
					+ "    inventor.id_inventor AS commenterID,\r\n" + "    inventor.username AS commenterUsername,\r\n"
					+ "    comment.recipeID,\r\n" + "    comment.date_created\r\n" + "FROM\r\n" + "    comment\r\n"
					+ "LEFT JOIN\r\n" + "    inventor ON comment.commenterID = inventor.id_inventor\r\n"
					+ "WHERE recipeID = ?;\r\n";

			ps = con.prepareStatement(sql);
			ps.setInt(1, recipeID);
			rs = ps.executeQuery();

			while (rs.next()) {
				CommentBean comment = new CommentBean();
				comment.setId_comment(rs.getInt("id_comment"));
				comment.setCommentText(rs.getString("commentText"));
				comment.setCommenterName(rs.getString("commenterUsername"));
				comment.setCommenterID(rs.getInt("commenterID"));
				comment.setRecipeID(rs.getInt("recipeID"));
				comment.setDateCreated(rs.getDate("date_created"));

				comments.add(comment);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return comments;
	}

	public void deleteComment(Integer commentId, Integer recipeId) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// create statement
			String sql = "delete from comment where id_comment=?;";

			ps = con.prepareStatement(sql);
			ps.setInt(1, commentId);

			// execute query
			ps.executeUpdate();

			// close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

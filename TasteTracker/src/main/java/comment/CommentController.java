package comment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import admin.model.AdminBean;
import comment.dao.commentDAO;
import inventor.model.userBean;

public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	userBean userbean;
	CommentBean commentbean;
	commentDAO commentdao;
	AdminBean adminbean;

	public CommentController() {
		super();
		userbean = new userBean();
		commentbean = new CommentBean();
		commentdao = new commentDAO();
		adminbean = new AdminBean();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		userbean = (userBean) request.getSession().getAttribute("inventor");
		adminbean = (AdminBean) request.getSession().getAttribute("admin");

		if (action != null) {
			if (!action.isEmpty()) {
				switch (action) {
				case "delete":
					deleteComment(request, response, userbean, adminbean);
					return;
				default:
					break;
				}
			} else {

			}
		} else {

		}
	}

	private void deleteComment(HttpServletRequest request, HttpServletResponse response, userBean user, AdminBean admin)
			throws IOException {

		String delete_request_by = request.getParameter("delete_request_by");
		Integer commentId = Integer.parseInt(request.getParameter("commentId"));
		Integer recipeId = Integer.parseInt(request.getParameter("recipeId"));
		Integer inventorId = Integer.parseInt(request.getParameter("inventorId"));

		if (delete_request_by != null && !delete_request_by.isEmpty()) {
			switch (delete_request_by) {

			case "inventor":
				/*
				 * inventor can only delete review on his own recipe
				 */
				if (inventorId == user.getId_inventor()) {
					System.out.println("log :: allow deletion for comment");
					commentdao.deleteComment(commentId, recipeId);
				}
				response.sendRedirect("RecipeController?action=details&recipeId=" + recipeId);
				break;
			case "admin":
				/*
				 * admin can delete all review in all recipes
				 */
				commentdao.deleteComment(commentId, recipeId);
				response.sendRedirect("RecipeController?action=details&recipeId=" + recipeId + "&role=admin");
				break;
			default:
				break;

			}
		} else {
			response.sendRedirect("RecipeController?action=home");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userbean = (userBean) request.getSession().getAttribute("inventor");

		Integer commenterId = userbean.getId_inventor();
		Integer recipeId = Integer.parseInt(request.getParameter("recipeId"));
		String review = request.getParameter("review");

		if (commenterId != null && recipeId != null && review != null) {
			System.out.println("log :: all fields are filled");

			commentbean.setCommentText(review);
			commentbean.setRecipeID(recipeId);
			commentbean.setCommenterID(commenterId);

			commentdao.addComment(commentbean);
			response.sendRedirect("RecipeController?action=details&recipeId=" + recipeId);

		} else {
			System.out.println("log :: some fields are null");
			response.sendRedirect("RecipeController?action=home");
		}
	}

}

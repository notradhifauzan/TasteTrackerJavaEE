
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import recipe.dao.recipeDAO;
import recipe.recipeBean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;

import comment.dao.commentDAO;
import inventor.model.userBean;

@MultipartConfig
public class recipeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public recipeController() {
		super();
		recipeDAO dao = new recipeDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		String view = "";

		String actionRequest = request.getParameter("action");

		if (actionRequest != null && !actionRequest.isEmpty()) {
			if (!actionRequest.isEmpty()) {
				switch (actionRequest) {
				case "add":
					System.out.println("log :: viewing recipe addRecipe.jsp");
					view = "addRecipe.jsp";
					break;
				case "home":
					System.out.println("log :: viewing mainpage.jsp");
					view = "mainpage.jsp";
				default:
					break;
				}

			} else {
				view = "welcome.jsp";
				System.out.println("debug:: actionRequest is empty");
			}
		} else {
			// default view is to welcome.jsp
			System.out.println("log :: viewing home");
			view = "welcome.jsp";
		}

		rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("log :: doPost :: recipeController.java");
		String action = request.getParameter("action");

		if (action != null && !action.isEmpty()) {
			switch (action) {
			case "add": addNewRecipe(request,response);
				break;
			default:
				break;
			}
		} else {
			System.out.println("log :: action is either null or empty");
		}

	}

	private void addNewRecipe(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("recipe_name");
		System.out.println("log :: request.getParameter(recipe_name) :: " + name);

		String recipeText = request.getParameter("recipe_description");

		Part cover = request.getPart("recipe_img");

		System.out.println("log :: request.getPart(\"recipe_img\") :: " + cover);

		String picture = Paths.get(cover.getSubmittedFileName()).getFileName().toString();
	}

}

package recipe;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import recipe.dao.recipeDAO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import comment.dao.commentDAO;
import inventor.dao.inventorDAO;
import inventor.model.userBean;

@MultipartConfig
public class RecipeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	recipeDAO recipedao;
	userBean userbean;
	recipeBean recipebean;
	commentDAO commentdao;

	public RecipeController() {
		super();
		recipedao = new recipeDAO();
		recipebean = new recipeBean();
		commentdao = new commentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		String view = "";

		String actionRequest = request.getParameter("action");
		String from = request.getParameter("from");
		String subaction = "";
		Integer recipeId = null;

		String role = request.getParameter("role");

		if (actionRequest != null && !actionRequest.isEmpty()) {
			if (!actionRequest.isEmpty()) {
				switch (actionRequest) {
				case "dashboard":
					System.out.println("log :: admin view dashboard");
					view = "adminDashboard.jsp";
					request.setAttribute("pending_recipes", recipedao.getPendingRecipes().size());
					request.setAttribute("public_recipes", recipedao.getAllRecipes().size());
					request.setAttribute("total_members", inventorDAO.getAllInventor().size());
					request.setAttribute("current_page", "dashboard");
					break;

				case "approve":
					System.out.println("log :: admin attempt to approve recipe");
					recipedao.approveRecipe(Integer.parseInt(request.getParameter("recipeId")));
					response.sendRedirect("RecipeController?action=home&role=admin");
					return;

				case "pending":
					System.out.println("log :: admin view list of pending recipe");
					request.setAttribute("recipes", recipedao.getPendingRecipes());
					request.setAttribute("current_page", "pending");
					view = "adminViewPendingRecipe.jsp";
					break;

				case "add":
					System.out.println("log :: viewing addRecipe.jsp");
					request.setAttribute("sampledata", recipebean.getRandomRecipe()); // delete this line
					view = "addRecipe.jsp";
					break;

				case "home":
					request.setAttribute("recipes", recipedao.getAllRecipes());
					if (role != null && role.equalsIgnoreCase("admin")) {
						System.out.println("log :: role-admin :: viewing all public recipes");
						request.setAttribute("current_page", "all");
						view = "adminViewAllRecipe.jsp";
					} else {
						System.out.println("log :: role-inventor viewing mainpage.jsp");
						view = "mainpage.jsp";
					}
					break;

				case "details":
					recipeId = Integer.parseInt(request.getParameter("recipeId"));
					if (recipeId != null) {
						if (role != null && role.equalsIgnoreCase("admin")) {
							System.out.println("log :: role-admin viewing recipe details");
							view = "adminViewRecipeDetails.jsp";
						} else {
							System.out.println("log :: role-inventor viewing recipe details");
							view = "recipes1.jsp";
						}
						request.setAttribute("recipe", recipedao.getRecipeById(recipeId));
						request.setAttribute("comments", commentDAO.getCommentsByRecipeID(recipeId));
					}
					break;

				case "myRecipe":
					System.out.println("log :: viewing all my recipe");
					userbean = (userBean) request.getSession().getAttribute("inventor");
					view = "myrecipe.jsp";
					request.setAttribute("recipes", recipedao.getRecipeByInventorId(userbean.getId_inventor()));
					break;

				case "delete":
					System.out.println("log :: delete attempt");
					deleteRecipe(request, response);
					if (role != null && role.equalsIgnoreCase("admin")) {
						subaction = (from != null && from.equalsIgnoreCase("all")) ? "home&role=admin" : "pending";
						response.sendRedirect("RecipeController?action=" + subaction);
					} else {
						response.sendRedirect("RecipeController?action=myRecipe");
					}
					return;

				default:
					break;
				}

			} else {
				view = "welcome.jsp";
				System.out.println("debug:: actionRequest is empty");
			}
		} else {
			// default view is to welcome.jsp
			System.out.println("log :: viewing welcome.jsp");
			view = "welcome.jsp";
		}

		rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	private void deleteRecipe(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer recipeId = Integer.parseInt(request.getParameter("recipeId"));
		recipebean = recipedao.getRecipeById(recipeId);

		if (recipebean != null && recipebean.getImgAddress() != null || !recipebean.getImgAddress().isEmpty()) {
			ServletContext servletContext = getServletContext();

			String imagesDirectoryPath = servletContext.getRealPath("/images");

			String filePath = imagesDirectoryPath + File.separator + recipebean.getImgAddress();
			System.out.println("log:: the filePath to delete: " + filePath);

			Files.delete(Paths.get(filePath));

			commentdao.deleteCommentByRecipeId(recipeId);
			recipedao.deleteRecipeById(recipeId);
		} else {
			System.out.println("log:: cannot delete recipe");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("log :: doPost :: recipeController.java");
		String action = request.getParameter("action");

		if (action != null && !action.isEmpty()) {
			switch (action) {
			case "add":
				addNewRecipe(request, response);
				break;
			default:
				break;
			}
		} else {
			System.out.println("log :: action is either null or empty");
		}
	}

	private void addNewRecipe(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("log :: attempt to add new recipe");

		userbean = (userBean) request.getSession().getAttribute("inventor");

		String recipeName = request.getParameter("recipe_name");
		String recipeDescription = request.getParameter("recipe_description");
		String recipeSubject = request.getParameter("recipe_subject");
		String recipeSteps = request.getParameter("recipe_steps");
		String recipeCategory = request.getParameter("recipe_category");
		String recipeCalories = request.getParameter("recipe_calories");

		Part recipeImage = request.getPart("recipe_img");

		if (recipeName != null && recipeDescription != null && recipeImage != null && recipeSubject != null
				&& recipeSteps != null && recipeCategory != null && recipeCalories != null) {
			System.out.println("log :: all form fields has been initialized");

			recipeBean bean = new recipeBean();

			bean.setName(recipeName);
			bean.setSubject(recipeSubject);
			bean.setDescription(recipeDescription);
			bean.setSteps(recipeSteps);
			bean.setCalories(recipeCalories);
			bean.setCategory(recipeCategory);
			bean.setInventorID(userbean.getId_inventor());

			ServletContext servletContext = getServletContext();

			String imagesDirectoryPath = servletContext.getRealPath("/images");

			String fileName = UUID.randomUUID().toString().substring(0, 6) + getFileName(recipeImage);
			bean.setImgAddress(fileName);

			String filePath = imagesDirectoryPath + File.separator + fileName;
			System.out.println("log :: filePath :: " + filePath);

			if (userbean != null) {
				try (InputStream input = recipeImage.getInputStream()) {
					Files.copy(input, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
				}

				recipedao.addRecipe(bean, userbean.getId_inventor());
				response.sendRedirect("RecipeController?action=myRecipe");
			} else {
				response.sendRedirect("RecipeController");
			}

		} else {
			System.out.println("log :: some of the form fields are null");
			System.out.println("log :: recipeName :: " + recipeName);
			System.out.println("log :: recipeDescription :: " + recipeDescription);
			System.out.println("log :: recipeSubject :: " + recipeSubject);
			System.out.println("log :: recipeImage :: " + recipeImage);
		}
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		for (String content : partHeader.split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}

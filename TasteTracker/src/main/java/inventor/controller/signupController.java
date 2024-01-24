package inventor.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import inventor.dao.inventorDAO;
import inventor.model.userBean;

/**
 * Servlet implementation class signupController
 */

public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private inventorDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public signupController() {
		super();
		dao = new inventorDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			String username = request.getParameter("username");
			String lastname = request.getParameter("lastname");
			String firstname = request.getParameter("firstname");
			String password = request.getParameter("password");

			userBean b = new userBean();
			b.setUsername(username);
			b.setLastName(lastname);
			b.setFirstName(firstname);
			b.setPassword(password);

			if (!username.isEmpty() && !lastname.isEmpty() && !firstname.isEmpty() && !password.isEmpty()) {
				dao.addUser(b);
				
				// store inventor session
				request.getSession().setAttribute("inventor", inventorDAO.getInventor(username));
				response.sendRedirect("RecipeController?action=home");
			} else {
				response.sendRedirect("inventor.jsp");
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("some values are null");
			response.sendRedirect("inventor.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("something went wrong");
			response.sendRedirect("inventor.jsp");
		}

	}

}

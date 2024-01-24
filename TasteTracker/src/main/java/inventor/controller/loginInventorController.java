package inventor.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import inventor.dao.inventorDAO;

public class loginInventorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	public loginInventorController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("debug:: loginInventorController:: POST");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
			if (inventorDAO.inventorLogin(username, password)) {
				System.out.println("login success");

				// store inventor session
				request.getSession().setAttribute("inventor", inventorDAO.getInventor(username));

				response.sendRedirect("RecipeController?action=home");
			} else {
				System.out.println("log :: login fail");
				response.sendRedirect("loginInventor.jsp");
			}
		} else {
			System.out.println("log :: username or password is null or empty");
		}

	}

}

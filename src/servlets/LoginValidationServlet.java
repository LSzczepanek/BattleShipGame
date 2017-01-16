package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.Login;

/**
 * Servlet implementation class LoginValidateServlet
 */
public class LoginValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginValidationServlet() {
		super();
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
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
		String url = "/index.jsp";
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		if (login == null || login.length() == 0 || password == null || password.length() == 0) {
			url = "/index.jsp";
			request.setAttribute("error", "Błąd! Login i hasło nie mogą być puste!");
		} else {
			boolean check = Login.loginValid(login, password);
			if (check == true) {
				

				url = "/loginvalidate.jsp";

			} else {
				url = "/index.jsp";
				request.setAttribute("error", "Błąd! Podane dane są nieprawidłowe!");
			}
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

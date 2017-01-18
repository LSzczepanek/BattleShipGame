package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.Game;
import game.Login;

/**
 * Servlet implementation class LoginValidateServlet
 */
@WebServlet({ "/LoginValidationServlet", "/loginvalidation" })
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
			request.setAttribute("error", "Must be there something!");
		} else {
			boolean check = Login.loginValid(login, password);
			if (check == true) {
				if(!Game.isGamePrepared()){
					Game.prepareGame();
				}
				HttpSession session = request.getSession();
		        session.setAttribute("login", login);
		        if(login.equals(Game.getNickOfPlayer1())){
					request.setAttribute("playerBoard", Game.getBoardOfPlayer1());
					
				}else if(login.equals(Game.getNickOfPlayer2())){
					request.setAttribute("playerBoard", Game.getBoardOfPlayer2());
					
				}else{
					System.out.println("Error");
				}
				url = "/validLogin.jsp";

			} else {
				url = "/index.jsp";
				request.setAttribute("error", "Error, login or password incorrect or someone already took!");
			}
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

package servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.Game;

/**
 * Servlet implementation class GetPlayerBoardServlet
 */
@WebServlet({ "/GetPlayerBoardServlet", "/getPB" })
public class GetPlayerBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPlayerBoardServlet() {
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
		response.getWriter().append("Served at GetPlayerBoard: ").append(request.getContextPath());

		// Set refresh, autoload time as 5 seconds
		//response.setIntHeader("Refresh", 5);
		// Get current time


		String login = (String) request.getSession().getAttribute("login");

		String url = "/playerBoard.jsp";
		
		if (login.equals(Game.getNickOfPlayer1())) {
			request.setAttribute("playerBoard", Game.getBoardOfPlayer1());
			request.setAttribute("enemyBoard", Game.getBoardOfPlayer2());

		} else if (login.equals(Game.getNickOfPlayer2())) {
			request.setAttribute("playerBoard", Game.getBoardOfPlayer2());
			request.setAttribute("enemyBoard", Game.getBoardOfPlayer1());
		} else {
			System.out.println("Error");
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

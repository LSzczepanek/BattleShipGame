package servlets;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.Game;
import game.GameHelper;

/**
 * Servlet implementation class AttackShipServlet
 */
@WebServlet({ "/AttackShipServlet", "/attack" })
public class AttackShipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttackShipServlet() {
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
		response.getWriter().append("Served at AttackShipServlet: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String login = (String) request.getSession().getAttribute("login");
		String url = "/board.jsp";

		if (Pattern.matches("[A-J][0-9]", request.getParameter("fireTo"))) {
			System.out.println("Now is turn of player " + login + ": " + Game.showWhosTurn(login));
			if (Game.isPlayerTurn(login)) {
				int[] position = GameHelper.getCoords((request.getParameter("fireTo")));
				String infoHit = GameHelper.firePlayer(position[0], position[1], login);

				if (infoHit.equals("YOU WON")) {
					url = "/youWon.jsp";
					Game.setSecondPlayerTurn(login);
					request.setAttribute("gameStatus", infoHit);
					Game.getPlayer(login).setTaken(false);

				} else if (infoHit.equals("YOU LOST")) {
					url = "/youLost.jsp";
					request.setAttribute("gameStatus", infoHit);
					Game.getPlayer(login).setTaken(false);

				} else if (!infoHit.equals("HIT") && !infoHit.equals("SHIP DESTROYED") && !infoHit.equals("WRONG")
						&& !infoHit.equals("OUT OF BOARD")) {
					Game.setSecondPlayerTurn(login);
					System.out.println("Used second player turn!!!");
				}

				request.setAttribute("hitInfo", infoHit);
			}
		} else {
			url = "/board.jsp";
			request.setAttribute("errorAttack", "You put wrong data, pattern is e.g A0-A1");
		}
		if (login.equals(Game.getNickOfPlayer1())) {
			request.setAttribute("playerBoard", Game.getBoardOfPlayer1());
			request.setAttribute("enemyBoard", Game.getBoardOfPlayer2());

		} else if (login.equals(Game.getNickOfPlayer2())) {
			request.setAttribute("playerBoard", Game.getBoardOfPlayer2());
			request.setAttribute("enemyBoard", Game.getBoardOfPlayer1());
		} else {
			System.out.println("Error");
		}
		request.setAttribute("whoTurn", Game.showWhosTurn(login));
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

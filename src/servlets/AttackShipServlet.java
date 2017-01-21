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

		String login = (String) request.getSession().getAttribute("login");
		String url = "/board.jsp";
		String infoHit = "Nothing";
		String  fireTo = request.getParameter("fireTo");
		//Sprawdzenie czy user podał prawidłowe dane
		if (Pattern.matches("[A-J][0-9]", fireTo)) {
			System.out.println("Now is turn of player " + login + ": " + Game.showWhosTurn(login));
			//Sprawdzenie czy jest tura danego usera
			if (Game.isPlayerTurn(login)) {
				int[] position = GameHelper.getCoords(fireTo);
				infoHit = GameHelper.firePlayer(position[0], position[1], login);

				if (infoHit.equals("YOU WON")) {
					url = "/youWon.jsp";
					if(Game.getNickOfPlayer1().equals(login)){
						Game.getPlayer(login).setGameStatus(infoHit);
						Game.getPlayer("user2").setGameStatus("YOU LOST");
						Game.getPlayer("user2").setTaken(false);
						Game.setisGamePreparedFalse();
					}else if(Game.getNickOfPlayer2().equals(login)){
						Game.getPlayer(login).setGameStatus(infoHit);
						Game.getPlayer("user").setGameStatus("YOU LOST");
						Game.getPlayer("user").setTaken(false);
					}else{
						Game.getPlayer("user").setGameStatus("YOU LOST");
						Game.getPlayer("user2").setGameStatus("YOU LOST");
						Game.getPlayer("user").setTaken(false);
						Game.getPlayer("user2").setTaken(false);
					}
					
					Game.setSecondPlayerTurn(login);
					request.setAttribute("gameStatus", infoHit);
					Game.getPlayer(login).setTaken(false);
					Game.setisGamePreparedFalse();

				} else if (infoHit.equals("YOU LOST")) {
					url = "/youLost.jsp";
					Game.getPlayer(login).setGameStatus(infoHit);
					request.setAttribute("gameStatus", infoHit);
					Game.getPlayer(login).setTaken(false);
					Game.setisGamePreparedFalse();

				} else if (!infoHit.equals("HIT") && !infoHit.equals("SHIP DESTROYED") && !infoHit.equals("WRONG")
						&& !infoHit.equals("OUT OF BOARD")) {
					Game.getPlayer(login).setHitInfo(infoHit);
					Game.setSecondPlayerTurn(login);
					System.out.println("Used second player turn!!!");
				}else{
					Game.getPlayer(login).setHitInfo(infoHit);
				}

				request.setAttribute("hitInfo", infoHit);
			}
		} else {
			url = "/board.jsp";
			request.setAttribute("errorAttack", "You put wrong data, pattern is e.g A0");
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

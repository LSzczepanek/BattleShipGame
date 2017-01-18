package servlets;

import java.io.IOException;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at AttackShipServlet: ").append(request.getContextPath());
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String login = (String) request.getSession().getAttribute("login");
		int[] position = GameHelper.getCoords((request.getParameter("fireTo")));
		String url = "/board.jsp";
//		if(!Game.isGamePrepared()){
//			Game.prepareGame();
//		}
		
//		String[][] board = Game.getBoardOfPlayer1();

		String infoHit = GameHelper.firePlayer(position[0], position[1], login);

		request.setAttribute("hitInfo", infoHit);
		if(login.equals(Game.getNickOfPlayer1())){
			request.setAttribute("playerBoard", Game.getBoardOfPlayer1());
			request.setAttribute("enemyBoard", Game.getBoardOfPlayer2());
			
			
		}else if(login.equals(Game.getNickOfPlayer2())){
			request.setAttribute("playerBoard", Game.getBoardOfPlayer2());
			request.setAttribute("enemyBoard", Game.getBoardOfPlayer1());
		}else{
			System.out.println("Error");
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

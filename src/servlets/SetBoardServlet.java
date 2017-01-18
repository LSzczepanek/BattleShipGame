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
 * Servlet implementation class TestBoardServlet
 */
@WebServlet({ "/SetBoardServlet", "/setBoard" })
public class SetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetBoardServlet() {
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
		response.getWriter().append("Served at realBoardServlet: ").append(request.getContextPath());

		String url = "/putShips.jsp";
		String login = (String) request.getSession().getAttribute("login");
		int playerAmountOnTheStart = Game.getPlayer(login).amountOfShips;
		System.out.println("User login used: "+request.getSession().getAttribute("login"));
		request.getSession().setAttribute("login", login);
		
		if(Game.getPlayer(login).amountOfShips==0){
			url = "/putShips2.jsp";
			GameHelper.setShipOnBoard(request.getParameter("Ship_2x1"), Game.getPlayer(login).getShip2x1(), login);
		}
		else if(Game.getPlayer(login).amountOfShips==1){
			url = "/putShips3.jsp";
			GameHelper.setShipOnBoard(request.getParameter("Ship_3x1"), Game.getPlayer(login).getShip3x1(), login);
		}
		else if(Game.getPlayer(login).amountOfShips==2){
			url = "/readyPage.jsp";
			GameHelper.setShipOnBoard(request.getParameter("Ship_4x1"), Game.getPlayer(login).getShip4x1(), login);
		}else{
			Game.getPlayer(login).isTaken = false;
			url = "/login.jsp";
		}
		
		if(Game.getPlayer(login).amountOfShips == playerAmountOnTheStart && playerAmountOnTheStart == 0){
			url = "/putShips.jsp";
		}
		if(Game.getPlayer(login).amountOfShips == playerAmountOnTheStart && playerAmountOnTheStart == 1){
			url = "/putShips2.jsp";
		}
		if(Game.getPlayer(login).amountOfShips == playerAmountOnTheStart && playerAmountOnTheStart == 2){
			url = "/putShips3.jsp";
		}
		if(Game.getPlayer(login).amountOfShips == playerAmountOnTheStart && playerAmountOnTheStart == 3){
			url = "/readyPage.jsp";
		}
		
		if(login.equals(Game.getNickOfPlayer1())){
			request.setAttribute("playerBoard", Game.getBoardOfPlayer1());
			
		}else if(login.equals(Game.getNickOfPlayer2())){
			request.setAttribute("playerBoard", Game.getBoardOfPlayer2());
			
		}else{
			System.out.println("Error");
		}
		//String[][] board = { { "B", "B", "S","H" }, { "B", "S", "B","X" }, { "S", "B", "B","J" } };
//		String[][] board = Game.getBoardOfPlayer1();
//		int position[] = GameHelper.getCoords((request.getParameter("fireTo")));
		
//		request.setAttribute("playerBoard", board);
		
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

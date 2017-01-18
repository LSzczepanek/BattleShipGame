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

/**
 * Servlet implementation class IsAllPlayersReadyServlet
 */
@WebServlet({ "/IsAllPlayersReadyServlet", "/isReady" })
public class IsAllPlayersReadyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IsAllPlayersReadyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at isAllPlayerReady: ").append(request.getContextPath());
		String url;
		String login = (String) request.getSession().getAttribute("login");
		request.getSession().setAttribute("login", login);
		Game.setReadyForPlayer(login, true);;
		System.out.println("After set ready"+ Game.getPlayer(login).isReady());
		System.out.println(Game.getNickOfPlayer1()+" is actually : "+Game.getPlayer(login).isReady());
		if(Game.areAllPlayersReady()){
//			if(false){
			if(login.equals(Game.getNickOfPlayer1())){
				request.setAttribute("playerBoard", Game.getBoardOfPlayer1());
				request.setAttribute("enemyBoard", Game.getBoardOfPlayer2());
				
			}else if(login.equals(Game.getNickOfPlayer2())){
				request.setAttribute("playerBoard", Game.getBoardOfPlayer2());
				request.setAttribute("enemyBoard", Game.getBoardOfPlayer1());
				
			}else{
				System.out.println("Error");
			}
			url = "/board.jsp";
		}else{
//			
			if(login.equals(Game.getNickOfPlayer1())){
				request.setAttribute("playerBoard", Game.getBoardOfPlayer1());
				
			}else if(login.equals(Game.getNickOfPlayer2())){
				request.setAttribute("playerBoard", Game.getBoardOfPlayer2());
				
			}else{
				System.out.println("Error");
			}
			request.setAttribute("readyInfo", "Your enemy is not ready yet, wait 5sec before next check");
			url = "/redirectToIsReady.jsp";
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*"%>
<%@page import="game.Game"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<script type="text/javascript" c>
	var url = '/BattleShipGame/playerBoard.jsp';

	$(document)
			.ready(
					function() {

						$.ajaxSetup({
							cache : false
						});
						if (<%=Game.getPlayer((String) request.getSession().getAttribute("login")).checkIsMyTurn()%>== false) {
							setInterval(function() {
								$("#getPlayerBoard").load(url);
							}, 5000);

						}
					});
</script>
</head>
<body>

	<center>

		<%
			String login = (String) request.getSession().getAttribute("login");
			System.out.println(login);
			System.out.println(Game.getNickOfPlayer1());
			if (login.equals(Game.getNickOfPlayer1())) {
				request.setAttribute("playerBoardRef", Game.getBoardOfPlayer1());
				request.setAttribute("enemyBoardRef", Game.getBoardOfPlayer2());

			} else if (login.equals(Game.getNickOfPlayer2())) {
				request.setAttribute("playerBoardRef", Game.getBoardOfPlayer2());
				request.setAttribute("enemyBoardRef", Game.getBoardOfPlayer1());
			} else {
				System.out.println("Error");
			}

			request.setAttribute("hitInfo", Game.getPlayer(login).getHitInfo());

			request.setAttribute("gameStatus", Game.getPlayer(login).getGameStatus());
			if (Game.getPlayer(login).getGameStatus().equals("YOU WON")) {
				request.setAttribute("gameStatus", 1);
			} else if (Game.getPlayer(login).getGameStatus().equals("YOU LOST")) {
				request.setAttribute("gameStatus", 2);
			} else {
				request.setAttribute("gameStatus", 0);
			}
		%>
		<!-- Header
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
		<%@include file="header2.jsp"%>
		<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->



		<%@include file="enemyBoard.jsp"%>
		<div id="getPlayerBoard"></div>

		<c:set var="hitInfo" value="${requestScope.infoHit}" scope="page" />
		<h1>${hitInfo}</h1>


		<form action="attack" method=post>
			<input name="fireTo" type="text" required>
			<button>Fire!</button>
			<c:set var="errorAttack" value="${requestScope.errorAttack}"
				scope="page" />
			<p>${errorAttack}</p>
		</form>




		<c:set var="gameStatus" value="${requestScope.gameStatus}"
			scope="page" />



		<c:if test="${gameStatus == 1}">
			<%@ page autoFlush="true" buffer="1094kb"%>
			<jsp:forward page="youWon.jsp" />
		</c:if>
		<c:if test="${gameStatus == 2}">
			<%@ page autoFlush="true" buffer="1094kb"%>
			<jsp:forward page="youLost.jsp" />
		</c:if>

		<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

		<%@include file="footer.jsp"%>
	</center>
</body>
</html>

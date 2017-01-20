<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*"%>
<%@page import="game.Game"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


</head>
<body>
	<center>

		<!-- Header
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

		<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

		<%
			String login = "user";//(String) request.getSession().getAttribute("login");
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

			request.setAttribute("whoTurn", Game.showWhosTurn(login));
			request.setAttribute("gameStatus", Game.getPlayer(login).getGameStatus());
			request.setAttribute("hitInfo", Game.getPlayer(login).getHitInfo());

			if (Game.getPlayer(login).getGameStatus().equals("YOU WON")) {
				request.setAttribute("gameStatus", 1);
			} else if (Game.getPlayer(login).getGameStatus().equals("YOU LOST")) {
				request.setAttribute("gameStatus", 2);
			} else {
				request.setAttribute("gameStatus", 0);
			}
		%>
		%>

		<h1>ENEMY BOARD</h1>
		<table>


			<c:forEach var="field" items='${requestScope.enemyBoardRef}'>
				<tr>
					<c:forEach var="i" begin="0" end="${fn:length(field)-1}">
						<c:choose>
							<c:when test="${field[i] == 'W'}">
								<td
									style="background-color: blue; padding-left: 2em; padding-top: 2em;">&nbsp</td>
							</c:when>
							<c:when test="${field[i] == 'S'}">
								<td
									style="background-color: blue; padding-left: 2em; padding-top: 2em;">&nbsp</td>
							</c:when>
							<c:when test="${field[i] == 'X'}">
								<td
									style="background-color: red; padding-left: 2em; padding-top: 2em;">&nbsp</td>
							</c:when>
							<c:when test="${field[i] == 'O'}">
								<td
									style="background-color: gray; padding-left: 2em; padding-top: 2em;">&nbsp</td>
							</c:when>
							<c:otherwise>
								<td
									style="background-color: white; padding-left: 2em; padding-top: 2em;">${field[i]}</td>
							</c:otherwise>
						</c:choose>
					</c:forEach>

				</tr>
			</c:forEach>
		</table>



		<h1>YOUR BOARD</h1>
		<table>


			<c:forEach var="field" items='${requestScope.playerBoardRef}'>
				<tr>
					<c:forEach var="i" begin="0" end="${fn:length(field)-1}">
						<c:choose>
							<c:when test="${field[i] == 'W'}">
								<td
									style="background-color: blue; padding-left: 2em; padding-top: 2em;">&nbsp</td>
							</c:when>
							<c:when test="${field[i] == 'S'}">
								<td
									style="background-color: black; padding-left: 2em; padding-top: 2em;">&nbsp</td>
							</c:when>
							<c:when test="${field[i] == 'X'}">
								<td
									style="background-color: red; padding-left: 2em; padding-top: 2em;">&nbsp</td>
							</c:when>
							<c:when test="${field[i] == 'O'}">
								<td
									style="background-color: gray; padding-left: 2em; padding-top: 2em;">&nbsp</td>
							</c:when>
							<c:otherwise>
								<td
									style="background-color: white; padding-left: 2em; padding-top: 2em;">${field[i]}</td>
							</c:otherwise>
						</c:choose>
					</c:forEach>

				</tr>
			</c:forEach>
		</table>




		<c:set var="whoTurn" value="${requestScope.whoTurn}" scope="page" />
		<h1>${whoTurn}</h1>

		<c:set var="hitInfo" value="${requestScope.infoHit}" scope="page" />
		<h1>${hitInfo}</h1>


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


	</center>
</body>
</html>

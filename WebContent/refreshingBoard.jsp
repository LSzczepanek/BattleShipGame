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

	$(document).ready(function() {

		$.ajaxSetup({
			cache : false
		});

		setInterval(function() {
			$("#getPlayerBoard").load(url);
		}, 5000);

	});
</script>



</head>
<body>
	<center>

		<!-- Header
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

		<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

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

			request.setAttribute("whoTurn", Game.showWhosTurn(login));
			
			request.setAttribute("hitInfo", Game.getPlayer(login).getHitInfo());


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



		<div id="getPlayerBoard">

		</div>



		<c:set var="whoTurn" value="${requestScope.whoTurn}" scope="page" />
		<h1>${whoTurn}</h1>

		<c:set var="hitInfo" value="${requestScope.infoHit}" scope="page" />
		<h1>${hitInfo}</h1>


		


		<!-- Footer 
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->


	</center>
</body>
</html>

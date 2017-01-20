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
	var url2 = '/BattleShipGame/getWhoTurn.jsp';

	$(document).ready(function() {

		$.ajaxSetup({
			cache : false
		});

		setInterval(function() {
			$("#getTurn").load(url2);
		}, 5000);

	});
</script>

</head>
<body>

	<!-- Header
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <%
    String login = (String) request.getSession().getAttribute("login");
    if (login.equals(Game.getNickOfPlayer1())) {
		request.setAttribute("playerBoard1", Game.getBoardOfPlayer1());

	} else if (login.equals(Game.getNickOfPlayer2())) {
		request.setAttribute("playerBoard1", Game.getBoardOfPlayer2());
	} else {
		System.out.println("Error");
	}
	%>
	<div id="getTurn"></div>
	<h1>YOUR BOARD</h1>
	<table>


		<c:forEach var="field" items='${requestScope.playerBoard1}'>
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



	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
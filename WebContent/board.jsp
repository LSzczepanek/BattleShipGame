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
		<%@include file="header2.jsp"%>
		<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
        <script>
  setTimeout(function() {
      document.location = "/BattleShipGame/attack";
  }, 5000); // <-- this is the delay in milliseconds
</script>

		<%@include file="enemyBoard.jsp"%>

		<c:set var="whoTurn" value="${requestScope.whoTurn}" scope="page" />
		<h1>${whoTurn}</h1>
		<c:set var="hitInfo" value="${requestScope.infoHit}" scope="page" />
		<h1>${hitInfo}</h1>

		<%@include file="playerBoard.jsp"%>

		<form action="attack" method=post>
			<input name="fireTo" type="text" required>
			<button>Fire!</button>
			<c:set var="errorAttack" value="${requestScope.errorInSetBoard}"
				scope="page" />
			<p>${errorAttack}</p>

		</form>
		<c:set var="gameStatus" value="${requestScope.gameStatus}" />
		<c:set var="won" value="YOU WON" />
		<c:set var="lost" value="YOU LOST" />
		<c:choose>
			<c:when test="${gameStatus}.equals(${won})">

				<c:redirect url="youWon.jsp" />
			</c:when>
			<c:when test="${gameStatus}.equals(${lost})">

				<c:redirect url="/youLost.jsp" />
			</c:when>

			<c:otherwise>
				<p>Game is still ongoing</p>
			</c:otherwise>
		</c:choose>

		<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

		<%@include file="footer.jsp"%>
	</center>
</body>
</html>

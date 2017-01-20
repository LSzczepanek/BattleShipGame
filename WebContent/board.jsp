<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*"%>
<%@page import="game.Game"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- <META HTTP-EQUIV="Refresh" CONTENT="10">-->


<script src="http://code.jquery.com/jquery-latest.js">
	   
        
</script>
<script>
	            $(document).ready(function() {
		$('#fireButton').click(function(event) {
			var hitInfo = $('#fireTo').val();
			$.get('/BattleShipGame/attack', {
				fireTo : hitInfo
			}, function(responseText) {
				$('#status').text(responseText);
				$("#content").load('/BattleShipGame/refreshingBoard.jsp');
			});
		});
	});
</script>
</head>
<body>

	<center>
		<%
			String loginBoard = (String) request.getSession().getAttribute("login");
			request.setAttribute("gameStatus", Game.getPlayer(loginBoard).getGameStatus());
			if (Game.getPlayer(loginBoard).getGameStatus().equals("YOU WON")) {
				request.setAttribute("gameStatus", 1);
			} else if (Game.getPlayer(loginBoard).getGameStatus().equals("YOU LOST")) {
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


		<div id="content">
			<%@include file="refreshingBoard.jsp"%>

		</div>

		<form id="form1">
		<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
		Enter your Name: <input type="text" id="fireTo" /> <input type="button"
			id="fireButton" value="fireTo" />    
		<div id="status"></div>
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

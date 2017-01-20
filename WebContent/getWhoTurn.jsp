<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*, java.util.*"%>
<%@page import="game.Game"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<title>getWhoTurn</title>
</head>
<body>
	<%
		String login = (String) request.getSession().getAttribute("login");

		String url = "/getWhoTurn.jsp";

		String turn = Game.showWhosTurn(login);
		request.setAttribute("whoTurn", turn);
	%>

	<c:set var="whoTurn" value="${requestScope.whoTurn}" scope="page" />
	<p>${whoTurn}</p>

</body>
</html>
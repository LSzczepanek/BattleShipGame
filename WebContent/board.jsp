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

	<%@include file="enemyBoard.jsp"%>


	<c:set var="hitInfo" value="${requestScope.infoHit}" scope="page" />
	<h1>${hitInfo}</h1>

	<%@include file="playerBoard.jsp"%>

	<form action="attack" method=post>
		<input name="fireTo" type="text">
		<button>Fire!</button>
		
	</form>


	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

	<%@include file="footer.jsp" %>
	</center>
</body>
</html>

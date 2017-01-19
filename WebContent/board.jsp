<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*"%>
<%@page import="game.Game"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

   <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.0/jquery.min.js"></script>
    <script type="text/javascript">
    var auto_refresh = setInterval(
    function ()
    {
    $('#reloadPB').load('playerBoard.jsp').fadeIn("slow");
    }, 5000); // autorefresh the content of the div after
               //every 10000 milliseconds(10sec)
    </script>
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

	<c:set var="playerBoard" value="${requestScope.playerBoard}" scope="page" />
	
	<div id="reloadPB">
	<%@include file="playerBoard.jsp"%>
	</div>

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

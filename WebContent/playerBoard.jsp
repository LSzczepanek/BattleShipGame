<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@page import="game.Game"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		var reloadData = 0; // store timer

		// load data on page load, which sets timeout to reload again
		loadData();
	});

	function loadData() {
		$('#load_me').load('board.jsp', function() {
			if (reloadData != 0)
				window.clearTimeout(reloadData);
			reloadData = window.setTimeout(loadData, 10000)
		}).fadeIn("slow");
	}
</script>
</head>
<body>

	<!-- Header
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->


	<h1>YOUR BOARD</h1>
	<table>


		<c:forEach var="field" items='${requestScope.playerBoard}'>
			<tr>
				<c:forEach var="i" begin="0" end="${fn:length(field)-1}">
					<c:choose>
						<c:when test="${field[i] == 'B'}">
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
						<c:when test="${field[i] == 'H'}">
							<td
								style="background-color: gray; padding-left: 2em; padding-top: 2em;">&nbsp</td>
						</c:when>
						<c:otherwise>
							<td
								style="background-color: blue; padding-left: 2em; padding-top: 2em;">&nbsp</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</tr>
		</c:forEach>
	</table>



	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<%@include file="footer.jsp"%>
</body>
</html>
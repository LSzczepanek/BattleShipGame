<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<script type="text/javascript" c>
	var url = '/BattleShipGame/getPB'

	$(document).ready(function() {

		$.ajaxSetup({
			cache : false
		});

		setInterval(function() {
			$("#getPlayerBoard").load(url);
		}, 1000);

	});
</script>
</head>
<body>
	<center>
		<!-- Header
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
		<%@include file="header2.jsp"%>
		<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
		<%@include file ="playerBoard.jsp" %>

		<form action="setBoard" method=get>
			<label>Ship 2x1</label> <input name="Ship_2x1" type="text" required>
			<button>set ship 2x1</button>
			<c:set var="errorPutShips" value="${requestScope.errorInSetBoard}"
				scope="page" />
			<p>${errorPutShips}</p>
		</form>


		<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

		<%@include file="footer.jsp"%>
	</center>
</body>
</html>
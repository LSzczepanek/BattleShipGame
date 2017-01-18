<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
</head>
<body>
	<!-- Header
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <%@include file="header2.jsp"%>
	<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <p> You are logged in as: ${sessionScope.login}</p>
    
    <script>
  setTimeout(function() {
      document.location = "/BattleShipGame/isReady";
  }, 5000); // <-- this is the delay in milliseconds
</script>
    <%@include file="playerBoard.jsp" %>
	<form action="isReady" method=get>
	<c:set var="readyInfo" value="${requestScope.error}" scope="page" />
	<h2>Game is preparin to start wait 5sec</h2>
	<p>${readyInfo}</p>
	<!-- <button>I am ready!!</button>-->
	</form>


	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<%@include file="footer.jsp"%>
</body>
</html>
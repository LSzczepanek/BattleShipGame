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
    
    
    <%@include file="playerBoard.jsp" %>
	<form action="setBoard" method=get>
	<label>Ship 2x1</label>
	<input name="Ship_2x1" type="text" >
	<button>set ship 2x1</button>
	</form>


	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

	<%@include file="footer.jsp"%>
</body>
</html>
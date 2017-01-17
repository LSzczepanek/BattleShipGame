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
	<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<form action="test" method=get>
	<label>Statek1</label>
	<input name="ship1" type="text" pattern="tu wpisz pozycję statku">
	<button>Wyślij pozycję</button>
	</form>


	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

	<p>Created by Lukasz Szczepanek</p>
</body>
</html>

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
	<table>


		<c:forEach var="field" items='${requestScope.board}'>
			<tr>
				<c:forEach var="i" begin="0" end="${fn:length(field)-1}">
					<c:choose>
						<c:when test="${field[i] == 'B'}">
							<td style="background-color: blue; padding-left: 2em; padding-top: 2em;">&nbsp</td>
						</c:when>
						<c:when test="${field[i] == 'S'}">
							<td style="background-color: black; padding-left: 2em; padding-top: 2em;">&nbsp</td>
						</c:when>
						<c:when test="${field[i] == 'X'}">
							<td style="background-color: red; padding-left: 2em; padding-top: 2em;">&nbsp</td>
						</c:when>
						<c:when test="${field[i] == 'H'}">
							<td style="background-color: gray; padding-left: 2em; padding-top: 2em;">&nbsp</td>
						</c:when>
						<c:otherwise>
							<td style="background-color: blue; padding-left: 2em; padding-top: 2em;">&nbsp</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</tr>
		</c:forEach>
	</table>
	<form action="test2" method=get>
	<button>TEST</button>
	</form>
	
	<form action="attack" method=post>
	<input name="ship1" type="text" pattern="tu wpisz pozycję statku">
	<button>Zaatakuj punkt</button>
	</form>


	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->

	<p>Created by Lukasz Szczepanek</p>
</body>
</html>
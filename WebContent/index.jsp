
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="head.jsp"%>
</head>
<body>
	<!-- Header
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <%@include file="header.jsp"%>
	<!-- Page
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	<%
		session.invalidate();
	%>
	<c:set var="error_msg" value="${requestScope.error}" scope="page" />
				<h2>Login in</h2>
			<form action="loginvalidation" method=post>
				<input  type="text" name="login" required> <label
					>Login</label> <input class="w3-input"
					type="password" name="password" required> <label
					 style="display: block">Password</label> <br>
				<button>Login</button>
			</form>
			<p>${error_msg}</p>
		</div>
		<div></div>
	</div>


	<!-- Footer
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
	
		<p>Created by
			Lukasz Szczepanek</p>


</body>
</html>
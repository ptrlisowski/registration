<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="UTF-8" isELIgnored="false"%> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%-- <c:import url="../header.jsp" /> --%>

<%-- <c:choose> --%>
<%-- <c:when test="${sessionScope.loggedin}"> --%>
<%-- <h2>Witaj "${activeUser.name}"</h2> --%>

<%-- 		<a href='<c:url value="/user/logout"></c:url>'>Wyloguj</a> --%>

<%-- 	</c:when> --%>

<%-- <c:otherwise> --%>
<%-- <form action='<c:url value="/user/login" />' method="post"> --%>
<!-- 	<label> Numer PESEL: <input type="number" name="username" /> -->
<!-- 	</label> <label> Hasło: <input type="password" name="password" /> -->
<!-- 	</label> <input type="submit" value="Sign In" /> -->
<%-- </c:otherwise> --%>
<%-- </c:choose> --%>
<%-- <c:import url="../footer.jsp" /> --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body onload='document.loginForm.username.focus();'>

	<h1>Spring Security Login Form (Database Authentication)</h1>

	<div id="login-box">

		<c:if test="${param.error != null}">
			<p>Invalid username / password</p>
		</c:if>
	
		<form action='<c:url value="/user/login" />' method="POST">
			<p>
				<label for="username">User:</label>
			</p>
			<input type="text" id="username" name="username" />

			<p>
				<label for="password">Password:</label>
			</p>
			<input type="password" id="password" name="password">

			<div>
				<input name="submit" type="submit" />
			</div>
		</form>
	</div>

</body>
</html>

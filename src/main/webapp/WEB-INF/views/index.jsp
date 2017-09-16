<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>
	
	<nav>
	<ul>
		
		<c:if test="${sessionScope.loggedin}">
		<li>zalogowany</li>
		
		</c:if>
		<c:if test="${sessionScope.loggedin ne true}">
		<li>niezalogowany</li>
		</c:if>
	</ul>
</nav>
	
	<p>Witaj na stronie rejestracji internetowej</p>
	
	<c:import url="footer.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../header.jsp"/>
	
	<c:choose>
	<c:when test="${msg ne null}">
	<p>${msg} ${user.name} ${user.lastName}</p>
	</c:when>
	
	<c:otherwise>
	<p>Jeśli nie posiadasz konta kliknij <a href='<c:url value="/user/register"></c:url>'>tutaj</a> aby założyć</p>
	</c:otherwise>
	
	</c:choose>
		
	
	<c:choose>
	<c:when test="${sessionScope.loggedin}">
<h2>Witaj "${activeUser.name}"</h2>

		<a href='<c:url value="/user/logout"></c:url>'>Wyloguj</a>
		
	</c:when>
	
	<c:otherwise>
	
	
	
	<p>Jeśli posiadasz konto kliknij <a href='<c:url value="/user/login"></c:url>'>tutaj</a> aby sie zalogować</p>
	
	</c:otherwise>
	</c:choose>
	
	<c:import url="../footer.jsp"/>
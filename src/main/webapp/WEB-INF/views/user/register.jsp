<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../header.jsp"/>
	
	<p>Zarejestruj się w systemie</p>
	
	<form action='<c:url value="/user/register" />' method="POST">

	Podaj imię <input type="text" name="name" /><br>
	Podaj nazwisko <input type="text" name="lastname" /><br>
	Podaj datę urodzenia <input type="text" name="birth" /><br>
	Podaj numer telefonu <input type="text" name="phone" /><br>
	<br>
	Podaj numer PESEL <input type="number" name="username" /><br>
	Podaj hasło do konta <input type="password" name="pass" /><br>
	
	<p>Numer PESEL i hasło będą potrzebne w celu zalogowania się do systemu</p>
	

	
<button type="submit">Zarejestruj użytkownika</button>
</form>
	
	<c:import url="../footer.jsp"/>
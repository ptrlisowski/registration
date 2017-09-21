<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:import url="../header.jsp" />

	<c:choose>
		<c:when test="${user ne null}">
			<p>Witaj ${user}</p>
		</c:when>
		
		<c:when test="${msg ne null}">
			<p>${msg} ${user.name} ${user.lastName}</p>
		</c:when>

		<c:otherwise>
		<c:if test="${logout ne null}">
		<p>${logout}</p>
		</c:if>
		
		<c:if test="${exists ne null}">
		<p>${exists}</p>
		</c:if>
			<p>
				Jeśli nie posiadasz konta kliknij <a
					href='<c:url value="/user/register"></c:url>'>tutaj</a> aby założyć
			</p>
			
			<p>
				Jeśli posiadasz konto kliknij <a
					href='<c:url value="/user/login"></c:url>'>tutaj</a> aby sie
				zalogować
			</p>
			
		</c:otherwise>

	

			
</c:choose>
	<c:import url="../footer.jsp" />
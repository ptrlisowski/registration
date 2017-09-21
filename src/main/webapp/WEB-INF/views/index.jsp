<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <label>
     Witaj ${pageContext.request.userPrincipal.name}
    </label>
    
    <form id="logout" action='<c:url value="/logout" />' method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<input type="submit" value="wyloguj">
    
</c:if>
		
	
     

	<p>Witaj na stronie rejestracji internetowej</p>
	
	<c:import url="footer.jsp"/>
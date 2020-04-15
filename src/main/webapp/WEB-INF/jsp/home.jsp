<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="header.jsp"/>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
            <img src="avocado.jpg">
        </h2>
    </c:if>
</div>
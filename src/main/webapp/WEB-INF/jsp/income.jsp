<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<div class="container">
    <a href="/transactions/income/create">Create</a>
    <table class="table table-hover table-responsive">
        <tr>
            <th>Amount</th>
            <th>Date</th>
            <th>Description</th>
            <th>Category</th>
        </tr>

        <c:forEach var="income" items="${incomePage.getContent()}">
            <tr>
                <td>${income.amount}</td>
                <td>${income.date}</td>
                <td>${income.description}</td>
                <td>${income.category.name}</td>
            </tr>
        </c:forEach>
    </table>

    <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${incomePage.hasPrevious()}">
        <td><a href="/transactions/income?page=${incomePage.getPageable().getPageNumber()-1}">Previous</a></td>
    </c:if>

    <%--For displaying Next link --%>
    <c:if test="${incomePage.hasNext()}">
        <td><a href="/transactions/income?page=${incomePage.getPageable().getPageNumber()+1}">Next</a></td>
    </c:if>


</div>
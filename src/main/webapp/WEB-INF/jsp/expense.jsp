<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<div class="container">
    <table class="table table-hover table-responsive">
        <tr>
            <th>Amount</th>
            <th>Date</th>
            <th>Description</th>
            <th>Category</th>
        </tr>

        <c:forEach var="expense" items="${expensePage.getContent()}">
            <tr>
                <td>${expense.amount}</td>
                <td>${expense.date}</td>
                <td>${expense.description}</td>
                <td>${expense.category.name}</td>
            </tr>
        </c:forEach>
    </table>

    <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${expensePage.hasPrevious()}">
        <td><a href="/transactions/expense?page=${expensePage.getPageable().getPageNumber()-1}">Previous</a></td>
    </c:if>

    <%--For displaying Next link --%>
    <c:if test="${expensePage.hasNext()}">
        <td><a href="/transactions/expense?page=${expensePage.getPageable().getPageNumber()+1}">Next</a></td>
    </c:if>

</div>
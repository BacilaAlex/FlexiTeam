<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Employee">
    <form method="POST" action="${pageContext.request.contextPath}/Employees">
        <div class="container text-center">
            <c:forEach var="employee" items="${employees}">
                <div class="row">
                    <div class="col">${employee.firstName}</div>
                    <div class="col">${employee.lastName}</div>
                    <div class="col">${employee.gender}</div>
                    <div class="col">${employee.dateOfBirth}</div>
                    <div class="col">${employee.address}</div>
                    <div class="col">${employee.salaryClass}</div>
                    <div class="col">${employee.monthlySalary}</div>
                    <div class="col">${employee.bonus}</div>
                    <div class="col">${employee.taxClass}</div>
                    <div class="col">${employee.religion}</div>
                    <div class="col">${employee.workingTime}</div>
                    <div class="col">${employee.bankAccount}</div>
                    <div class="col">
                        <a class="btn btn-secondary"
                           href="${pageContext.request.contextPath}/EditEmployee?id=${employee.id}">Edit Employee</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </form>
</t:pageTemplate>

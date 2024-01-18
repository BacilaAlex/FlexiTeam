<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="EditEmployee">
    <h1 class="font text-center">Salary Sheet</h1>
    <div class="flex justify-center gap-6">
        <div>
            <div>First Name: ${employee.firstName}</div>
            <div>Last Name: ${employee.lastName}</div>
            <div>Date of birth:${dob}</div>
            <div>Address: ${employee.address}</div>
        </div>
        <div>
            <div>Salary Class: ${employee.salaryClass}</div>
            <div>Tax Class: ${employee.taxClass}</div>
            <div>Bank Account: ${employee.bankAccount}</div>
            <div>Working Time: ${employee.workingTime}</div>
        </div>
        <div>
            <div>Basic Salary: ${employee.monthlySalary}</div>
            <div>Total Salary:</div>
            <div>Taxes:</div>
            <div>Social charges:</div>
        </div>
        <div>
            <c:if test="true">
                <div>Bonus: ${employee.bonus}</div>
            </c:if>
            <div>Salary after taxes and social charges:</div>
        </div>
    </div>
</t:pageTemplate>
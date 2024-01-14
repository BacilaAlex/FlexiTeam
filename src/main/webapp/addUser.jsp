<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pageTemplate pageTitle="AddUser">
    <h1>Add Username</h1>

    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddUser">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username" class="form-label">Username</label>
                <input name="username" type="text" class="form-control" id="username" required placeholder=""
                       value="">
                <div class="invalid-feedback">
                    Username is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email" class="form-label">Email</label>
                <input name="email" type="email" class="form-control" id="email" required placeholder=""
                       value="">
                <div class="invalid-feedback">
                    Email is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password" class="form-label">Password</label>
                <input name="password" type="password" class="form-control" id="password" required placeholder=""
                       value="">
                <div class="invalid-feedback">
                    Password is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="employee_id" class="form-label">Employee</label>
                <select name="employee_id" class="customer-select d-block w-100" id="employee_id" required>
                    <option value="">Choose...</option>
                    <c:forEach items="${employees}" var="employee">
                        <option value="${employee.id}">
                                ${employee.firstName} ${employee.lastName}
                        </option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select an Employee.
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg" type="submit">Save</button>
    </form>
</t:pageTemplate>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="EditUser">
    <h1>Edit User</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditUser">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username" class="form-label">Username</label>
                <input name="username" type="text" class="form-control" id="username" required
                       default="${user.username}" placeholder="${user.username}"
                       value="${user.username}">
                <div class="invalid-feedback">
                    Username is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email" class="form-label">Email</label>
                <input name="email" type="email" class="form-control" id="email" required default="${user.email}"
                       placeholder="${user.email}"
                       value="${user.email}">
                <div class="invalid-feedback">
                    Email is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password" class="form-label">Password</label>
                <input name="password" type="password" class="form-control" id="password" required
                       default="${user.password}" placeholder="${user.password}"
                       value="${user.password}">
                <div class="invalid-feedback">
                    Password is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="employee_id">Employee</label>
                <select class="form-select" id="employee_id" name="employee_id" required>
                    <option value="">Choose...</option>
                    <c:forEach var="employee" items="${employees}" varStatus="status">
                        <option value="${employee.id}"${user.employeeId eq employee.id ? 'selected' : ''}>${employee.firstName} ${employee.lastName}</option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Employee is required.
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <input type="hidden" name="user_id" value="${user.id}"/>
        <button class="btn btn-primary btn-lg" type="submit">Save</button>
    </form>
</t:pageTemplate>
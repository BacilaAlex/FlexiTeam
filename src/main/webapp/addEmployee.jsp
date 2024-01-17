<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="AddEmployee">
    <h1>Add Employee</h1>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddEmployee">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="first_name" class="form-label">First Name</label>
                <input name="first_name" type="text" class="form-control" id="first_name" required placeholder=""
                       value="">
                <div class="invalid-feedback">
                    First Name is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="last_name" class="form-label">Last Name</label>
                <input name="last_name" type="text" class="form-control" id="last_name" required placeholder=""
                       value="">
                <div class="invalid-feedback">
                    Last Name is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="gender" class="form-label">Gender</label>
                <select name="gender" class="customer-select d-block w-100" id="gender" required>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                    <option value="disabled">Disabled</option>
                </select>
                <div class="invalid-feedback">
                    Please select a Gender.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="date_of_birth" class="form-label">Date of Birth</label>
                <input name="date_of_birth" type="date" class="form-control" id="date_of_birth" required placeholder=""
                       value="">
                <div class="invalid-feedback">
                    Date of Birth is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="address" class="form-label">Address</label>
                <input name="address" type="text" class="form-control" id="address" required placeholder="" value="">
                <div class="invalid-feedback">
                    Address is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="monthly_salary" class="form-label">Monthly Salary(RON)</label>
                <input name="monthly_salary" type="text" class="form-control" id="monthly_salary" required
                       placeholder="" value="">
                <div class="invalid-feedback">
                    Monthly Salary is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="bonus" class="form-label">Bonus(RON)</label>
                <input name="bonus" type="text" class="form-control" id="bonus" value="0">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="religion" class="form-label">Religion</label>
                <input name="religion" type="text" class="form-control" id="religion" required value="">
                <div class="invalid-feedback">
                    Religion is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="bank_account" class="form-label">Bank Account</label>
                <input name="bank_account" type="text" class="form-control" id="bank_account" required value="">
                <div class="invalid-feedback">
                    Bank Account is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="salary_class" class="form-label">Salary Class</label>
                <select name="salary_class" class="customer-select d-block w-100" id="salary_class" required>
                    <option value="">Choose...</option>
                    <c:forEach items="${salaryClasses}" var="salaryClass">
                        <option value="${salaryClass}">
                                ${salaryClass}
                        </option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select a Salary Class.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="tax_class" class="form-label">Tax Class</label>
                <select name="tax_class" class="customer-select d-block w-100" id="tax_class" required>
                    <option value="">Choose...</option>
                    <c:forEach items="${taxClasses}" var="taxClass">
                        <option value="${taxClass}">
                                ${taxClass}
                        </option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select a Tax Class.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="working_time" class="form-label">Working Time</label>
                <select name="working_time" class="customer-select d-block w-100" id="working_time" required>
                    <option value="">Choose...</option>
                    <c:forEach items="${workingTimes}" var="workingTime">
                        <option value="${workingTime}">
                                ${workingTime}
                        </option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">
                    Please select a Working Time.
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg" type="submit">Save</button>
    </form>
</t:pageTemplate>
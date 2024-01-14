<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pageTemplate pageTitle="EditEmployee">
  <h1>Edit Employee</h1>

  <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditEmployee">
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="first_name" class="form-label">First Name</label>
        <input name="first_name" type="text" class="form-control" id="first_name" placeholder="${employee.firstName}"
               value="${employee.firstName}">
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="last_name" class="form-label">Last Name</label>
        <input name="last_name" type="text" class="form-control" id="last_name" placeholder="${employee.lastName}"
               value="${employee.lastName}">
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="address" class="form-label">Address</label>
        <input name="address" type="text" class="form-control" id="address" placeholder="${employee.address}"
               value="${employee.address}">
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="monthly_salary" class="form-label">Monthly Salary(RON)</label>
        <input name="monthly_salary" type="text" class="form-control" id="monthly_salary" placeholder="${employee.monthlySalary}"
               value="${employee.monthlySalary}">
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
        <input name="religion" type="text" class="form-control" id="religion" placeholder="${employee.religion}"
               value="${employee.religion}">
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="bank_account" class="form-label">Bank Account</label>
        <input name="bank_account" type="text" class="form-control" id="bank_account" placeholder="${employee.bankAccount}"
               value="${employee.bankAccount}">
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="salary_class" class="form-label">Salary Class</label>
        <select name="salary_class" class="customer-select d-block w-100" id="salary_class" required>
          <c:forEach items="${employee.salaryClass.values()}" var="salaryClass">
            <option value="${salaryClass}" ${employee.salaryClass == salaryClass ? 'selected' : ''}>
                ${salaryClass}
            </option>
          </c:forEach>
        </select>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="tax_class" class="form-label">Tax Class</label>
        <select name="tax_class" class="customer-select d-block w-100" id="tax_class" required>
          <c:forEach items="${employee.taxClass.values()}" var="taxClass">
            <option value="${taxClass}" ${employee.taxClass == taxClass ? 'selected' : ''}>
                ${taxClass}
            </option>
          </c:forEach>
        </select>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="working_time" class="form-label">Working Time</label>
        <select name="working_time" class="customer-select d-block w-100" id="working_time" required>
          <c:forEach items="${employee.workingTime.values()}" var="workingTime">
            <option value="${workingTime}" ${employee.workingTime == workingTime ? 'selected' : ''}>
                ${workingTime}
            </option>
          </c:forEach>
        </select>
      </div>
    </div>
    <hr class="mb-4">
    <input type="hidden" name="employee_id" value="${employee.id}"/>
    <button class="btn btn-primary btn-lg" type="submit">Save</button>
  </form>
</t:pageTemplate>
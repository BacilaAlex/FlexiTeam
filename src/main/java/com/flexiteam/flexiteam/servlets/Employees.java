package com.flexiteam.flexiteam.servlets;

import com.flexiteam.flexiteam.dtos.EmployeeDto;
import com.flexiteam.flexiteam.ejb.EmployeeBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DeclareRoles({"READ_USERS", "WRITE_USERS"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"READ_USERS"}),
        httpMethodConstraints = {@HttpMethodConstraint(value = "POST",
                rolesAllowed = {"WRITE_USERS"})})
@WebServlet(name = "Employees", value = "/Employees")
public class Employees extends HttpServlet {
    @Inject
    EmployeeBean employeeBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EmployeeDto> employees = employeeBean.findAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/WEB-INF/pages/addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] employeeIdsString = request.getParameterValues("employee_ids");

        if (employeeIdsString != null) {
            List<Long> employeeIds = new ArrayList<>();
            for (String employeeId : employeeIdsString) {
                employeeIds.add(Long.parseLong(employeeId));
            }
            employeeBean.deleteEmployeesById(employeeIds);
        }

        response.sendRedirect(request.getContextPath() + "/Employees");
    }
}
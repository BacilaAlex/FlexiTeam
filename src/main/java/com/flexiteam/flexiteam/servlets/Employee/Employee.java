package com.flexiteam.flexiteam.servlets.Employee;

import com.flexiteam.flexiteam.dtos.Employee.EmployeeDto;
import com.flexiteam.flexiteam.ejb.Interface.IEmployeeBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Employee", value = "/Employee")
public class Employee extends HttpServlet {
    @Inject
    IEmployeeBean _employeeBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EmployeeDto> employees = _employeeBean.findAllEmployees();
        request.setAttribute("employees",employees);
        request.getRequestDispatcher("/WEB-INF/pages/employee/employee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] employeeIdsString = request.getParameterValues("employee_ids");

        if (employeeIdsString != null) {
            List<Long> employeeIds = new ArrayList<>();
            for (String employeeId : employeeIdsString) {
                employeeIds.add(Long.parseLong(employeeId));
            }
            _employeeBean.deleteEmployeesById(employeeIds);
        }

        response.sendRedirect(request.getContextPath() + "/Employees");
    }
}
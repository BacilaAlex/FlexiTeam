package com.flexiteam.flexiteam.servlets.Employee;

import com.flexiteam.flexiteam.dtos.Employee.EmployeeDto;
import com.flexiteam.flexiteam.ejb.EmployeeBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(name = "SalarySheet", value = "/SalarySheet")
public class SalarySheet extends HttpServlet {
    @Inject
    EmployeeBean employeeBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long employeeId = Long.parseLong(request.getParameter("id"));
        EmployeeDto employee = employeeBean.findEmployeeById(employeeId);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = formatter.format(employee.getDateOfBirth());
        request.setAttribute("employee", employee);
        request.setAttribute("dob", formattedDate);
        request.getRequestDispatcher("/salarySheet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

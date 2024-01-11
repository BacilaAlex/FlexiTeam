package com.flexiteam.flexiteam.servlets;

import com.flexiteam.flexiteam.commons.SalaryClass;
import com.flexiteam.flexiteam.commons.TaxClass;
import com.flexiteam.flexiteam.commons.WorkingTime;
import com.flexiteam.flexiteam.dtos.CreateEmployeeDto;
import com.flexiteam.flexiteam.dtos.EmployeeDto;
import com.flexiteam.flexiteam.ejb.EmployeeBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EditEmployee", value = "/EditEmployee")
public class EditEmployee extends HttpServlet {

    @Inject
    EmployeeBean employeeBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long employeeId = Long.parseLong(request.getParameter("id"));
        EmployeeDto employee = employeeBean.findEmployeeById(employeeId);
        request.setAttribute("employee", employee);

        request.getRequestDispatcher("/editEmployee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long employeeId = Long.parseLong(request.getParameter("employee_id"));
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String address = request.getParameter("address");
            SalaryClass salaryClass = SalaryClass.valueOf(request.getParameter("salary_class"));
            String monthlySalary = request.getParameter("monthly_salary");
            String bonus = request.getParameter("bonus");
            TaxClass taxClass = TaxClass.valueOf(request.getParameter("tax_class"));
            String religion = request.getParameter("religion");
            WorkingTime workingTime = WorkingTime.valueOf(request.getParameter("working_time"));
            String bankAccount = request.getParameter("bank_account");

            employeeBean.updateEmployee(employeeId, firstName, lastName, address, salaryClass, monthlySalary, bonus, taxClass, religion, workingTime, bankAccount);
            response.sendRedirect(request.getContextPath() + "/Employees");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

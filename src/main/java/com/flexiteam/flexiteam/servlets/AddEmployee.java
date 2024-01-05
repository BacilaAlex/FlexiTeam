package com.flexiteam.flexiteam.servlets;

import com.flexiteam.flexiteam.commons.SalaryClass;
import com.flexiteam.flexiteam.commons.TaxClass;
import com.flexiteam.flexiteam.commons.WorkingTime;
import com.flexiteam.flexiteam.dtos.CreateEmployeeDto;
import com.flexiteam.flexiteam.ejb.EmployeeBean;
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

@WebServlet(name = "AddEmployee", value = "/AddEmployee")
public class AddEmployee extends HttpServlet {

    @Inject
    EmployeeBean employeeBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date dateOfBirth = df.parse(request.getParameter("dateOfBirth"));
            String address = request.getParameter("address");
            SalaryClass salaryClass = SalaryClass.valueOf(request.getParameter("salaryClass"));
            String monthlySalary = request.getParameter("monthlySalary");
            String bonus = request.getParameter("bonus");
            TaxClass taxClass = TaxClass.valueOf(request.getParameter("taxClass"));
            String religion = request.getParameter("religion");
            WorkingTime workingTime = WorkingTime.valueOf(request.getParameter("workingTime"));
            String bankAccount = request.getParameter("bankAccount");

            employeeBean.createEmployee(
                    new CreateEmployeeDto(firstName, lastName, gender, dateOfBirth, address, salaryClass, monthlySalary, bonus, taxClass, religion, workingTime, bankAccount)
            );
            response.sendRedirect(request.getContextPath() + "/Employees");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package com.flexiteam.flexiteam.servlets.Employee;

import com.flexiteam.flexiteam.commons.SalaryClass;
import com.flexiteam.flexiteam.commons.TaxClass;
import com.flexiteam.flexiteam.commons.WorkingTime;
import com.flexiteam.flexiteam.dtos.Employee.CreateEmployeeDto;
import com.flexiteam.flexiteam.ejb.EmployeeBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_EMPLOYEES"}))
@WebServlet(name = "AddEmployee", value = "/AddEmployee")
public class AddEmployee extends HttpServlet {

    @Inject
    EmployeeBean employeeBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("salaryClasses", SalaryClass.values());
        request.setAttribute("taxClasses", TaxClass.values());
        request.setAttribute("workingTimes", WorkingTime.values());
        request.getRequestDispatcher("/addEmployee.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String gender = request.getParameter("gender");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date dateOfBirth = df.parse(request.getParameter("date_of_birth"));
            String address = request.getParameter("address");
            SalaryClass salaryClass = SalaryClass.valueOf(request.getParameter("salary_class"));
            String monthlySalary = request.getParameter("monthly_salary");
            String bonus = request.getParameter("bonus");
            TaxClass taxClass = TaxClass.valueOf(request.getParameter("tax_class"));
            String religion = request.getParameter("religion");
            WorkingTime workingTime = WorkingTime.valueOf(request.getParameter("working_time"));
            String bankAccount = request.getParameter("bank_account");

            employeeBean.createEmployee(
                    new CreateEmployeeDto(firstName, lastName, gender, dateOfBirth, address, salaryClass, monthlySalary, bonus, taxClass, religion, workingTime, bankAccount)
            );

            response.sendRedirect(request.getContextPath() + "/Employees");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
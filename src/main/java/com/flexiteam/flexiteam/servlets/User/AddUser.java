package com.flexiteam.flexiteam.servlets.User;

import com.flexiteam.flexiteam.commons.SalaryClass;
import com.flexiteam.flexiteam.commons.TaxClass;
import com.flexiteam.flexiteam.commons.WorkingTime;
import com.flexiteam.flexiteam.dtos.Employee.CreateEmployeeDto;
import com.flexiteam.flexiteam.dtos.Employee.EmployeeDto;
import com.flexiteam.flexiteam.dtos.User.CreateUserDto;
import com.flexiteam.flexiteam.ejb.EmployeeBean;
import com.flexiteam.flexiteam.ejb.PasswordBean;
import com.flexiteam.flexiteam.ejb.UserBean;
import com.flexiteam.flexiteam.entities.Employee;
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

@WebServlet(name = "AddUser", value = "/AddUser")
public class AddUser extends HttpServlet {

    @Inject
    UserBean userBean;
    @Inject
    EmployeeBean employeeBean;
    @Inject
    PasswordBean passwordBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EmployeeDto> employees = employeeBean.findAllEmployeesWithoutUser();
        request.setAttribute("employees", employees);

        request.getRequestDispatcher("/addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = passwordBean.convertToSha256(request.getParameter("password"));
            Long employeeId = Long.parseLong(request.getParameter("employee_id"));

            userBean.createUser(
                    new CreateUserDto(username, email, password, employeeId)
            );
            response.sendRedirect(request.getContextPath() + "/Users");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

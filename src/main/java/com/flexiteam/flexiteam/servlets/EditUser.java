package com.flexiteam.flexiteam.servlets;

import com.flexiteam.flexiteam.dtos.EmployeeDto;
import com.flexiteam.flexiteam.dtos.UserDto;
import com.flexiteam.flexiteam.ejb.EmployeeBean;
import com.flexiteam.flexiteam.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditUser", value = "/EditUser")
public class EditUser extends HttpServlet {

    @Inject
    UsersBean usersBean;

    @Inject
    EmployeeBean employeeBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("id"));
        UserDto user = usersBean.findUserById(userId);
        request.setAttribute("user", user);

        List<EmployeeDto> employees = employeeBean.findAllEmployees();
        request.setAttribute("employees", employees);

        request.getRequestDispatcher("/editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Long employeeId = Long.parseLong(request.getParameter("employee_id"));
            Long userId = Long.parseLong(request.getParameter("user_id"));

            usersBean.updateUser(userId, username, email, password, employeeId);
            response.sendRedirect(request.getContextPath() + "/Users");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

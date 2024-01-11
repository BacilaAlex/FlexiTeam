package com.flexiteam.flexiteam.servlets.User;

import com.flexiteam.flexiteam.dtos.User.UserDto;
import com.flexiteam.flexiteam.ejb.UsersBean;
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
@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {
    @Inject
    UsersBean usersBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDto> users = usersBean.findAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] userIdsString = request.getParameterValues("user_ids");

        if (userIdsString != null) {
            List<Long> userIds = new ArrayList<>();
            for (String userId : userIdsString) {
                userIds.add(Long.parseLong(userId));
            }
            usersBean.deleteUsersById(userIds);
        }

        response.sendRedirect(request.getContextPath() + "/Users");
    }
}
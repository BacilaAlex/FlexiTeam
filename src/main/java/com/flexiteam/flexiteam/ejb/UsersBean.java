package com.flexiteam.flexiteam.ejb;

import com.flexiteam.flexiteam.dtos.CreateEmployeeDto;
import com.flexiteam.flexiteam.dtos.UserDto;
import com.flexiteam.flexiteam.ejb.Interface.IEmployeeBean;
import com.flexiteam.flexiteam.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UsersBean {
    private static final Logger LOG = Logger.getLogger(UsersBean.class.getName());

    @Inject
    IEmployeeBean _employeeBean;
    @Inject
    PasswordBean passwordBean;

    @PersistenceContext
    EntityManager entityManager;

    public List<UserDto> findAllUsers() {
        LOG.info("findAllUsers");
        try {
            TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<UserDto> copyUsersToDto(List<User> users) {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user :
                users) {
            usersDto.add(new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPassword()));
        }
        return usersDto;
    }

    public User createUser(String username, String email, String password, CreateEmployeeDto createEmployee) {
        LOG.info("createUser");
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordBean.convertToSha256(password));
        newUser.setEmployee(_employeeBean.createEmployee(createEmployee));
        entityManager.persist(newUser);
        return newUser;
    }
}

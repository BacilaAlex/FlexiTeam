package com.flexiteam.flexiteam.ejb;

import com.flexiteam.flexiteam.dtos.CreateEmployeeDto;
import com.flexiteam.flexiteam.dtos.EmployeeDto;
import com.flexiteam.flexiteam.dtos.UserDto;
import com.flexiteam.flexiteam.entities.Employee;
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
    EmployeeBean employeeBean;
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
        newUser.setEmployee(employeeBean.createEmployee(createEmployee));
        entityManager.persist(newUser);
        return newUser;
    }

    public UserDto findUserById(Long id) {
        for(UserDto user : findAllUsers()){
            if(user.getId().equals(id))
                return user;
        }
        return null;
    }

    public void updateUser(Long userId, String username, String email, String password, Long employeeId) {
        User user = entityManager.find(User.class, userId);

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        Employee employee = entityManager.find(Employee.class, employeeId);
        user.setEmployee(employee);
    }

    public void deleteUsersById(List<Long> userIds) {
        for (Long userId : userIds) {
            User user = entityManager.find(User.class, userId);
            entityManager.remove(user);
        }
    }
}

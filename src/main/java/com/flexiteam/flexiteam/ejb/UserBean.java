package com.flexiteam.flexiteam.ejb;

import com.flexiteam.flexiteam.dtos.Employee.CreateEmployeeDto;
import com.flexiteam.flexiteam.dtos.User.CreateUserDto;
import com.flexiteam.flexiteam.dtos.User.UserDto;
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
public class UserBean {
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

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
            usersDto.add(new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(),user.getEmployee().getId()));
        }
        return usersDto;
    }

    public void createUser(CreateUserDto createUser) {
        LOG.info("createEmployee");

        User newUser = createUserFromDto(createUser);

        entityManager.persist(newUser);
    }

    private User createUserFromDto(CreateUserDto createUser) {
        User newUser = new User();

        newUser.setUsername(createUser.getUsername());
        newUser.setEmail(createUser.getEmail());
        newUser.setPassword(createUser.getPassword());
        newUser.setEmployee(entityManager.find(Employee.class, createUser.getEmployeeId()));

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

package com.flexiteam.flexiteam.ejb;

import com.flexiteam.flexiteam.dtos.CreateEmployeeDto;
import com.flexiteam.flexiteam.dtos.EmployeeDto;
import com.flexiteam.flexiteam.ejb.Interface.IEmployeeBean;
import com.flexiteam.flexiteam.entities.Employee;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class EmployeeBean implements IEmployeeBean {
    private static final Logger LOG = Logger.getLogger(EmployeeBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<EmployeeDto> findAllEmployees() {
        LOG.info("findAllEmployees");
        try {
            TypedQuery<Employee> typedQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
            List<Employee> employees = typedQuery.getResultList();
            return copyEmployeesToDto(employees);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<EmployeeDto> copyEmployeesToDto(List<Employee> employees) {
        List<EmployeeDto> employeeDto = new ArrayList<>();

        for (Employee employee : employees) {
            employeeDto.add(new EmployeeDto(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getGender(),
                    employee.getDateOfBirth(),
                    employee.getAddress(),
                    employee.getSalaryClass(),
                    employee.getMonthlySalary(),
                    employee.getBonus(),
                    employee.getTaxClass(),
                    employee.getReligion(),
                    employee.getWorkingTime(),
                    employee.getBankAccount()));
        }

        return employeeDto;
    }

    public Employee createEmployee(CreateEmployeeDto createEmployee) {
        LOG.info("createEmployee");
        Employee newEmployee = new Employee();

        newEmployee.setFirstName(createEmployee.getFirstName());
        newEmployee.setLastName(createEmployee.getLastName());
        newEmployee.setGender(createEmployee.getGender());
        newEmployee.setDateOfBirth(createEmployee.getDateOfBirth());
        newEmployee.setAddress(createEmployee.getAddress());
        newEmployee.setSalaryClass(createEmployee.getSalaryClass());
        newEmployee.setMonthlySalary(createEmployee.getMonthlySalary());
        newEmployee.setBonus(createEmployee.getBonus());
        newEmployee.setTaxClass(createEmployee.getTaxClass());
        newEmployee.setReligion(createEmployee.getReligion());
        newEmployee.setWorkingTime(createEmployee.getWorkingTime());
        newEmployee.setBankAccount(createEmployee.getBankAccount());

        entityManager.persist(newEmployee);
        return newEmployee;
    }
}

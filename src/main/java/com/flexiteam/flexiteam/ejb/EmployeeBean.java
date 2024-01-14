package com.flexiteam.flexiteam.ejb;

import com.flexiteam.flexiteam.commons.SalaryClass;
import com.flexiteam.flexiteam.commons.TaxClass;
import com.flexiteam.flexiteam.commons.WorkingTime;
import com.flexiteam.flexiteam.dtos.Employee.CreateEmployeeDto;
import com.flexiteam.flexiteam.dtos.Employee.EmployeeDto;
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
public class EmployeeBean{
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

    public List<EmployeeDto> findAllEmployeesWithoutUser() {
        LOG.info("findAllEmployeesWithoutUser");
        try {
            TypedQuery<Employee> typedQuery = entityManager.createQuery("SELECT e FROM Employee e WHERE NOT EXISTS (SELECT u FROM User u WHERE u.employee.id = e.id)", Employee.class);
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

    public void createEmployee(CreateEmployeeDto createEmployee) {
        LOG.info("createEmployee");

        Employee newEmployee = createEmployeeFromDto(createEmployee);

        entityManager.persist(newEmployee);
    }

    private Employee createEmployeeFromDto(CreateEmployeeDto createEmployee) {
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

        return newEmployee;
    }

    public EmployeeDto findEmployeeById(Long id) {
        for(EmployeeDto employee : findAllEmployees()){
            if(employee.getId().equals(id))
                return employee;
        }
        return null;
    }

    public void updateEmployee(Long employeeId, String firstName, String lastName, String address, SalaryClass salaryClass, String monthlySalary,
                               String bonus, TaxClass taxClass, String religion, WorkingTime workingTime, String bankAccount) {
        Employee employee = entityManager.find(Employee.class, employeeId);

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAddress(address);
        employee.setSalaryClass(salaryClass);
        employee.setMonthlySalary(monthlySalary);
        employee.setBonus(bonus);
        employee.setTaxClass(taxClass);
        employee.setReligion(religion);
        employee.setWorkingTime(workingTime);
        employee.setBankAccount(bankAccount);
    }

    public void deleteEmployeesById(List<Long> employeeIds) {
        for (Long employeeId : employeeIds) {
            Employee employee = entityManager.find(Employee.class, employeeId);
            entityManager.remove(employee);
        }
    }
}

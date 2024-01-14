package com.flexiteam.flexiteam.ejb.Interface;

import com.flexiteam.flexiteam.commons.SalaryClass;
import com.flexiteam.flexiteam.commons.TaxClass;
import com.flexiteam.flexiteam.commons.WorkingTime;
import com.flexiteam.flexiteam.dtos.Employee.CreateEmployeeDto;
import com.flexiteam.flexiteam.dtos.Employee.EmployeeDto;
import com.flexiteam.flexiteam.entities.Employee;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IEmployeeBean {
    Employee createEmployee(CreateEmployeeDto createEmployee);

    List<EmployeeDto> findAllEmployees();

    void deleteEmployeesById(List<Long> employeeIds);

    void updateEmployee(Long employeeId, String firstName, String lastName, String address, SalaryClass salaryClass, String monthlySalary,
                        String bonus, TaxClass taxClass, String religion, WorkingTime workingTime, String bankAccount);

    EmployeeDto findEmployeeById(Long id);
}

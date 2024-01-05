package com.flexiteam.flexiteam.ejb.Interface;

import com.flexiteam.flexiteam.dtos.CreateEmployeeDto;
import com.flexiteam.flexiteam.entities.Employee;

public interface IEmployeeBean {
    Employee createEmployee(CreateEmployeeDto createEmployee);
}

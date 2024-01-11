package com.flexiteam.flexiteam.dtos.Employee;

import com.flexiteam.flexiteam.commons.SalaryClass;
import com.flexiteam.flexiteam.commons.TaxClass;
import com.flexiteam.flexiteam.commons.WorkingTime;

import java.util.Date;

public class CreateEmployeeDto {
    String firstName;
    String lastName;
    String gender;
    Date dateOfBirth;
    String address;
    SalaryClass salaryClass;
    String monthlySalary;
    String bonus;
    TaxClass taxClass;
    String religion;
    WorkingTime workingTime;
    String bankAccount;

    public CreateEmployeeDto(String firstName, String lastName, String gender, Date dateOfBirth, String address, SalaryClass salaryClass, String monthlySalary, String bonus, TaxClass taxClass, String religion, WorkingTime workingTime, String bankAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.salaryClass = salaryClass;
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
        this.taxClass = taxClass;
        this.religion = religion;
        this.workingTime = workingTime;
        this.bankAccount = bankAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public SalaryClass getSalaryClass() {
        return salaryClass;
    }

    public String getMonthlySalary() {
        return monthlySalary;
    }

    public String getBonus() {
        return bonus;
    }

    public TaxClass getTaxClass() {
        return taxClass;
    }

    public String getReligion() {
        return religion;
    }

    public WorkingTime getWorkingTime() {
        return workingTime;
    }

    public String getBankAccount() {
        return bankAccount;
    }
}

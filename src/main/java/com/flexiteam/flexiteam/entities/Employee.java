package com.flexiteam.flexiteam.entities;

import com.flexiteam.flexiteam.commons.SalaryClass;
import com.flexiteam.flexiteam.commons.TaxClass;
import com.flexiteam.flexiteam.commons.WorkingTime;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String firstName;
    @Basic
    private String lastName;
    @Basic
    private String gender;
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dateOfBirth;
    @Basic
    private String address;
    @Basic
    private SalaryClass salaryClass;
    @Basic
    private String monthlySalary;
    @Basic
    private String bonus;
    @Basic
    private TaxClass taxClass;
    @Basic
    private String religion;
    @Basic
    private WorkingTime workingTime;
    @Basic
    private String bankAccount;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
  
    public SalaryClass getSalaryClass() {
        return salaryClass;
    }

    public void setSalaryClass(SalaryClass salaryClass) {
        this.salaryClass = salaryClass;
    }

    public String getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(String monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public TaxClass getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(TaxClass taxClass) {
        this.taxClass = taxClass;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public WorkingTime getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(WorkingTime workingTime) {
        this.workingTime = workingTime;
    }
  
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
}

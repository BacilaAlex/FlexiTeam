package com.flexiteam.flexiteam.ejb;

import com.flexiteam.flexiteam.commons.SalaryClass;
import com.flexiteam.flexiteam.commons.TaxClass;
import jakarta.ejb.Stateless;

@Stateless
public class SalaryBean {
    public Double calculateSalary(TaxClass taxClass, Integer workingTime, String gross) {
        Double grossNumber = Double.parseDouble(gross);
        Double salary = (grossNumber - grossNumber * convertTaxClass(taxClass)) * workingTime / 40;

        return salary;
    }

    public Double calculateYearlySalary(TaxClass taxClass, Integer workingTime, String gross,
                                        SalaryClass salaryClass, Double bonus) {
        Double salaryMonthly = calculateSalary(taxClass, workingTime, gross);
        Double salaryYearly = salaryMonthly * 12 + convertSalaryClassToBonuses(salaryClass, salaryMonthly, bonus);

        return salaryYearly;
    }

    private Double convertTaxClass(TaxClass taxClass) {
        switch (taxClass) {
            case Professors: return 0.30;
            case Lecturers: return 0.20;
            case AssociateProfessors: return 0.25;
            default: return 1.0;
        }
    }

    private Double convertSalaryClassToBonuses(SalaryClass salaryClass, Double salary, Double bonus) {
        switch (salaryClass) {
            case Lecturers: return 2.0 * salary;
            case AssociateProfessors: return bonus;
            case Executive: return bonus;
            default: return 0.0;
        }
    }
}

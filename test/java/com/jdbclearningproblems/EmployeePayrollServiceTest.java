package com.jdbclearningproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

    public class EmployeePayrollServiceTest {

        @Test
        public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
            EmployeePayrollService employeePayrollService = new EmployeePayrollService();
            List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
            Assertions.assertEquals(4, employeePayrollData.size());
        }

        @Test
        public void givenNewSalaryForEmployee_WhenUpdated_ShouldSyncWithDB(){
            EmployeePayrollService employeePayrollService = new EmployeePayrollService();
            List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
            employeePayrollService.updateEmployeeSalary("Terisa",400000.0);
            boolean result = employeePayrollService.checkEmployeePayrollSyncWithDB("Terisa");
            Assertions.assertTrue(result);
        }
    }

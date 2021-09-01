package com.jdbclearningproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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

        @Test
        public void givenDateRange_WhenRetrieved_ShouldMatchEmployeeCount() {
            EmployeePayrollService employeePayrollService = new EmployeePayrollService();
            employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
            LocalDate startDate = LocalDate.of(2021,03,8);
            LocalDate endDate = LocalDate.now();
            List<EmployeePayrollData> employeePayrollData =
                    employeePayrollService.readEmployeePayrollForDateChange(EmployeePayrollService.IOService.DB_IO,startDate,endDate);
            Assertions.assertEquals(2,employeePayrollData.size());
        }
    }

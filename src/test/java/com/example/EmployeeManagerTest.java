package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {

    EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    BankService bankService = mock(BankService.class);
    EmployeeManager employeeManager = new EmployeeManager(employeeRepository,bankService); //Mock

    @Test
    void testIfPayEmployeesMethodReturnsTheActualValueWhenAddingEmployeeIntoAList(){

        List<Employee> employeeListTest= new ArrayList<>();
        Employee employee1 = new Employee("1",10000.0 );
        employeeListTest.add(employee1);
        when(employeeRepository.findAll()).thenReturn(employeeListTest); //Mock
        var result = employeeManager.payEmployees();
        assertThat(result).isEqualTo(1);
        verify(bankService).pay(Mockito.eq("1"),Mockito.eq(10000.0)); //Spy
    }

    @Test
    @DisplayName("Testing if RuntimeException gets executed")
    void testIfRuntimeExceptionInPayEmployeesMethodGetsExecuted(){

        List<Employee> employeeListTest= new ArrayList<>();
        when(employeeRepository.findAll()).thenReturn(employeeListTest);
        doThrow(new RuntimeException()).when(bankService).pay(anyString(),anyDouble());

        var result = employeeManager.payEmployees();
        assertThat(result).isEqualTo(0);

    }


    @Test
    @DisplayName("Testing if payEmployees() returns 1 using implementations")
    void testIfPayEmployeesMethodReturns1WhenAddingAEmployeeIntoAListWithoutMock(){
        TestEmployeeRepository testEmployeeRepository = new TestEmployeeRepository();
        TestBankService testBankService = new TestBankService();
        EmployeeManager employeeManager1 = new EmployeeManager(testEmployeeRepository,testBankService);

        testEmployeeRepository.findAll();
        var result = employeeManager1.payEmployees();
        assertThat(result).isEqualTo(1);

    }



}
package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeRepositoryImplTest {
   List<Employee> employeeList = new ArrayList<>(Arrays.asList(
           new Employee("1", 50000.0),
           new Employee("2", 40000.0),
           new Employee("3", 70000.0)));

    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(employeeList);

    @Test
    @DisplayName("Testing if findAll method executes ")
    void testIfFindAllMethodExecutes(){
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(List.of());

       var result = employeeRepository.findAll();
        assertThat(result).isNullOrEmpty();


    }

    @Test
    @DisplayName("Testing if findAll method returns a saved employee")
    void testIfFindAllMethodReturnsASavedEmployee(){


        var result = employeeRepository.findAll();
        assertThat(result).isEqualTo(employeeList);

    }

    @Test
    @DisplayName("Testing if findall method returns the actual index size of the list")
    void testIfFindAllMethodReturnsTheActualIndexSizeOfTheList(){

        var result = employeeRepository.findAll().size();
        assertThat(result).isEqualTo(3);


    }

    @Test
    @DisplayName("Testing if save method gets executed")
    void testIfSaveMethodGetsExecuted(){
        Employee employee = new Employee("4",30000.0);

        employeeRepository.save(employee);
        var result =employeeRepository.findAll().contains(employee);

        assertTrue(result);

    }

    @Test
    @DisplayName("Testing if employee gets replaced when adding one with same id")
    void testIfEmployeeGetsReplacedWhenAddingOneWithSameId(){

        Employee employee = new Employee("1",400.0);
        employeeRepository.save(employee);
        var result = employeeRepository.findAll().get(0).getSalary();
        assertThat(result).isEqualTo(400.0);

    }


}
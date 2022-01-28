package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements  EmployeeRepository{

    List<Employee> employeeList;


    public EmployeeRepositoryImpl(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public List<Employee> findAll() {

        return employeeList;
    }

    @Override
    public Employee save(Employee e) {
        Employee temp = null;
        for (Employee employee : employeeList) {
            if(employee.getId().equals(e.getId())){
                temp = employee;

            }
        }
        if(employeeList.contains(temp)){
            employeeList.set(employeeList.indexOf(temp),e);
        }else{
            employeeList.add(e);
        }

        return e;
    }
}

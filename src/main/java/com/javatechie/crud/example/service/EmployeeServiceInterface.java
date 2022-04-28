package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Employee;

import javax.validation.Valid;
import java.util.List;

public interface EmployeeServiceInterface
{
    Employee addEmployee( Employee employee);

    List<Employee> getEmployee(int pageNo, int pageSize, String sortBy);

    String deleteEmployee(int id);

    Employee updateEmployee(Employee employee);

}

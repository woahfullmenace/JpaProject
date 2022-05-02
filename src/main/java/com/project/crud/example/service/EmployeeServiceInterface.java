package com.project.crud.example.service;


import com.project.crud.example.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface
{
    Employee addEmployee( Employee employee);

    List<Employee> getEmployee(int pageNo, int pageSize, String sortBy);

    String deleteEmployee(int id);

    Employee updateEmployee(Employee employee);

}

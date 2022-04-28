package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Employee;

import com.javatechie.crud.example.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    /*------------------------------------------------------------------------------------------------------------------------------*/
    public List<Employee> saveEmployee(List<Employee> Employees)
    {
        return repository.saveAll(Employees);
    }
    /*------------------------------------------------------------------------------------------------------------------------------*/
    public List<Employee> getEmployees(String filter)
    {
        switch(filter)
        {
            case "id":
                return repository.findAll(Sort.by(Sort.Direction.ASC,"id"));
            case "age":
                return repository.findAll(Sort.by(Sort.Direction.ASC,"age"));
            case "name":
                return repository.findAll(Sort.by(Sort.Direction.ASC,"name"));
            case "dept":
                return repository.findAll(Sort.by(Sort.Direction.ASC,"department"));
            default:
                return repository.findAll();
        }

    }
    /*------------------------------------------------------------------------------------------------------------------------------*/


    public String deleteEmployee(int id)
    {
        repository.deleteById(id);
        return "Employee removed !! " + id;
    }
    /*------------------------------------------------------------------------------------------------------------------------------*/

    public Employee updateEmployee(Employee Employee)
    {
        Employee existingEmployee = repository.findById(Employee.getId()).orElse(null);
        existingEmployee.setName(Employee.getName());
        existingEmployee.setAge(Employee.getAge());
        existingEmployee.setDepartment(Employee.getDepartment());
        return repository.save(existingEmployee);
    }


}

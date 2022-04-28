package com.javatechie.crud.example.service;


import com.javatechie.crud.example.entity.Employee;

import com.javatechie.crud.example.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        public List<Employee> getEmployee(int pageNo, int pageSize, String sortBy)
        {
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
            Page<Employee> pagedResult = repository.findAll(paging);

            if(pagedResult.hasContent())
            {
                return pagedResult.getContent();
            } else
            {
                return new ArrayList<Employee>();
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

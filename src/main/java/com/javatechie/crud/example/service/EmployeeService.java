package com.javatechie.crud.example.service;


import com.javatechie.crud.example.entity.Employee;

import com.javatechie.crud.example.handler.UserServiceException;
import com.javatechie.crud.example.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee( @Valid Employee employee)
    {
        if(repository.existsById(employee.getId()))
        {
            throw new UserServiceException("Employee with empID  ["+ employee.getId()+"]  already exists" );
        }
        else
        {
            return repository.save(employee);
        }
    }

        public List<Employee> getEmployee(int pageNo, int pageSize, String sortBy)
        {
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
            Page<Employee> pagedResult = repository.findAll(paging);

            if(pagedResult.hasContent())
            {
                return pagedResult.getContent();
            }
            else
            {
                return new ArrayList<Employee>();
            }
        }




    public String deleteEmployee(int id)
    {
        if(repository.existsById(id))
        {
            repository.deleteById(id);
            return "Employee with employee Id [" + id + "] removed";
        }
        else
            throw new UserServiceException("Employee with employee ID  [" +id+ "] does not exist");
    }


    public Employee updateEmployee(Employee employee)
    {
        if(repository.existsById(employee.getId()))
        {
            Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
            existingEmployee.setName(employee.getName());
            existingEmployee.setAge(employee.getAge());
            existingEmployee.setDepartment(employee.getDepartment());
            return repository.save(existingEmployee);
        }
        else
        {
            throw new UserServiceException("Employee with employee ID  [" + employee.getId() + "] does not exist");
        }
    }


}

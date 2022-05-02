package com.project.crud.example.service;

import com.project.crud.example.entity.Department;
import com.project.crud.example.handler.UserServiceException;
import com.project.crud.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImplementation implements DepartmentServiceInterface
{
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department addDepartment(Department department)
    {
        if(departmentRepository.existsById(department.getDid()))
        {
            throw new UserServiceException("Department with deptID  ["+ department.getDid()+"]  already exists" );
        }
        else
        {
            return departmentRepository.save(department);
        }

    }
}

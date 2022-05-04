package com.project.crud.example.service;

import com.project.crud.example.entity.Department;
import com.project.crud.example.handler.UserServiceException;
import com.project.crud.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Department> getDepartment(int pageNo, int pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Department> pagedResult = departmentRepository.findAll(paging);

        if(pagedResult.hasContent())
        {
            return pagedResult.getContent();
        }
        else
        {
            return new ArrayList<Department>();
        }
    }

    }




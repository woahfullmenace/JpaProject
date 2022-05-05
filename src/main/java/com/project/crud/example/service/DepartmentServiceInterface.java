package com.project.crud.example.service;

import com.project.crud.example.entity.Department;

import java.util.List;

public interface DepartmentServiceInterface
{
    Department addDepartment(Department department);

    List<Department> getDepartment(int pageNo, int pageSize, String sortBy);
}

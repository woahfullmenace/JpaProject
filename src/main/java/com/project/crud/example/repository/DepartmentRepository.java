package com.project.crud.example.repository;

import com.project.crud.example.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface DepartmentRepository extends JpaRepository<Department, Integer>
{

}

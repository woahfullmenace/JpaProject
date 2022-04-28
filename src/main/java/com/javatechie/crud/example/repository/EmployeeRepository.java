package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Integer>, PagingAndSortingRepository<Employee,Integer>
{


}


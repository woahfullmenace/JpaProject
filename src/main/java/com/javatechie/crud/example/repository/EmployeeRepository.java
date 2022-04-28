package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByName(String name);
}


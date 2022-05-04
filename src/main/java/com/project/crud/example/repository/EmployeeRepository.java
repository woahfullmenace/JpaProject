package com.project.crud.example.repository;


import com.project.crud.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;




public interface EmployeeRepository extends JpaRepository<Employee,Integer>, PagingAndSortingRepository<Employee,Integer>
{


}


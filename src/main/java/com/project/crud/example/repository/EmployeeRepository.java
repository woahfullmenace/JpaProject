package com.project.crud.example.repository;


import com.project.crud.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface EmployeeRepository extends JpaRepository<Employee,Integer>, PagingAndSortingRepository<Employee,Integer>
{
    @Query(value="SELECT department FROM employee WHERE eid=?#{#Id}",nativeQuery = true)
    String findDepartmentName(@Param("Id") int empId);
}


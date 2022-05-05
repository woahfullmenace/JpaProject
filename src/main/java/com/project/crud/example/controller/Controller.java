package com.project.crud.example.controller;


import com.project.crud.example.entity.Department;
import com.project.crud.example.entity.Employee;
import com.project.crud.example.service.DepartmentServiceImplementation;

import com.project.crud.example.service.EmployeeServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller
{


    @Autowired
    private EmployeeServiceImplementation employeeServiceImplementation;
    @Autowired
    private DepartmentServiceImplementation departmentServiceImplementation;

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@Valid  @RequestBody Employee employee)
    {
        Employee emp= employeeServiceImplementation.addEmployee(employee);
        return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<Department> addDepartment(@Valid  @RequestBody Department department)
    {
        Department dept= departmentServiceImplementation.addDepartment(department);
        return new ResponseEntity<Department>(dept,HttpStatus.CREATED);

    }




    @GetMapping("/getEmployee")
    public ResponseEntity<List<Employee>> getEmployee (
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "eid") String sortBy)
    {
        List<Employee> list = employeeServiceImplementation.getEmployee(pageNo, pageSize, sortBy);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getDepartment")
    public ResponseEntity<List<Department>> getDepartment (
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "did") String sortBy)
    {
        List<Department> DeptList = (List<Department>) departmentServiceImplementation.getDepartment(pageNo, pageSize, sortBy);

        return new ResponseEntity<>(DeptList, HttpStatus.OK);
    }
    @GetMapping("/getDepartmentName")
    public ResponseEntity<String> getDepartmentName(@RequestParam(required = true) int empId)
    {
        return new ResponseEntity<String>(employeeServiceImplementation.getDepartmentName(empId),HttpStatus.OK);
    }




    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee( @Valid  @RequestBody Employee employee)
    {
        Employee emp= employeeServiceImplementation.updateEmployee(employee);
        return  new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id)
    {
        String message = employeeServiceImplementation.deleteEmployee(id);
        return new ResponseEntity<String>(message,HttpStatus.OK);
    }
}

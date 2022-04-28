package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Employee;
import com.javatechie.crud.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee( @RequestBody Employee employee)
    {
        Employee emp= employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);

    }


    @GetMapping("/getEmployee")
    public ResponseEntity<List<Employee>> getEmployee (
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Employee> list = employeeService.getEmployee(pageNo, pageSize, sortBy);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
        Employee emp= employeeService.updateEmployee(employee);
        return  new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id)
    {
        String message = employeeService.deleteEmployee(id);
        return new ResponseEntity<String>(message,HttpStatus.OK);
    }
}

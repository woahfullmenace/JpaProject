package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.Response.APIResponse;
import com.javatechie.crud.example.entity.Employee;
import com.javatechie.crud.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    /*@PostMapping("/addEmployee")
    public APIResponse<List<Employee>> addEmployee(@RequestBody List<Employee> employee)
    {
        return service.saveEmployee(employee);
    }*/


    @GetMapping("/getEmployee")
    public ResponseEntity<List<Employee>> getEmployee(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Employee> list = service.getEmployee(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}

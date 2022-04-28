package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Employee;
import com.javatechie.crud.example.service.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImplementation employeeServiceImplementation;

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@Valid @ModelAttribute("employee") @RequestBody Employee employee)
    {
        Employee emp= employeeServiceImplementation.addEmployee(employee);
        return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);

    }


    @GetMapping("/getEmployee")
    public ResponseEntity<List<Employee>> getEmployee (
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Employee> list = employeeServiceImplementation.getEmployee(pageNo, pageSize, sortBy);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee( @Valid @ModelAttribute("employee") @RequestBody Employee employee)
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

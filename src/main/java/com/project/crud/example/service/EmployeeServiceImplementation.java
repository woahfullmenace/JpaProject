package com.project.crud.example.service;



import com.project.crud.example.entity.Department;
import com.project.crud.example.entity.Employee;
import com.project.crud.example.handler.UserServiceException;
import com.project.crud.example.repository.DepartmentRepository;
import com.project.crud.example.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeServiceInterface {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee addEmployee(@Valid Employee employee)
    {
        if(employeeRepository.existsById(employee.getEid()))
        {
            throw new UserServiceException("Employee with empID  ["+ employee.getEid()+"]  already exists" );
        }
        else
        {
            return employeeRepository.save(employee);
        }
    }

        public List<Employee> getEmployee(int pageNo, int pageSize, String sortBy)
        {
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
            Page<Employee> pagedResult = employeeRepository.findAll(paging);

            if(pagedResult.hasContent())
            {
                return pagedResult.getContent();
            }
            else
            {
                return new ArrayList<Employee>();
            }
        }




    public String deleteEmployee(int id)
    {
        if(employeeRepository.existsById(id))
        {
            employeeRepository.deleteById(id);
            return "Employee with employee Id [" + id + "] removed";
        }
        else
            throw new UserServiceException("Employee with employee ID  [" +id+ "] does not exist");
    }


    public Employee updateEmployee(Employee employee)
    {
        if(employeeRepository.existsById(employee.getEid()))
        {
            Employee existingEmployee = employeeRepository.findById(employee.getEid()).orElse(null);
            existingEmployee.setName(employee.getName());
            existingEmployee.setAge(employee.getAge());
            existingEmployee.setDepartment(employee.getDepartment());
            return employeeRepository.save(existingEmployee);
        }
        else
        {
            throw new UserServiceException("Employee with employee ID  [" + employee.getEid() + "] does not exist");
        }
    }

    @Override
    public String getDepartmentName(int empId)
    {
        String departmentName = employeeRepository.findDepartmentName(empId);
        return "Employee with empId ["+empId+"] belongs to the department ["+departmentName+"]";
    }


}

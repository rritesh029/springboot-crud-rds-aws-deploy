package com.example.employee_crud.controllers;

import com.example.employee_crud.entities.Employee;
import com.example.employee_crud.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    //Save lsit of employees
    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public List<Employee> save_Employees(@RequestBody List<Employee> employees)
    {
       return employeeRepository.saveAll(employees);
    }

    //Save one employee
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee save_Employee(@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees")
    //Get all employees
    public List<Employee> fetch_employees()
    {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    //Get one employee
    public ResponseEntity<Employee> fetch_employee(@PathVariable int id)
    {
        return employeeRepository.findById(id).map(e->ResponseEntity.ok(e))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/employee/{id}")
    //update employee
    public ResponseEntity<Employee>updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee)
    {
        if(null!=employeeRepository.findById(id))
        {
            updatedEmployee.setId(123);
            updatedEmployee.setName("Ritesh");
            updatedEmployee.setRole("Admin");
            return new ResponseEntity<>(employeeRepository.save(updatedEmployee),HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}

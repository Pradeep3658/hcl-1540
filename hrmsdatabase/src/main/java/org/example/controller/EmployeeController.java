package org.example.controller;

import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Welcome Page
    @GetMapping("/")
    public String hello() {
        return "Welcome to Employee Management System";
    }

    // 1. Add Employee
    @GetMapping("/addEmp")
    public String addnewEmployee() {
        return employeeService.createnewEmployee();
    }

    @PostMapping("/addEmp")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        if (employee.getName() == null || employee.getName().isBlank()
                || employee.getEmail() == null || employee.getEmail().isBlank()
                || employee.getDesignation() == null || employee.getDesignation().isBlank()
                || employee.getTechStack() == null || employee.getTechStack().isBlank()) {
            return ResponseEntity.badRequest().body("name, email, designation, and techStack are required");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee));
    }

    // 2. Find Employee By ID
    @GetMapping("/findbyid/{id}")
    public Employee getEmpById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    // 3. Delete Employee By ID
    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmployee(@PathVariable long id) {
        return employeeService.deleteEmployeeById(id);
    }

    // 4. Update Employee By ID
    @PutMapping("/updateEmp/{id}")
    public Employee updateEmployee(
            @PathVariable long id,
            @RequestBody Employee employee) {

        return employeeService.updateEmployeeById(id, employee);
    }
}
package org.example.service;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 1. Add Multiple Employees
    public String createnewEmployee() {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Aman", "aman@gmail.com", "HR", 200000));
        employees.add(new Employee("Rahul", "rahul@gmail.com", "IT", 150000));
        employees.add(new Employee("Priya", "priya@gmail.com", "Finance", 180000));
        employees.add(new Employee("Rohit", "rohit@gmail.com", "Marketing", 120000));
        employees.add(new Employee("Neha", "neha@gmail.com", "IT", 175000));
        employees.add(new Employee("Ankit", "ankit@gmail.com", "HR", 95000));
        employees.add(new Employee("Simran", "simran@gmail.com", "Sales", 110000));
        employees.add(new Employee("Vikas", "vikas@gmail.com", "Finance", 140000));
        employees.add(new Employee("Pooja", "pooja@gmail.com", "IT", 165000));
        employees.add(new Employee("Karan", "karan@gmail.com", "Marketing", 130000));

        employeeRepository.saveAll(employees);

        return "10 Employees added successfully";
    }

    // 2. Find Employee By ID
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // 3. Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // 4. Delete Employee By ID
    public String deleteEmployeeById(long id) {

        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        }

        return "Employee not found with ID: " + id;
    }

    // 5. Update Employee By ID
    public Employee updateEmployeeById(long id, Employee newEmployee) {

        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {

            employee.setName(newEmployee.getName());
            employee.setEmail(newEmployee.getEmail());
            employee.setDepartment(newEmployee.getDepartment());
            employee.setSalary(newEmployee.getSalary());

            return employeeRepository.save(employee);
        }

        return null;
    }
}
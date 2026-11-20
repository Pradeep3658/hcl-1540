
package org.abesproject.hclhrms.repository;

import org.abesproject.hclhrms.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepoImp implements EmployeeRepo {

    List<Employee> emplist = new ArrayList<>();

    @Override
    public String addEmp(Employee emp) {
        emplist.add(emp);
        return "Employee Added Successfully";
    }

    @Override
    public List<Employee> getEmp() {
        return emplist;
    }

    @Override
    public Employee getEmpbyId(long emp_id) {
        for (Employee emp : emplist) {
            if (emp.getEmp_id() == emp_id) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public String deletebyID(long emp_id) {
        boolean removed = emplist.removeIf(
                emp -> emp.getEmp_id() == emp_id
        );

        if (removed) {
            return "Employee Deleted Successfully";
        } else {
            return "Employee Not Found";
        }
    }

    @Override
    public String updatebyId(long emp_id, Employee updatedEmp) {
        for (int i = 0; i < emplist.size(); i++) {
            if (emplist.get(i).getEmp_id() == emp_id) {
                emplist.set(i, updatedEmp);
                return "Employee Updated Successfully";
            }
        }
        return "Employee Not Found";
    }

    @Override
    public String addEmpbulk(List<Employee> bulkEmp) {
        emplist.addAll(bulkEmp);
        return "All Employees Added Successfully";
    }
}

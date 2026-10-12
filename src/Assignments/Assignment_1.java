package Assignments;

import java.util.*;

public class Assignment_1 {

    private int employeeId;
    private String employeeName;
    private String employeeRole;

    private double basicSalary;
    private double houseAllowance;
    private double travelAllowance;
    private double specialAllowance;

    // Constructor
    public Assignment_1(int id, String name, String role,
                        double basic, double hra, double ta,
                        double allowance) {

        this.employeeId = id;
        this.employeeName = name;
        this.employeeRole = role;
        this.basicSalary = basic;
        this.houseAllowance = hra;
        this.travelAllowance = ta;
        this.specialAllowance = allowance;
    }

    public double calculateBonus() {

        double percentage = 0;

        switch (employeeRole.toLowerCase()) {

            case "manager": {
                percentage = 12;
                break;
            }

            case "admin": {
                percentage = 10;
                break;
            }

            case "engineer": {
                percentage = 12;
                break;
            }

            case "accountant": {
                percentage = 8;
                break;
            }

            default: {
                throw new IllegalArgumentException("Invalid role");
            }
        }

        return (basicSalary + houseAllowance) * percentage / 100;
    }

    // Display employee details
    public void displayDetails() {

        System.out.println("Emp_id: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Bonus: Rs. " + calculateBonus());
    }
}

// Main class
class Main {

    public static void main(String[] args) {

        List<Assignment_1> employeeList = new ArrayList<>();

        employeeList.add(new Assignment_1(100, "Rahul", "Engineer",
                50000, 10000, 5000, 2000));

        employeeList.add(new Assignment_1(101, "Aman", "Manager",
                60000, 15000, 6000, 3000));

        employeeList.add(new Assignment_1(102, "Rohit", "Admin",
                40000, 10000, 4000, 2000));

        employeeList.add(new Assignment_1(103, "Priya", "Accountant",
                45000, 10000, 5000, 3000));

        // Sort in descending order of bonus
        employeeList.sort((first, second) ->
                Double.compare(second.calculateBonus(), first.calculateBonus()));

        for (Assignment_1 employee : employeeList) {
            employee.displayDetails();
        }
    }
}
package com.registeration_employees.Employee_Registeration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// This annotation indicates that this class will handle HTTP requests (REST API)
@RestController
public class EmpController {

    // A list to store Employee objects in memory. This is like a simple database for now.
    List<Employee> employees = new ArrayList<>();

    // This method handles GET requests to the /employees endpoint.
    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return employees;  // Return the list of employees
    }

    // This method handles POST requests to the /employees endpoint.
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) { //accepts an Employee object in the request body and adds it to the list,
        employees.add(employee);
        return "saved";
    }
}


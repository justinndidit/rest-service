package com.example.rest_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.context.annotation.RequestScope;

import com.example.rest_service.model.Employee;
import com.example.rest_service.services.EmployeeService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
// import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    @GetMapping()
    public ResponseEntity<?> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/path")
    public void getMethodName(@RequestHeader Object req) {
        System.out.println(req);
    }
    

    @PostMapping()
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
    
    
}

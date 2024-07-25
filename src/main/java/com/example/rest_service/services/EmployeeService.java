package com.example.rest_service.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.example.rest_service.mockDatabase.Employees;
import com.example.rest_service.model.Employee;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final Employees employees;
    
    public ResponseEntity<?> getAllEmployees() {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        try {
            List<Employee> employee = employees.getEmployees();

            if(employee.size() >= 0) {
                status = HttpStatus.OK;
                return new ResponseEntity<>(employee, status);
            } 

            throw new IllegalStateException("Something went wrong");
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), status);
        }
    }

    public ResponseEntity<?> addEmployee(Employee employee) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            if(employee.getEmployee_id() == null || 
                employee.getFirst_name() == null || 
                employee.getLast_name() == null || 
                employee.getEmail() == null || 
                employee.getTitle() == null){
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                throw new IllegalStateException("Employee ID cannot be null");
            }

            status = HttpStatus.OK;
            employees.getEmployees().add(employee);
            return new ResponseEntity<>("Employee added successfully", status);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), status);
        }
    }


}

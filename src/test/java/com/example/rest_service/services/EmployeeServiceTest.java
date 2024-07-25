package com.example.rest_service.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.rest_service.mockDatabase.Employees;
import com.example.rest_service.model.Employee;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private Employees employees;

    private List<Employee> employeeList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeList = new ArrayList<>();
        when(employees.getEmployees()).thenReturn(employeeList);
    }

    @Test
    public void getAllEmployees_Success() {
        employeeList.add(new Employee(1L, "Joseph", "Smith", "josephsmith@gmail.com", "Mr"));

        ResponseEntity<?> response = employeeService.getAllEmployees();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employeeList, response.getBody());
    }

    @Test
    public void getAllEmployees_Failure() {
        when(employees.getEmployees()).thenThrow(new RuntimeException("Database connection failed"));

        ResponseEntity<?> response = employeeService.getAllEmployees();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Database connection failed", response.getBody());
    }

    @Test
    public void addEmployee_Success() {
        Employee employee = new Employee(1L, "Joseph", "Smith", "josephsmith@gmail.com", "Mr");

        ResponseEntity<?> response = employeeService.addEmployee(employee);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Employee added successfully", response.getBody());
    }

    @Test
    public void addEmployee_NullFields() {
        Employee employee = new Employee(null, "Joseph", "Smith", "josephsmith@gmail.com", "Mr");

        ResponseEntity<?> response = employeeService.addEmployee(employee);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Employee ID cannot be null", response.getBody());
    }

}

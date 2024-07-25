package com.example.rest_service.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.rest_service.mockDatabase.Employees;
import com.example.rest_service.model.Employee;

public class EmployeeManagerTest {

    @Mock
    private Employees employees;

    @InjectMocks
    private EmployeeManager employeeManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        List<Employee> employeeList = new ArrayList<>();
        when(employees.getEmployees()).thenReturn(employeeList);
    }

    @Test
    void testLoadEmployees() {
        employeeManager.loadEmployees();

        List<Employee> employeeList = employees.getEmployees();
        assertEquals(4, employeeList.size());

        assertEquals(new Employee(1L, "Joseph", "Smith", "josephsmith@gmail.com", "Mr"), employeeList.get(0));
        assertEquals(new Employee(2L, "Sandra", "Olalere", "sandraolalere@gmail.com", "Mrs"), employeeList.get(1));
        assertEquals(new Employee(3L, "Yemi", "Aderounmu", "yemirounmu@gmail.com", "Dr"), employeeList.get(2));
        assertEquals(new Employee(4L, "Oluwadunsin", "Oluwaleye", "dunny@gmail.com", "Mr"), employeeList.get(3));
    }
}

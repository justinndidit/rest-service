package com.example.rest_service.manager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.rest_service.mockDatabase.Employees;
import com.example.rest_service.model.Employee;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements CommandLineRunner {
    private final Employees employees;


    public void loadEmployees() {
        employees.getEmployees().add(employeeBuilder(1L, "Joseph", "Smith"  , "josephsmith@gmail.com" , "Mr" ));
        employees.getEmployees().add(employeeBuilder(2L, "Sandra", "Olalere"  , "sandraolalere@gmail.com" , "Mrs" ));
        employees.getEmployees().add(employeeBuilder(3L, "Yemi", "Aderounmu"  , "yemirounmu@gmail.com" , "Dr" ));
        employees.getEmployees().add(employeeBuilder(4L, "Oluwadunsin", "Oluwaleye"  , "dunny@gmail.com" , "Mr" ));
    }


    private Employee employeeBuilder(Long employee_id, String employee_firstName, String employee_lastName, String employee_email, String employee_title) {
        return Employee.builder()
                .employee_id(employee_id)
                .first_name(employee_firstName)
                .last_name(employee_lastName)
                .email(employee_email)
                .title(employee_title)
                .build();
    }

    @Override
    public void run(String... args) throws Exception {
        loadEmployees();
        System.out.println("Employees loaded");
        System.out.println(employees.getEmployees().size());
    }
}

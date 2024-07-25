package com.example.rest_service.mockDatabase;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.example.rest_service.model.Employee;

@Data
public class Employees {
    private List<Employee> employees = new ArrayList<Employee>();
}

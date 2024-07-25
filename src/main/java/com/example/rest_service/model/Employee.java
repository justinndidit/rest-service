package com.example.rest_service.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private Long employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String title;
}

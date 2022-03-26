package com.example.rediscrudspringbootexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    private Integer empId;
    private String empName;
    private Double empSalary;
}

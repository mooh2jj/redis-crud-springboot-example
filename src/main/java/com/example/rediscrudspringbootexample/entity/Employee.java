package com.example.rediscrudspringbootexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Employee")
public class Employee implements Serializable {

    @Id
    private Integer empId;
    private String empName;
    private Double empSalary;
}

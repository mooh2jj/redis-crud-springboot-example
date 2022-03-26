package com.example.rediscrudspringbootexample.repository;

import com.example.rediscrudspringbootexample.entity.Employee;

import java.util.Map;

public interface IEmployeeDao {

    Boolean saveEmployee(Employee emp);
    Employee getOneEmployee(Integer id);
    void updateEmployee(Employee emp);
    Map<Integer, Employee> getAllEmployees();
    String deleteEmployee(Integer id);
    void saveAllEmployees(Map<Integer, Employee> map);
}

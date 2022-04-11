package com.example.rediscrudspringbootexample.controller;

import com.example.rediscrudspringbootexample.entity.Employee;
import com.example.rediscrudspringbootexample.repository.IEmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class RestApiController {

    @Autowired
    private IEmployeeDao dao;

    @PostMapping
    public String saveEmployee(@RequestBody Employee employee) {
        if (dao.saveEmployee(employee)) {
            return "직원이 입력되었습니다.";
        }
        return "직웝 입력이 실패하였습니다.";
    }

    @GetMapping
    public Map<Integer, Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    // Employee getOneEmployee(Integer id);
    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "Employee", unless = "#result.empSalary > 2400")        // 2400 이상인 emp는 캐시에 넣지 않는다.
    public Employee getOneEmployee(@PathVariable int id) {
        return dao.getOneEmployee(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id", value = "Employee")        // redis 캐시에서 삭제 #id(redis키까지)
    public String deleteEmployee(@PathVariable int id) {
        return dao.deleteEmployee(id);
    }
}

package com.denizci155.cruddemo.dao;

import com.denizci155.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO  {

    List<Employee> findAll();


    Employee findById(int theId);


    Employee save(Employee theEmployee);

    void deleteById(int theId);

}

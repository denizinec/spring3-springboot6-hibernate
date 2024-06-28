package com.denizci155.cruddemo.service;

import com.denizci155.cruddemo.dao.EmployeeRepository;
import com.denizci155.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){

        employeeRepository = theEmployeeRepository;

    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()){

            theEmployee = result.get();

        } else {

            // couldn't find the employee

            throw new RuntimeException("Did not find the employee id - " + theId);

        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    } 
    
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);

    }
}

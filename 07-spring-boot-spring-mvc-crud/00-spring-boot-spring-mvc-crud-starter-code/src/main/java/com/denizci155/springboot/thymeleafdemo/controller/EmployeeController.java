package com.denizci155.springboot.thymeleafdemo.controller;

import com.denizci155.springboot.thymeleafdemo.entity.Employee;
import com.denizci155.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

        private EmployeeService employeeService;


        public EmployeeController(EmployeeService theEmployeeService){

            employeeService = theEmployeeService;

        }

        // add mapping for the /list


        @GetMapping("/list")
        public String listEmployees(Model theModel){

                // get the employees from db
                List<Employee> theEmployees = employeeService.findAll();

                // add to the spring model

                theModel.addAttribute("employees",theEmployees);

                return "employees/list-employees";

        }
        @GetMapping("/showFormAdd")
        public String showFormAdd(Model theModel) {

                Employee theEmployee = new Employee();
                theModel.addAttribute("employee", theEmployee);
                return "employees/employee-form";
        }

        @PostMapping("/save")
        public String saveEmployee(@ModelAttribute("employee") Employee theModel) {

                employeeService.save(theModel);

            return "redirect:/employees/list";
        }


}

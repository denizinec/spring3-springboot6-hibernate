package com.denizci155.springboot.thymeleafdemo.controller;


import com.denizci155.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){


        // creating the student object

        Student theStudent = new Student();

        // add student object to the model

        theModel.addAttribute("student",theStudent);


        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student")Student theStudent){

        // logging

        System.out.println("theName: " + theStudent.getFirstName() +  " " + theStudent.getLastName());



        return "student-confirmation";

    }



}

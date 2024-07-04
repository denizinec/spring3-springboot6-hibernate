package com.denizci155.springboot.thymeleafdemo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";

    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";

    }

    // need a controller to read form data and
    // add data to the model

    @RequestMapping("/processFormVersionTwo")

    public String letsShoutDude (HttpServletRequest request, Model model){
        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        // convert the data to uppercase
        theName = theName.toUpperCase();
        // create the message
        String result = "Yo! " + theName;
        // add message to the model
        model.addAttribute("message",result);
        return "helloworld"; }


    @RequestMapping("/processFormVersionThree")

    public String processFormVersionThree (@RequestParam("studentName") String theName, Model model){

        // convert the data to uppercase
        theName = theName.toUpperCase();
        // create the message
        String result = "Hey My Friend from v3! " + theName;
        // add message to the model
        model.addAttribute("message",result);
        return "helloworld"; }
}


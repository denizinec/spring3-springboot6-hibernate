package com.denizci155.springcoredemo.rest;

import com.denizci155.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for dependency

    private Coach myCoach;


    //Setter function could be anything ex, "doSomeStuff" instead of "setCoach"
    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;


    }


    @GetMapping("/dailyworkout")   
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


}

package com.denizci155.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint url for "teaminfo"

    @GetMapping("/teaminfo")
    public String getTeamInfo() {

        return "Coach: " + coachName + ", Team: " + teamName;

    }

    // expose "/" that return "Hello World"

    @GetMapping("/")
    public String sayHello() {

        return "Hello World!";


    }
    @GetMapping("/workout")
    public String getDailyWorkout() {

        return "Run a hard 5k!";

    }

    @GetMapping("/fortune")
    public String getDailyFortune() {

        return "You hit a million!! How lucky you are!";

    }




}

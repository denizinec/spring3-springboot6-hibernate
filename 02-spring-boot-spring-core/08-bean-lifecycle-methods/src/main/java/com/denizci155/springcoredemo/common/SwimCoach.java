package com.denizci155.springcoredemo.common;

public class SwimCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Swim for 40 minutes!";
    }
}

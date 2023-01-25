package com.cesar.habittracker.exception;

public class HabitNotFoundException extends RuntimeException{

    public HabitNotFoundException (Long id){
        super("Could not find the habit with the id " +id);
    }
}

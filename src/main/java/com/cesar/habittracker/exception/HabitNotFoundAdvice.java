package com.cesar.habittracker.exception;

import com.cesar.habittracker.model.Habit;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HabitNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(HabitNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(HabitNotFoundException exception){
    Map<String,String> errorMap = new HashMap<>();
    errorMap.put("errorMessage",exception.getMessage());
    return errorMap;
    }


}

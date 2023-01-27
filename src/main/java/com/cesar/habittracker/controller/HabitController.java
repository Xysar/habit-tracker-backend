package com.cesar.habittracker.controller;

import com.cesar.habittracker.exception.HabitNotFoundException;
import com.cesar.habittracker.model.Habit;
import com.cesar.habittracker.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("https://habit-tracker-frontend-production.up.railway.app/")
public class HabitController {

    @Autowired
    private HabitRepository habitRepository;

    @PostMapping("/habit")
    Habit newHabit(@RequestBody Habit newHabit){
        return habitRepository.save(newHabit);
    }

    @GetMapping("/habits")
    List<Habit> getAllHabits(){
        return habitRepository.findAll();
    }

    @GetMapping("/habit/{id}")
    Habit getHabit(@PathVariable("id") Long id){
        Optional<Habit> optionalHabit= habitRepository.findById(id);
        if(!optionalHabit.isPresent()){
            throw new HabitNotFoundException(id);
        }
        Habit habit = optionalHabit.get();
        return habit;
    }



    @PutMapping("/habit/{id}")
    public Habit updateHabit(@PathVariable("id") Long id, @RequestBody Habit updatedHabit){
        Optional<Habit> optionalHabit = habitRepository.findById(id);
        if(!optionalHabit.isPresent()){
            throw new HabitNotFoundException(id);
        }
        Habit habit = optionalHabit.get();
        habit.setHabit(updatedHabit.getHabit());
        habit.setStreak((updatedHabit.getStreak()));
        habit.setDoneToday((updatedHabit.getDoneToday()));
        habit.setLastDateModified(updatedHabit.getLastDateModified());
        habit.setColor((updatedHabit.getColor()));
        habit.setDatesModified((updatedHabit.getDatesModified()));
        return habitRepository.save(habit);
    }

    @DeleteMapping("/habit/{id}")
    public Habit deleteHabit(@PathVariable("id") Long id){
        Optional<Habit> toDeleteHabit = habitRepository.findById(id);
        if(!toDeleteHabit.isPresent()){
            throw new HabitNotFoundException(id);
        }
        Habit habit = toDeleteHabit.get();
       habitRepository.delete(habit);
       return habit;
    }

}

package com.cesar.habittracker.repository;

import com.cesar.habittracker.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit,Long> {

}

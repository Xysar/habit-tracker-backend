package com.cesar.habittracker.model;

import jakarta.persistence.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Habit {

    @GeneratedValue
    @Id
    private Long id;
    private String habit;
    private Integer streak;
    private Boolean doneToday;
    private String color;

    public List<String> getDatesModified() {
        return datesModified;
    }

    public void setDatesModified(List<String> datesModified) {
        this.datesModified = datesModified;
    }


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="listOfHabits")
    private List<String> datesModified;
    public String getLastDateModified() {
        return lastDateModified;
    }

    public void setLastDateModified(String lastDateModified) {
        this.lastDateModified = lastDateModified;
    }

    private String lastDateModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public Integer getStreak() {
        return streak;
    }

    public void setStreak(Integer streak) {
        this.streak = streak;
    }

    public Boolean getDoneToday() {
        return doneToday;
    }

    public void setDoneToday(Boolean doneToday) {
        this.doneToday = doneToday;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

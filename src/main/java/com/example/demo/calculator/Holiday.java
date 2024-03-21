package com.example.demo.calculator;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Holiday implements HolidayInterface{

    private List<DayOfWeek> weekend = new ArrayList<>();

    private List<LocalDate> holidays = new ArrayList<>();
    private  LocalDate changeDate(LocalDate date){
        return LocalDate.of(0,date.getMonth(),date.getDayOfMonth());
    }
    public Holiday(List<DayOfWeek> days, List<LocalDate> holidays){
        weekend.addAll(days);
        holidays.addAll(holidays.stream().map(this::changeDate).collect(Collectors.toList()));
    }
    public int isHolidayOrWeekend(List<LocalDate> date) {

        return (int) date
                .stream()
                .filter(x -> weekend.contains(x.getDayOfWeek())
                        || holidays.contains(changeDate(x))
                )
                .count();

    }
}

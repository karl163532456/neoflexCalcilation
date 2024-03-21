package com.example.demo.calculator;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    @Bean
    public HolidayInterface holiday(){
        List<DayOfWeek> days= List.of( DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        List<LocalDate > holidays=new ArrayList<>();
        holidays.add(LocalDate.of(1,1,1));
        return new Holiday(days,holidays);
    }
    @Bean
    public Calculationable calculation(){
        return (x,y,z)-> x/31*(y-z);
    }

}

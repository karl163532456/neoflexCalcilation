package com.example.demo.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalculationService implements CalculationServiceInterface {
    @Autowired
    Calculationable calculation;
    @Autowired
    Calculationable calculationWithoutDates;
    @Autowired
    HolidayInterface holiday;
    @Override
    public double calculateVacationPay(double averageSalary, int vacationDays,
                                       List<LocalDate> date) {
        int daysNotWorking=0;
        if(date!=null) {
            daysNotWorking = holiday.isHolidayOrWeekend(date);
        }
        return calculation.calculation(averageSalary,vacationDays,daysNotWorking);
    }

}
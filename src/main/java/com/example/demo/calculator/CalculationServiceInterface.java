package com.example.demo.calculator;

import java.time.LocalDate;
import java.util.List;

public interface CalculationServiceInterface {
    double calculateVacationPay(double averageSalary, int vacationDays,
                                List<LocalDate> date);
}

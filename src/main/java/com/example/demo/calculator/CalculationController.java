package com.example.demo.calculator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
public class CalculationController {
    @Autowired
    private CalculationServiceInterface calculateService;


    @GetMapping("/calculate")
    public ResponseEntity<Double> calculateVacationPay(double averageSalary, int vacationDays,
                                                       String dates) {
        List<LocalDate> listDates=null;

        if (dates != null) {
            try {
                listDates = Stream.of(dates.trim().split(" "))
                        .map(LocalDate::parse)
                        .collect(Collectors.toList());

            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        double res = calculateService.calculateVacationPay(averageSalary, vacationDays, listDates);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }


}


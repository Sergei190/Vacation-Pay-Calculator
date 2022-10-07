package ru.neoflex.vacationpaycalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.vacationpaycalculator.service.VacationPayCalculatorService;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class VacationPayCalculatorController {

    private final VacationPayCalculatorService vacationPayCalculatorService;

    @Autowired
    public VacationPayCalculatorController(VacationPayCalculatorService vacationPayCalculatorService) {
        this.vacationPayCalculatorService = vacationPayCalculatorService;
    }

    @GetMapping("/calculacte")
    public BigDecimal getVacationPay(
            @RequestParam("averageSalary") BigDecimal averageSalaryPerYear,
            @RequestParam("vacationDays") int vacationDays
    ) {
        return vacationPayCalculatorService.getVacationPayCalculation(averageSalaryPerYear, vacationDays);
    }
}

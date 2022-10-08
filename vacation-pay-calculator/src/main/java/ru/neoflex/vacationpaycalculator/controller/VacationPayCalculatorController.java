package ru.neoflex.vacationpaycalculator.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.vacationpaycalculator.service.vacation.VacationPayCalculatorService;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class VacationPayCalculatorController {

    private final VacationPayCalculatorService vacationPayCalculatorService;

    public VacationPayCalculatorController(VacationPayCalculatorService vacationPayCalculatorService) {
        this.vacationPayCalculatorService = vacationPayCalculatorService;
    }

    @GetMapping("/calculacte")
    public BigDecimal getVacationPay(
            @RequestParam("averageSalary") BigDecimal averageSalaryPerYear,
            @RequestParam("vacationDays") int vacationDays,
            @RequestParam("startVacationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startVacationDate,
            @RequestParam("endVacationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endVacationDate

    ) {
        return vacationPayCalculatorService.getVacationPayCalculation(averageSalaryPerYear, vacationDays, startVacationDate, endVacationDate);
    }
}

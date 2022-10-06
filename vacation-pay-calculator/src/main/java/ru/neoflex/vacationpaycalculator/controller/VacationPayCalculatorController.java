package ru.neoflex.vacationpaycalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationPayCalculatorController {

    @GetMapping("/calculacte")
    public String getVacationPay() {
        return "test";
    }
}

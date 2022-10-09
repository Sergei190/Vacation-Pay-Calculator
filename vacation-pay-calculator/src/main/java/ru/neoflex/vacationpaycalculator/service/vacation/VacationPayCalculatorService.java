package ru.neoflex.vacationpaycalculator.service.vacation;

import java.math.BigDecimal;

public interface VacationPayCalculatorService {

    BigDecimal getVacationPayCalculation(BigDecimal averageSalaryPerYear,
                                         int vacationDays);
}

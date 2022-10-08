package ru.neoflex.vacationpaycalculator.service.vacation;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface VacationPayCalculatorService {

    BigDecimal getVacationPayCalculation(BigDecimal averageSalaryPerYear,
                                         int vacationDays,
                                         LocalDate startVacationDate,
                                         LocalDate endVacationDate);
}

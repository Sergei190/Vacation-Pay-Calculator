package ru.neoflex.vacationpaycalculator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
public class VacationPayCalculatorService {

    public final static int CURRENT_YEAR = LocalDate.now().getYear();

    private static final double AVERAGE_NUMBER_DAYS_IN_MOUNT = 29.3;
    private static final double NDFL_PERCENT = 0.13;

    /**
     * Функция для расчёта отпускных сотрудника
     * @param averageSalaryPerYear - средняя зарплата за 12 месяцев
     * @param vacationDays - количество дней отпуска
     * @return возвращает сумму отпускных, которые придут сотруднику
     */
    public BigDecimal getVacationPayCalculation(BigDecimal averageSalaryPerYear,
                                                int vacationDays) {

        BigDecimal averageEarningsPerDay = averageSalaryPerYear.divide(BigDecimal.valueOf(AVERAGE_NUMBER_DAYS_IN_MOUNT), 2, RoundingMode.HALF_EVEN);
        log.info("Средний дневной заработок = {}", averageEarningsPerDay);

        BigDecimal totalPayWithoutNDFL = averageEarningsPerDay.multiply(BigDecimal.valueOf(vacationDays));
        log.info("Сумма отпускных без вычета НДФЛ = {}", totalPayWithoutNDFL);

        BigDecimal amountNDFL = totalPayWithoutNDFL.multiply(BigDecimal.valueOf(NDFL_PERCENT)).setScale(0, RoundingMode.HALF_UP);
        log.info("Сумма НДФЛ = {}", amountNDFL);

        BigDecimal totalPay = totalPayWithoutNDFL.subtract(amountNDFL);
        log.info("К выплате с вычетом НДФЛ = {}", totalPay);

        return totalPay;
    }

    public Set<LocalDate> getHolidaysSet() {
        Set<LocalDate> holidays = Stream.of(
                LocalDate.of(CURRENT_YEAR, 1, 1),
                LocalDate.of(CURRENT_YEAR, 1, 2),
                LocalDate.of(CURRENT_YEAR, 1, 3),
                LocalDate.of(CURRENT_YEAR, 1, 4),
                LocalDate.of(CURRENT_YEAR, 1, 5),
                LocalDate.of(CURRENT_YEAR, 1, 6),
                LocalDate.of(CURRENT_YEAR, 1, 7),
                LocalDate.of(CURRENT_YEAR, 1, 8),
                LocalDate.of(CURRENT_YEAR, 2, 23),
                LocalDate.of(CURRENT_YEAR, 8, 3),
                LocalDate.of(CURRENT_YEAR, 1, 5),
                LocalDate.of(CURRENT_YEAR, 6, 12),
                LocalDate.of(CURRENT_YEAR, 11, 4)
        ).collect(Collectors.toSet());

        return Collections.unmodifiableSet(holidays);
    }
}

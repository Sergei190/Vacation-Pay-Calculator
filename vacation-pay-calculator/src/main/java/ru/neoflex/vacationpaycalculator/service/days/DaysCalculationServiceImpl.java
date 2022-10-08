package ru.neoflex.vacationpaycalculator.service.days;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
public class DaysCalculationServiceImpl implements DaysCalculationService {

    /**
     * Текущий год
     */
    public final static int CURRENT_YEAR = LocalDate.now().getYear();

    /**
     * Метод для расчёта количества оплачиваемых дней в отпуске с учётом праздников и выходных
     * @param vacationDays      - общее количество дней отпуска
     * @param startVacationDate - дата начала отпуска
     * @param endVacationDate   - дата завершения отпуска
     * @return возвращает количество оплачиваемых дней отпуска
     */
    @Override
    public int calculatePaidDays(int vacationDays,
                                 LocalDate startVacationDate,
                                 LocalDate endVacationDate) {
        return 0;
    }

    /**
     * Метод для хранения праздничных дней в формате LocalDate
     * @return возвращает множество Set, состоящее из праздничных дней
     */
    public Set<LocalDate> getHolidays() {
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

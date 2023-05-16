package ru.test.neo_study_test.services;

import org.springframework.stereotype.Component;
import ru.test.neo_study_test.config.AppProperties;
import ru.test.neo_study_test.forms.DataForm;

import java.time.Period;

@Component
public class CalculationServiceImpl implements CalculationService {
    private final AppProperties appProperties;

    public CalculationServiceImpl(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public String calculateVacationPay(DataForm dataForm) {
        // Чтобы рассчитать примерную сумму отпускных, нужно разделить зарплату
        // на 29,3 (среднее число дней в месяце) и умножить на количество дней отпуска.
        int vacationDaysCount = Period.between(dataForm.getVacationStart(), dataForm.getVacationEnd())
                .getDays();
        return String.format("%.2f", dataForm.getAverageSalary() / appProperties.getAverageNumberOfDaysInMonth()
                * vacationDaysCount);
    }
}

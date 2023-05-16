package ru.test.neo_study_test.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.test.neo_study_test.config.AppProperties;
import ru.test.neo_study_test.forms.DataForm;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CalculationServiceImplTest {
    @Mock
    private AppProperties appProperties;
    @InjectMocks
    private CalculationServiceImpl calculationServiceImpl;

    @Test
    void calculationCorrectnessTest() {
        given(appProperties.getAverageNumberOfDaysInMonth()).willReturn(29.3f);
        String expectedValue = "17064,85";
        DataForm dataForm = new DataForm(100000d,
                LocalDate.of(2023, 05, 10),
                LocalDate.of(2023, 05, 15));
        String actualValue = calculationServiceImpl.calculateVacationPay(dataForm);

        Assertions.assertThat(expectedValue).isEqualTo(actualValue);
    }
}
package ru.test.neo_study_test.services;

import org.springframework.stereotype.Service;
import ru.test.neo_study_test.forms.DataForm;

@Service
public interface CalculationService {
    String calculateVacationPay(DataForm dataForm);
}

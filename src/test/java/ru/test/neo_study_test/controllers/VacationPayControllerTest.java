package ru.test.neo_study_test.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.test.neo_study_test.forms.DataForm;
import ru.test.neo_study_test.services.CalculationService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VacationPayController.class)
class VacationPayControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    CalculationService calculationService;

    @Test
    void getForm() throws Exception {
        mvc.perform(get("/payments/vacation"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }

    @Test
    void calculateVacationPay() throws Exception {
        mvc.perform(post("/payments/vacation")
                        .param("averageSalary", "100000")
                        .param("vacationStart", "2023-05-09")
                        .param("vacationEnd", "2023-05-23"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/payments/vacation"));
    }
}
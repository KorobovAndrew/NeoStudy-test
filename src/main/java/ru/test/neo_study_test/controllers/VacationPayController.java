package ru.test.neo_study_test.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.test.neo_study_test.forms.DataForm;
import ru.test.neo_study_test.services.CalculationService;

@Controller
public class VacationPayController {

    private final CalculationService calculationService;

    public VacationPayController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/payments/vacation")
    public String getForm() {
        return "VacationPayForm";
    }

    @PostMapping("/payments/vacation")
    public String calculateVacationPay(@Valid DataForm dataForm,
                                       BindingResult result,
                                       RedirectAttributes forRedirectModel) {
        if (result.hasErrors() || dataForm.hasErrors()) {
            forRedirectModel.addFlashAttribute("errors", "Errors when filling out the form!");
            return "redirect:/payments/vacation";
        }
        String vacationPayAmount = calculationService.calculateVacationPay(dataForm);
        forRedirectModel.addFlashAttribute("vacationPayAmount", vacationPayAmount);
        return "redirect:/payments/vacation";
    }
}
package ru.test.neo_study_test.forms;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataForm {
    @NotNull
    @PositiveOrZero
    private Double averageSalary;
    @NotNull
    private LocalDate vacationStart;
    @NotNull
    private LocalDate vacationEnd;

    public boolean hasErrors() {
        return (this.getVacationStart().isAfter(this.getVacationEnd())
                || this.getVacationStart().equals(this.getVacationEnd()));
    }
}
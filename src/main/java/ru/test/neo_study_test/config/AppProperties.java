package ru.test.neo_study_test.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application")
@Data
public class AppProperties {
    private float averageNumberOfDaysInMonth;
}

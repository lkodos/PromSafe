package ru.lkodos.promsafe.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record AppProperties(
        int questionsAmtGroup3,
        int questionsAmtGroup4
) {
}

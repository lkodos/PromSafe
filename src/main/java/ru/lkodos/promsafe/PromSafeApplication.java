package ru.lkodos.promsafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PromSafeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PromSafeApplication.class, args);
    }

}

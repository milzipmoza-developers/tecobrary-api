package dev.milzipmoza.tecobrary;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class TecobraryBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(TecobraryBatchApplication.class, args);
    }

}

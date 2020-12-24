package dev.milzipmoza.tecobrary.core.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"dev.milzipmoza.tecobrary.core.client"})
public class OpenFeignConfiguration {
}

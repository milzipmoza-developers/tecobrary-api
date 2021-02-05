package dev.milzipmoza.tecobrary.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;
import java.util.Optional;

@Slf4j
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {

    public static final String AUDITOR_SYSTEM = "SYSTEM";

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of(
                Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                        .map(Principal::getName)
                        .orElse(AUDITOR_SYSTEM)
        );
    }
}

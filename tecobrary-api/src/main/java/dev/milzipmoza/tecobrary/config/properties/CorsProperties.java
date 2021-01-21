package dev.milzipmoza.tecobrary.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "cors")
public class CorsProperties {

    private Allowed allowed;
    private String registerUrlPattern;

    public List<String> getAllowedOrigins() {
        return allowed.getOrigins();
    }

    public List<String> getAllowedHeaders() {
        return allowed.getHeaders();
    }

    public List<String> getAllowedMethods() {
        return allowed.getMethods();
    }

    @Getter
    @Setter
    public static class Allowed {
        private List<String> origins;
        private List<String> headers;
        private List<String> methods;
    }
}

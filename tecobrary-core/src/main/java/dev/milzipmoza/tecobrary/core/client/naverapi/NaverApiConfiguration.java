package dev.milzipmoza.tecobrary.core.client.naverapi;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NaverApiConfiguration {

    public static final String X_NAVER_CLIENT_ID = "X-Naver-Client-Id";
    public static final String X_NAVER_CLIENT_SECRET = "X-Naver-Client-Secret";
    private final String clientId;
    private final String clientSecret;

    public NaverApiConfiguration(@Value("${naver-api.client-id}") String clientId,
                                 @Value("${naver-api.client-secret}") String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Bean
    public RequestInterceptor header() {
        return template -> {
            template.header(X_NAVER_CLIENT_ID, clientId);
            template.header(X_NAVER_CLIENT_SECRET, clientSecret);
        };
    }
}

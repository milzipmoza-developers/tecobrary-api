package dev.milzipmoza.tecobrary.config;

import dev.milzipmoza.tecobrary.config.filter.CorsFilterConfig;
import dev.milzipmoza.tecobrary.security.service.GithubOAuth2UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * spring security configuration
     *
     * @see CorsFilterConfig
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // cors 설정
        http.cors();

        // csrf 비활성화
        http.csrf().disable();

        http.headers().frameOptions().sameOrigin();

        // 인증 정책 대상 endpoint
        http.authorizeRequests()
                .antMatchers("/", "/auth/**", "/oauth2/**", "/h2-console/**").permitAll()
                .anyRequest().authenticated();

        // 세션 비활성화
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // http basic auth 비활성화
        http.httpBasic().disable();

        // form 로그인 비활성화
        http.formLogin().disable();

        // oauth2 로그인 설정
        http.oauth2Login()
                .userInfoEndpoint().userService(githubOAuth2UserDetailService());
    }

    @Bean
    GithubOAuth2UserDetailService githubOAuth2UserDetailService() {
        return new GithubOAuth2UserDetailService();
    }
}

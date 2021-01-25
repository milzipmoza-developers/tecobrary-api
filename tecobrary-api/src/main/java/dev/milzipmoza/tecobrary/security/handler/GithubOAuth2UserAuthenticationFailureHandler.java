package dev.milzipmoza.tecobrary.security.handler;

import dev.milzipmoza.tecobrary.security.utils.CookieUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static dev.milzipmoza.tecobrary.security.repository.HttpCookieOAuth2AuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME;

public class GithubOAuth2UserAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String targetUri = Optional.ofNullable(CookieUtils.get(request, REDIRECT_URI_PARAM_COOKIE_NAME))
                .map(Cookie::getValue)
                .orElse("/");

        String targetUrl = UriComponentsBuilder.fromUriString(targetUri)
                .queryParam("error", exception.getLocalizedMessage())
                .build()
                .toUriString();
        super.getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}

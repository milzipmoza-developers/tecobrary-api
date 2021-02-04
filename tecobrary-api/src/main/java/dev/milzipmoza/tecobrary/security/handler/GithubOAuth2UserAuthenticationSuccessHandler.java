package dev.milzipmoza.tecobrary.security.handler;

import dev.milzipmoza.tecobrary.config.properties.OAuth2Properties;
import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberInfoDto;
import dev.milzipmoza.tecobrary.core.domain.member.service.MemberQueryService;
import dev.milzipmoza.tecobrary.security.exception.GithubOAuth2Exception;
import dev.milzipmoza.tecobrary.security.jwt.JwtAuthenticator;
import dev.milzipmoza.tecobrary.security.repository.HttpCookieOAuth2AuthorizationRequestRepository;
import dev.milzipmoza.tecobrary.security.service.GithubOAuth2User;
import dev.milzipmoza.tecobrary.security.utils.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import static dev.milzipmoza.tecobrary.security.repository.HttpCookieOAuth2AuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME;

@Slf4j
public class GithubOAuth2UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private OAuth2Properties oAuth2Properties;

    @Autowired
    private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    @Autowired
    private JwtAuthenticator jwtAuthenticator;

    @Autowired
    private MemberQueryService memberQueryService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = getTargetUrl(request, response, authentication);
        clearAuthenticationAttributes(request, response);
        super.getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    private String getTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String redirectUri = Optional.ofNullable(CookieUtils.get(request, REDIRECT_URI_PARAM_COOKIE_NAME))
                .map(Cookie::getValue)
                .orElseThrow(() -> new GithubOAuth2Exception("not allowed redirect"));

        if (!isAuthorizedUri(redirectUri)) {
            log.warn("[GithubOAuth2UserAuthenticationSuccessHandler] 허용되지 않은 리다이렉트 uri={}", redirectUri);
            throw new GithubOAuth2Exception("not allowed redirect");
        }

        GithubOAuth2User oAuth2User = (GithubOAuth2User) authentication.getPrincipal();

        Integer id = Optional.ofNullable((Integer) oAuth2User.getAttribute("id"))
                .orElseThrow(() -> new GithubOAuth2Exception("this is abnormal approach"));

        MemberInfoDto member = memberQueryService.findByProviderKey(id.toString());

        String token = jwtAuthenticator.generateToken(member);

        return UriComponentsBuilder.fromUriString(redirectUri)
                .queryParam("token", token)
                .build().toUriString();
    }

    private boolean isAuthorizedUri(String redirectUri) {
        URI clientRedirectUri = URI.create(redirectUri);

        return oAuth2Properties.getAuthorizedRedirectUri().stream()
                .anyMatch(it -> {
                    URI authorizedUri = URI.create(it);
                    return authorizedUri.getHost().equalsIgnoreCase(clientRedirectUri.getHost())
                            && authorizedUri.getPort() == clientRedirectUri.getPort();
                });
    }

    private void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
        httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request, response);
    }
}

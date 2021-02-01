package dev.milzipmoza.tecobrary.config.filter;

import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberDto;
import dev.milzipmoza.tecobrary.core.domain.member.service.MemberQueryService;
import dev.milzipmoza.tecobrary.security.jwt.JwtAuthenticator;
import dev.milzipmoza.tecobrary.security.service.GithubOAuth2User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String AUTHORIZATION_PREFIX = "Bearer ";

    @Autowired
    private JwtAuthenticator jwtAuthenticator;

    @Autowired
    private MemberQueryService memberQueryService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwt(request);

            if (StringUtils.hasText(jwt) && jwtAuthenticator.validateToken(jwt)) {
                String memberNumber = jwtAuthenticator.getMemberNumber(jwt);

                MemberDto member = memberQueryService.findByMemberNumber(memberNumber);
                GithubOAuth2User oAuth2User = GithubOAuth2User.of(member);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(oAuth2User, null, oAuth2User.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            log.error("security context set user error", e);
        }

        filterChain.doFilter(request, response);
    }

    public String getJwt(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER_KEY);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(AUTHORIZATION_PREFIX)) {
            return bearerToken.substring(AUTHORIZATION_PREFIX.length());
        }
        return null;
    }
}

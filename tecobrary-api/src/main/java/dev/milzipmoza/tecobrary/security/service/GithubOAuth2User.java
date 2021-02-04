package dev.milzipmoza.tecobrary.security.service;

import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberInfoDto;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthority;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * This is implemented class of OAuth2User interface
 *
 * @see OAuth2User
 */
public class GithubOAuth2User implements OAuth2User, UserDetails {

    private final String name;
    private final Set<GrantedAuthority> authorities;
    private final Map<String, Object> attributes;

    @Builder
    public GithubOAuth2User(String name, MemberAuthority memberAuthority, Map<String, Object> attributes) {
        this.name = name;
        this.authorities = Set.of(new SimpleGrantedAuthority(memberAuthority.getSecurityRoleName()));
        this.attributes = attributes;
    }

    public static GithubOAuth2User of(MemberInfoDto memberInfoDto) {
        return GithubOAuth2User.builder()
                .name(memberInfoDto.getName())
                .memberAuthority(memberInfoDto.getAuthority())
                .build();
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPassword() {
        return null; // todo: null 해도 되는지 체크하기
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

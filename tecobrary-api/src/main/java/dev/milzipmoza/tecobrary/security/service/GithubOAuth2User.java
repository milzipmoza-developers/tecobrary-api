package dev.milzipmoza.tecobrary.security.service;

import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthority;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * This is implemented class of OAuth2User interface
 *
 * @see OAuth2User
 */
public class GithubOAuth2User implements OAuth2User {

    private static final String NAME_ATTRIBUTE_KEY = "github";

    private final Set<GrantedAuthority> authorities;
    private final Map<String, Object> attributes;

    @Builder
    public GithubOAuth2User(MemberAuthority memberAuthority, Map<String, Object> attributes) {
        Assert.notNull(memberAuthority, "authority cannot be null");
        Assert.notEmpty(attributes, "attributes cannot be empty");
        if (!attributes.containsKey(NAME_ATTRIBUTE_KEY)) {
            throw new IllegalArgumentException("Missing attribute '" + NAME_ATTRIBUTE_KEY + "' in attributes");
        }
        this.authorities = Set.of(new SimpleGrantedAuthority(memberAuthority.getSecurityRoleName()));
        this.attributes = attributes;
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
        return this.getAttribute(NAME_ATTRIBUTE_KEY).toString();
    }
}

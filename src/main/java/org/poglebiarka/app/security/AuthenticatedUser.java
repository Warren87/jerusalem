package org.poglebiarka.app.security;

import org.poglebiarka.app.api.UserDetails;
import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticatedUser {

    private final AuthenticationContext authenticationContext;

    public AuthenticatedUser(AuthenticationContext authenticationContext) {
        this.authenticationContext = authenticationContext;
    }

    public Optional<UserDetails> get() {
        return authenticationContext.getAuthenticatedUser(OidcUser.class)
                .map(user -> new UserDetails(user.getEmail(),user.getName(),""));
    }

    public void logout() {
        authenticationContext.logout();
    }

}

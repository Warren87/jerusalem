package org.poglebiarka.app.api;

import org.poglebiarka.app.PublicEndpoint;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.security.AuthenticationContext;
import dev.hilla.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.Optional;

@Endpoint("auth")
@AnonymousAllowed
public class AuthEndpoint {

    private static final Logger log = LoggerFactory.getLogger(AuthEndpoint.class);

    private final AuthenticationContext authenticationContext;

    public AuthEndpoint(AuthenticationContext authenticationContext) {
        this.authenticationContext = authenticationContext;
    }

    @PublicEndpoint
    public Optional<UserDetails> authenticatedUser() {
        return authenticationContext.getAuthenticatedUser(OidcUser.class)
                .map(user -> {
                    log.info(user.toString());
                    return new UserDetails(user.getEmail(), user.getFullName(),"");
                });
    }

}

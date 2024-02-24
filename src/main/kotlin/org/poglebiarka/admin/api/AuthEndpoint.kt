package org.poglebiarka.admin.api

import com.vaadin.flow.server.auth.AnonymousAllowed
import com.vaadin.flow.spring.security.AuthenticationContext
import dev.hilla.Endpoint
import org.poglebiarka.admin.PublicEndpoint
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import java.util.*

@Endpoint("auth")
@AnonymousAllowed
class AuthEndpoint(val authenticationContext: AuthenticationContext) {

    @PublicEndpoint
    fun authenticatedUser(): Optional<UserDetails> =
        authenticationContext.getAuthenticatedUser(OidcUser::class.java)
            .map { UserDetails(it.email, it.fullName, "") }

}

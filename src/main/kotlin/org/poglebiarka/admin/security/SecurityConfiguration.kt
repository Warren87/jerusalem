package org.poglebiarka.admin.security;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
class SecurityConfiguration : VaadinWebSecurity() {

    override fun configure(http: HttpSecurity) {

        http.authorizeHttpRequests {
            it.requestMatchers(AntPathRequestMatcher("/images/*.png")).permitAll()
        }

        http.authorizeHttpRequests {
                it.requestMatchers(AntPathRequestMatcher("/line-awesome/**/*.svg")).permitAll()
        }

        setOAuth2LoginPage(http, "/login")
        http.logout {
            it.logoutSuccessUrl("/login").permitAll()
        }

        super.configure(http)
    }

}

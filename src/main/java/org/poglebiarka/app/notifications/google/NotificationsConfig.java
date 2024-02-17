package org.poglebiarka.app.notifications.google;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
class NotificationsConfig {

    @Bean
    NotificationClient notificationClient(
            @Value("${app.notification.url}") String baseUrl,
            @Value("${app.notification.authorization}") String authorization){
        return new NotificationClient(
                RestClient.builder()
                        .baseUrl(baseUrl)
                        .defaultHeader(AUTHORIZATION, authorization)
                        .requestFactory(new HttpComponentsClientHttpRequestFactory())
                        .build()
        );
    }
}

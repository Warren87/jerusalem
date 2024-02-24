package org.poglebiarka.admin.notifications.google

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders.AUTHORIZATION
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestClient

@Configuration
class NotificationsConfig {

    @Bean
    fun notificationClient(
        @Value("\${app.notification.url}") baseUrl: String,
        @Value("\${app.notification.authorization}") authorization: String
    ) = NotificationClient(
            RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(AUTHORIZATION, authorization)
                .requestFactory(HttpComponentsClientHttpRequestFactory())
                .build()
        )
}

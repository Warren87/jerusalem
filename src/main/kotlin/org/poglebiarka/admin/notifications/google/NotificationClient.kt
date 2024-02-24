package org.poglebiarka.admin.notifications.google

import org.poglebiarka.admin.notifications.NotificationRequest
import org.springframework.http.MediaType
import org.springframework.web.client.RestClient

class NotificationClient(val restClient: RestClient) {

    fun sendForAll(request: NotificationRequest) {
        restClient.post()
            .uri("/fcm/send")
            .contentType(MediaType.APPLICATION_JSON)
            .body(GoogleNotificationRequest.from(request))
            .retrieve()
            .toBodilessEntity()
    }

}

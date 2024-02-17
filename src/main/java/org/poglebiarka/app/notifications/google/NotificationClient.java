package org.poglebiarka.app.notifications.google;

import org.poglebiarka.app.notifications.Link;
import org.poglebiarka.app.notifications.NotificationRequest;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class NotificationClient {

    final RestClient restClient;

    public NotificationClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public void sendForAll(NotificationRequest request) {
        restClient.post()
                .uri("/fcm/send")
                .contentType(APPLICATION_JSON)
                .body(toGoogleNotificationRequest(request))
                .retrieve()
                .toBodilessEntity();
    }

    private GoogleNotificationRequest toGoogleNotificationRequest(NotificationRequest request) {
        return new GoogleNotificationRequest(
                "/topics/all",
                "high",
                new NotificationHead(
                        request.mainTitle(),
                        request.mainDescription(),
                        "default"),
                new NotificationData(
                        request.subTitle(),
                        request.subDescription(),
                        request.links().stream().map(this::toNotificationButton).toList()
                )
        );
    }

    private NotificationButton toNotificationButton(Link link) {
        return new NotificationButton(link.title(), link.url());
    }
}

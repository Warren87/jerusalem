package org.poglebiarka.app.notifications.google;

import org.poglebiarka.app.notifications.Link;
import org.poglebiarka.app.notifications.NotificationRequest;

record GoogleNotificationRequest(
        String to,
        String priority,
        NotificationHead notification,
        NotificationData data
) {

    GoogleNotificationRequest from(NotificationRequest request) {
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

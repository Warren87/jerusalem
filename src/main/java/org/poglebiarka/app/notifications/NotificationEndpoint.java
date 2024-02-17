package org.poglebiarka.app.notifications;

import dev.hilla.BrowserCallable;
import jakarta.annotation.security.PermitAll;
import org.poglebiarka.app.notifications.google.NotificationClient;

@BrowserCallable
public class NotificationEndpoint {

    private final NotificationClient notificationClient;

    public NotificationEndpoint(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    @PermitAll
    public void notifyAll(NotificationRequest request){
        notificationClient.sendForAll(request);
    }
}

package org.poglebiarka.admin.notifications

import dev.hilla.BrowserCallable
import jakarta.annotation.security.PermitAll
import org.poglebiarka.admin.notifications.google.NotificationClient
import org.poglebiarka.admin.notifications.google.SentNotification
import org.poglebiarka.admin.notifications.google.SentNotificationRepository
import java.util.*

@BrowserCallable
class NotificationEndpoint(
    val notificationClient: NotificationClient,
    val notificationRepository: SentNotificationRepository
) {

    @PermitAll
    fun notifyAll(request: NotificationRequest) {
        notificationRepository.insert(SentNotification(UUID.randomUUID(), request))
        notificationClient.sendForAll(request)
    }

    @PermitAll
    fun findAll() = notificationRepository.findAll()
}

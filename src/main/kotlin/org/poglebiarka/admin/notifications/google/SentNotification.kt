package org.poglebiarka.admin.notifications.google

import org.poglebiarka.admin.notifications.NotificationRequest
import org.springframework.data.annotation.Id
import java.util.UUID

data class SentNotification(@Id val id: UUID, val data: NotificationRequest)

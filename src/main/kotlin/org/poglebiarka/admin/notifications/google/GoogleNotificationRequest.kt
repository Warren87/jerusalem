package org.poglebiarka.admin.notifications.google

import org.poglebiarka.admin.notifications.Link
import org.poglebiarka.admin.notifications.NotificationRequest

data class GoogleNotificationRequest(
    val to: String,
    val priority: String,
    val notification: NotificationHead,
    val data: NotificationData
) {

    companion object {
        fun from(request: NotificationRequest) =
            GoogleNotificationRequest(
                "/topics/all",
                "high",
                NotificationHead(
                    request.mainTitle,
                    request.mainDescription,
                    "default"
                ),
                NotificationData(
                    request.subTitle,
                    request.subDescription,
                    request.links.stream().map { link: Link -> toNotificationButton(link) }
                        .toList()
                )
            )


        private fun toNotificationButton(link: Link): NotificationButton {
            return NotificationButton(link.title, link.url)
        }
    }



}

data class NotificationHead(val title: String, val body: String, val sound: String)

data class NotificationData(
    val title: String,
    val body: String,
    val buttons: List<NotificationButton>)

data class NotificationButton(val title: String, val url: String)
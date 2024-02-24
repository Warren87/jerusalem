package org.poglebiarka.admin.notifications

import jakarta.validation.constraints.NotBlank

data class NotificationRequest(
    val mainTitle: @NotBlank String,
    val mainDescription: @NotBlank String,
    val subTitle: @NotBlank String,
    val subDescription: @NotBlank String,
    val links: List<Link>
)

class Link(val title: String, val url: String)


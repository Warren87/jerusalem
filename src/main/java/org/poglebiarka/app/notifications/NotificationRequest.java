package org.poglebiarka.app.notifications;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record NotificationRequest(
        @NotBlank
        String mainTitle,
        @NotBlank
        String mainDescription,
        @NotBlank
        String subTitle,
        @NotBlank
        String subDescription,
        List<Link> links) {

}

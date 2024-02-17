package org.poglebiarka.app.notifications.google;

import java.util.List;

record NotificationData(String title, String body, List<NotificationButton> buttons) {
}

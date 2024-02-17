package org.poglebiarka.app.notifications.google;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.poglebiarka.app.notifications.Link;
import org.poglebiarka.app.notifications.NotificationRequest;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.fail;

@WireMockTest(httpPort = 9999)
class NotificationHeadClientTest {


    @Test
    void senForAll() {
        var notificationClient = new NotificationsConfig()
                .notificationClient("http://localhost:9999", "AUTH_KEY");

        stubFor(post("/fcm/send")
                .withHeader("Content-Type", equalTo("application/json"))
                .withHeader("Authorization", equalTo("AUTH_KEY"))
                .withRequestBody(equalToJson("""
                        {
                          "to": "/topics/all",
                          "priority": "high",
                          "notification": {
                            "title": "Testowe",
                            "body": "Test",
                            "sound": "default"
                          },
                          "data" : {
                            "title": "Inside title",
                            "body": "Everybody needs somebody",
                            "buttons": [
                                {
                                    "title": "First button",
                                    "url": "https://fake.link"
                                }, {
                                    "title": "Second button",
                                    "url": "https://anotherFake.link"
                                }
                            ]
                          }
                        }
                        """))
                .willReturn(ok()));


        var request = new NotificationRequest(
                "Testowe",
                "Test",
                "Inside title",
                "Everybody needs somebody",
                List.of(
                        new Link("First button", "https://fake.link"),
                        new Link("Second button", "https://anotherFake.link")
                ));

        try {
            notificationClient.sendForAll(request);
        } catch (HttpClientErrorException e) {
            fail(e.getMessage().replace("<EOL><EOL>", "\n"));
        }
    }

}
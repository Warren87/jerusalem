package org.poglebiarka.admin.notifications.google

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.fail
import org.junit.jupiter.api.Test
import org.poglebiarka.admin.notifications.Link
import org.poglebiarka.admin.notifications.NotificationRequest
import org.springframework.web.client.HttpClientErrorException

@WireMockTest(httpPort = 9999)
class NotificationHeadClientTest {

    @Test
    fun senForAll() {
        val notificationClient = NotificationsConfig()
            .notificationClient("http://localhost:9999", "AUTH_KEY")

        stubFor(
            post("/fcm/send")
                .withHeader("Content-Type", equalTo("application/json"))
                .withHeader("Authorization", equalTo("AUTH_KEY"))
                .withRequestBody(
                    equalToJson(
                        """
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
                        """.trimIndent()
                    )
                )
                .willReturn(ok())
        )
        val request = NotificationRequest(
            "Testowe",
            "Test",
            "Inside title",
            "Everybody needs somebody",
            listOf(
                Link("First button", "https://fake.link"),
                Link("Second button", "https://anotherFake.link")
            )
        )
        try {
            notificationClient.sendForAll(request)
        } catch (e: HttpClientErrorException) {
            fail(e.message!!.replace("<EOL><EOL>", "\n"))
        }
    }
}
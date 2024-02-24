package org.poglebiarka.admin.notifications.google

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface SentNotificationRepository : MongoRepository<SentNotification, UUID> {

}
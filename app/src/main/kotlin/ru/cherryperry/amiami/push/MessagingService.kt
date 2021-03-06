package ru.cherryperry.amiami.push

import com.google.firebase.crash.FirebaseCrash
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.android.AndroidInjection
import javax.inject.Inject

class MessagingService : FirebaseMessagingService() {

    companion object {
        const val updateTopic = "updates2"
    }

    @Inject
    lateinit var notificationController: NotificationController

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        val map = remoteMessage!!.data
        if (map != null && map.containsKey("count"))
            try {
                val count = Integer.parseInt(map["count"])
                notificationController.show(count, this)
            } catch (t: Throwable) {
                FirebaseCrash.report(t)
            }
    }
}

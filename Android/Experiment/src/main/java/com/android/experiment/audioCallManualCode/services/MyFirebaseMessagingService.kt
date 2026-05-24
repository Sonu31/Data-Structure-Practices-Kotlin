package com.android.experiment.audioCallManualCode.services

import android.content.Intent
import com.android.experiment.audioCallManualCode.IncomingCallManuallyActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        if (message.data["type"] == "CALL") {
            val callerName = message.data["callerName"]
            val roomId = message.data["roomId"]
            showIncomingCallScreen(callerName, roomId)
        }
    }

    private fun showIncomingCallScreen(callerName: String?, roomId: String?) {
        val intent = Intent(this, IncomingCallManuallyActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            putExtra("callerName", callerName)
            putExtra("roomId", roomId)
        }
        startActivity(intent)
    }
}
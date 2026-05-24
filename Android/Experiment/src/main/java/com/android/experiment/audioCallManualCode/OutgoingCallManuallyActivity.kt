package com.android.experiment.audioCallManualCode

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.experiment.R
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.RemoteMessage
import java.util.UUID

class OutgoingCallManuallyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_outgoing_call_manually)
        val receiverToken = intent.getStringExtra("receiverToken")
        val callerName = "Sonu"
        val roomId = UUID.randomUUID().toString()

        // Send FCM to receiver
        sendFCMNotification(receiverToken, callerName, "voice", roomId)
    }

    private fun sendFCMNotification(token: String?, callerName: String, callType: String, roomId: String) {
        val data = mapOf(
            "type" to "CALL",
            "callerName" to callerName,
            "callType" to callType,
            "roomId" to roomId
        )

        FirebaseMessaging.getInstance().send(
            RemoteMessage.Builder("$token@fcm.googleapis.com")
                .setMessageId(System.currentTimeMillis().toString())
                .setData(data)
                .build()
        )
    }
}
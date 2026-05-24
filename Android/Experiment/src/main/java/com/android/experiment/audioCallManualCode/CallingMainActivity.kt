package com.android.experiment.audioCallManualCode

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.experiment.audioCallManualCode.util.FCMService
import com.android.experiment.databinding.ActivityCallingMainBinding
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CallingMainActivity : AppCompatActivity() {

          //    @AndroidEntryPoint

                  //    @Inject
                  //   lateinit var logger: Logs
//                  private val studentViewModel :StudentViewModel by viewModels()


//              private const val TAG_FRAGMENT_NAME = " _SCREEN"
              var _binding: ActivityCallingMainBinding? = null
              val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCallingMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCall.setOnClickListener {
            // Call karne wale ka naam
            val callerName = "Sonu Kumar"

            // Call type
            val callType = "voice"

            // Random roomId (for future voice/video call)
            val roomId = System.currentTimeMillis().toString()

            // Jis user ko call karna hai uska token
            val receiverToken = "daGtWyWSRSaHMIpch_4vzm:APA91bELu1hgJWm7oj6OGRO1mUDGyKRaGLVcyj6CJXo6usj7LxjKyAEeTgHR7tSEiGjA_WcIoV4efOGO1ViSKKraci6PzqrhlulVM1ZWVM50y8_L1DNW2YY"

            sendCallNotification(receiverToken, callerName, callType, roomId)

           Toast.makeText(this, "Call Start", Toast.LENGTH_SHORT).show()

        }




    }

    private fun sendCallNotification(
        receiverToken: String,
        callerName: String,
        callType: String,
        roomId: String
    ) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fcm.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(FCMService::class.java)

        val data = JsonObject().apply {
            addProperty("type", "CALL")
            addProperty("callerName", callerName)
            addProperty("callType", callType)
            addProperty("roomId", roomId)
        }

        val body = JsonObject().apply {
            addProperty("to", receiverToken)
            add("data", data)
            addProperty("priority", "high")
        }

        CoroutineScope(Dispatchers.IO).launch {
            val response = service.sendNotification(body)
            if (response.isSuccessful) {
                Log.d("FCM", "Call notification sent ✅")
            } else {
                Log.e("FCM", "Failed to send: ${response.errorBody()?.string()}")
            }
        }
    }
}
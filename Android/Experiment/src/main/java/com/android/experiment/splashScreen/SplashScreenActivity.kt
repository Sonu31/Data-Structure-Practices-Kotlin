package com.android.experiment.splashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.experiment.R
import com.android.experiment.WelComeScreen
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessaging

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
//         AdsHandler.initAdConfig(this)
//              SmAdds.enabledisable(this@Splash)
//              SmAdds.showBannerAdd(this@Splash,binding.addid)
              Handler(Looper.getMainLooper()).postDelayed({
                  startActivity(Intent(this@SplashScreenActivity, WelComeScreen::class.java))
                  finish()

              }, 1000)

        // Fetch FCM Token here
        FirebaseMessaging.getInstance().token.addOnSuccessListener { token ->
            Log.d("SplashScreenActivity_TAGA"," FCM Token :- ${token}" )
            // TODO: Save token to Firestore / Realtime DB / Server
            saveTokenToFirebase(token)
        }



}

    private fun saveTokenToFirebase(token: String) {
        val userId = "1234" // Replace with your userId
        FirebaseDatabase.getInstance().getReference("users")
            .child(userId)
            .child("fcmToken")
            .setValue(token)
    }
}
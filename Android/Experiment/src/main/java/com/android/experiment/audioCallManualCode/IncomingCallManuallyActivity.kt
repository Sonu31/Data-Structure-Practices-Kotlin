package com.android.experiment.audioCallManualCode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.experiment.R

class IncomingCallManuallyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_incoming_call_manually)
        val callerName = intent.getStringExtra("callerName")
        val roomId = intent.getStringExtra("roomId")

        findViewById<TextView>(R.id.tvCallerName).text = "$callerName is calling..."

        findViewById<Button>(R.id.btnAccept).setOnClickListener {
            Log.i("IncomingCallManuallyActivity_Tag", "btnAccept: ")
         Toast.makeText(this, "Accept", Toast.LENGTH_SHORT).show()


            finish()
        }

        findViewById<Button>(R.id.btnReject).setOnClickListener {
            finish()
        }
    }
}
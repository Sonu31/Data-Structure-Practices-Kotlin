package com.android.experiment.broadcast

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.experiment.broadcast.simpleBroadcast.CustomBroadCast
import com.android.experiment.broadcast.simpleBroadcast.DynamicCustomBroadCast
import com.android.experiment.broadcast.simpleBroadcast.SimpleBroadCast
import com.android.experiment.databinding.ActivityBroadCastMainBinding


private const val TAG_FRAGMENT_NAME = " _SCREEN"

class BroadCastMainActivity : AppCompatActivity() {

    lateinit var dynamicCustomBroadCast: DynamicCustomBroadCast

          //    @AndroidEntryPoint

                  //    @Inject
                  //   lateinit var logger: Logs
//                  private val studentViewModel :StudentViewModel by viewModels()


              var _binding: ActivityBroadCastMainBinding? = null
              val binding get() = _binding!!

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBroadCastMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.btnSendbraodCast.setOnClickListener {
            val intent = Intent("MY_CUSTOM_ACTION")
            sendBroadcast(intent) // ye call ho rahi hai Activity ke context me
        }

        binding.btnSendCustombraodCast.setOnClickListener {
            var intent = Intent(this@BroadCastMainActivity, CustomBroadCast::class.java)
            intent.action = "com.android.experiment.CUSTOM_BROADCAST"
            intent.putExtra("data", "Hello Custom Broadcast")
            sendBroadcast(intent);
        }






//        val receiver: SimpleBroadCast = SimpleBroadCast()
//         val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
//        registerReceiver(receiver, filter)




        dynamicCustomBroadCast = DynamicCustomBroadCast()

        // Intent Filter
        val filter2 = IntentFilter("com.android.experiment.CUSTOM_BROADCAST")
        // Register Receiver
        registerReceiver(dynamicCustomBroadCast, filter2)

        binding.btnSendDynamicCustombraodCast.setOnClickListener {
            val intent = Intent("com.android.experiment.CUSTOM_BROADCAST")
            intent.putExtra("data", "Hello Dynamic Broadcast")
            sendBroadcast(intent)
        }



    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(dynamicCustomBroadCast)
    }
}
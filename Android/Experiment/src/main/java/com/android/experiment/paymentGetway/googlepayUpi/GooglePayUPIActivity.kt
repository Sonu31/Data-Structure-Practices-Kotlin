package com.android.experiment.paymentGetway.googlepayUpi

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.android.experiment.R
import com.android.experiment.databinding.ActivityGooglePayUpiactivityBinding

class GooglePayUPIActivity : AppCompatActivity(),     View.OnClickListener
{

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityGooglePayUpiactivityBinding
    private val UPI_PAYMENT_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGooglePayUpiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        logUpiApps()
        binding.btnPay.setOnClickListener(this)

    }

          override fun onClick(v: View?) {
             when(v?.id){
                R.id.btnPay -> {
                    payWithGooglePay()
                }
             }

         }
    private fun logUpiApps() {
        val uri = Uri.parse("upi://pay")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        val activities = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        activities.forEach {
            println("UPI_HANDLER  ${it.activityInfo.packageName}")
            Log.d("UPI_HANDLER", it.activityInfo.packageName)
        }
    }

    private fun payWithGooglePay() {
        val uri = Uri.parse("upi://pay").buildUpon()
            .appendQueryParameter("pa", "merchantupi@okaxis") // Change to actual UPI ID
            .appendQueryParameter("pn", "Merchant Name")
            .appendQueryParameter("tn", "Payment for Product")
            .appendQueryParameter("am", "10.00")
            .appendQueryParameter("cu", "INR")
            .build()



        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = uri
        intent.setPackage("com.google.android.apps.nbu.paisa.user") // Google Pay package

        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, UPI_PAYMENT_REQUEST_CODE)
        } else {
            Toast.makeText(this, "Google Pay not installed", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == UPI_PAYMENT_REQUEST_CODE) {
            val response = data?.getStringExtra("response")
            if (resultCode == RESULT_OK && response != null) {
                handleUPIResponse(response)
            } else {
                Toast.makeText(this, "Payment Cancelled or Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun handleUPIResponse(response: String) {
        val responseMap = response.split("&").associate {
            val pair = it.split("=")
            pair[0] to pair.getOrElse(1) { "" }
        }

        val status = responseMap["Status"] ?: ""
        if (status.equals("SUCCESS", ignoreCase = true)) {
            Toast.makeText(this, "Payment Success", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Payment Failed", Toast.LENGTH_LONG).show()
        }
    }


}
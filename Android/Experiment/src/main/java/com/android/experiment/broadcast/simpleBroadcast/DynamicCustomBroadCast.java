package com.android.experiment.broadcast.simpleBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DynamicCustomBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String message = intent.getStringExtra("data");

        Toast.makeText(
                context,
                "Received "+message,
                Toast.LENGTH_SHORT
        ).show();
    }
}

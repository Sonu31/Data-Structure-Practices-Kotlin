 
 

```
 return new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.small_icon_notification)
                .setColor(ContextCompat.getColor(this, R.color.blue))  // Noticaiton pe jo popo aata hai uska color chnage karna ye use  hota hia
                .setColorized(true) // for Android 8.0+ (adds tint)
                .setLargeIcon(largeIcon)
                .setSound(null)
                .setContentTitle("Varta")
                .setContentText("Sainya Sanchar")
                .setContentIntent(pendingIntent)
                .setVisibility(NotificationCompat.VISIBILITY_SECRET)
                .setSilent(true)
                .setPriority(NotificationCompat.PRIORITY_MIN)
                .build();
    }

```
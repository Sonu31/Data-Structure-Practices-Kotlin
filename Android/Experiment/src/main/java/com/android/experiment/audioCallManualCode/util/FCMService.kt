package com.android.experiment.audioCallManualCode.util

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface FCMService {
    @Headers(
        "Content-Type: application/json",
        "Authorization: key=8a8c8d33d719f3418bc24244c0391c2aa194fb76" // from Firebase console > Cloud Messaging > Server key
    )
    @POST("fcm/send")
    suspend fun sendNotification(@Body body: JsonObject): Response<JsonObject>
}
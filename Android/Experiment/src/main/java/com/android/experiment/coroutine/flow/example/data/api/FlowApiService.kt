package com.android.experiment.coroutine.flow.example.data.api

import com.android.experiment.coroutine.flow.example.data.modelDTO.QuoteResponce
import retrofit2.http.GET

interface FlowApiService {
    @GET("posts")
    suspend fun getQuotesList(): QuoteResponce
}
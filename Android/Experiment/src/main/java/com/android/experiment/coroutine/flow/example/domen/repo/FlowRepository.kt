package com.android.experiment.coroutine.flow.example.domen.repo

import com.android.experiment.coroutine.flow.example.data.modelDTO.QuoteResponce
import kotlinx.coroutines.flow.Flow

interface FlowRepository {
    fun getQuotes(): Flow<QuoteResponce>
}
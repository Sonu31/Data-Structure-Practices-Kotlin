package com.android.experiment.coroutine.flow.example.data.repoImpl

import com.android.experiment.coroutine.flow.example.data.api.FlowApiService
import com.android.experiment.coroutine.flow.example.data.modelDTO.QuoteResponce
import com.android.experiment.coroutine.flow.example.domen.repo.FlowRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FlowRepositoryImpl(private  val flowApiService: FlowApiService):
    FlowRepository {
    override fun getQuotes(): Flow<QuoteResponce> = flow {
        emit(flowApiService.getQuotesList())

    }

}
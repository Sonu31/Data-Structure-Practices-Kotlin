package com.android.experiment.coroutine.flow.example.domen.usecase

import com.android.experiment.coroutine.flow.example.domen.repo.FlowRepository

class FlowTestActivityUseCase(private  val flowRepository: FlowRepository) {
 operator  fun invoke()  = flowRepository.getQuotes()
}
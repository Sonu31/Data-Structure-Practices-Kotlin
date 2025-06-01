package com.android.experiment.coroutine.flow.example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.experiment.coroutine.flow.example.data.modelDTO.QuoteResponce
import com.android.experiment.coroutine.flow.example.domen.usecase.FlowTestActivityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch

class FlowTestViewModel(private  val flowtestactivityUsecase:FlowTestActivityUseCase):ViewModel() {

//    data class QuoteResponce(val text: String = "", val author: String = "")

    private val _quoteList =  MutableStateFlow<QuoteResponce?>(null)
    val posts: MutableStateFlow<QuoteResponce?> = _quoteList


    fun fetchPosts() {
        viewModelScope.launch {
            flowtestactivityUsecase().collect { postList ->
                _quoteList.value = postList
            }
        }
    }



}
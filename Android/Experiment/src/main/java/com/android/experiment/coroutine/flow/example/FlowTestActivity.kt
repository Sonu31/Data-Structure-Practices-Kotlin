package com.android.experiment.coroutine.flow.example

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.android.experiment.R
import com.android.experiment.coroutine.flow.example.data.api.FlowApiService
import com.android.experiment.coroutine.flow.example.data.repoImpl.FlowRepositoryImpl
import com.android.experiment.coroutine.flow.example.domen.usecase.FlowTestActivityUseCase
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FlowTestActivity : AppCompatActivity() {


    private lateinit var viewModel: FlowTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_testing)


        // Retrofit Setup
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(FlowApiService::class.java)



        // Manual Dependency Injection
        val repository = FlowRepositoryImpl(apiService)
        val useCase = FlowTestActivityUseCase(repository)
        viewModel = FlowTestViewModel(useCase)

        viewModel.fetchPosts()

        lifecycleScope.launch {
            viewModel.posts.collect { postList ->
                postList?.forEach {
                    Log.d("Posts", "Title: ${it.title}")
                }
            }
        }


    }
}
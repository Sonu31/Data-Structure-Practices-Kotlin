package com.android.experiment.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.experiment.databinding.ActivityMvvmexBinding

class MVVMExActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMvvmexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMvvmexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


    }


}